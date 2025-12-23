package com.example.tea_service.controller;

import com.example.tea_service.model.Tea;
import com.example.tea_service.service.TeaAnalysisService;
import com.example.tea_service.service.TeaService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/teas")
public class TeaController {

    private final TeaService teaService;
    private final TeaAnalysisService analysisService;

    public TeaController(TeaService teaService, TeaAnalysisService analysisService) {
        this.teaService = teaService;
        this.analysisService = analysisService;
    }

    @PostMapping
    public Tea create(@RequestBody Tea tea) {
        return teaService.create(tea);
    }

    @GetMapping
    public Collection<Tea> getAll() {
        return teaService.getAll();
    }

    @GetMapping("/{id}")
    public Tea getById(@PathVariable Long id) {
        return teaService.getById(id);
    }

    @PutMapping("/{id}")
    public Tea update(@PathVariable Long id, @RequestBody Tea tea) {
        return teaService.update(id, tea);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teaService.delete(id);
    }

    @GetMapping("/high-caffeine")
    public List<Tea> highCaffeine(@RequestParam int threshold) {
        return analysisService.getHighCaffeineTeas(threshold);
    }

    @GetMapping("/average-caffeine")
    public double averageCaffeine() {
        return analysisService.averageCaffeine();
    }
}
