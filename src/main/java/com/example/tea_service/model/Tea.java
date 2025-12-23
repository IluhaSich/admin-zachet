package com.example.tea_service.model;


public class Tea {

    private Long id;
    private String name;
    private String type;      // green, black, herbal
    private int caffeineMg;   // мг кофеина

    public Tea() {
    }

    public Tea(Long id, String name, String type, int caffeineMg) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.caffeineMg = caffeineMg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCaffeineMg() {
        return caffeineMg;
    }

    public void setCaffeineMg(int caffeineMg) {
        this.caffeineMg = caffeineMg;
    }
}
