pipeline {
    agent any

    environment {
        COMPOSE_CMD = 'docker compose'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checkout source code'
                checkout scm
            }
        }

        stage('Build Images') {
            steps {
                echo 'Building Docker images'
                sh '''
                    ${COMPOSE_CMD} build tea-service prometheus grafana
                '''
            }
        }

        stage('Stop Old Containers') {
            steps {
                echo 'Stopping old containers'
                sh '''
                    ${COMPOSE_CMD} stop tea-service prometheus grafana || true
                    ${COMPOSE_CMD} rm -f tea-service prometheus grafana || true
                '''
            }
        }

        stage('Start Services') {
            steps {
                echo 'Starting services'
                sh '''
                    ${COMPOSE_CMD} up -d tea-service prometheus grafana
                '''
            }
        }

        stage('Health Check') {
            steps {
                echo 'Waiting for application health'
                sh '''
                    for i in {1..10}; do
                        if curl -sf http://localhost:8089/actuator/health > /dev/null; then
                            echo "Tea-service is UP"
                            exit 0
                        fi
                        echo "Waiting..."
                        sleep 3
                    done
                    echo "Tea-service did not start"
                    exit 1
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline finished successfully'
            echo 'Tea-service: http://localhost:8089'
            echo 'Prometheus: http://localhost:9090'
            echo 'Grafana: http://localhost:3000'
        }
        failure {
            echo 'Pipeline failed'
            sh '${COMPOSE_CMD} logs'
        }
        always {
            sh '${COMPOSE_CMD} ps'
        }
    }
}
