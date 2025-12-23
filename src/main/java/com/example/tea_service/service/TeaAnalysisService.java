package com.example.tea_service.service;

import com.example.tea_service.model.Tea;
import com.example.tea_service.repository.TeaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeaAnalysisService {

    private final TeaRepository teaRepository;

    public TeaAnalysisService(TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
    }

    public List<Tea> getHighCaffeineTeas(int threshold) {
        return teaRepository.findAll().stream()
                .filter(tea -> tea.getCaffeineMg() >= threshold)
                .collect(Collectors.toList());
    }

    public double averageCaffeine() {
        return teaRepository.findAll().stream()
                .mapToInt(Tea::getCaffeineMg)
                .average()
                .orElse(0.0);
    }
}
