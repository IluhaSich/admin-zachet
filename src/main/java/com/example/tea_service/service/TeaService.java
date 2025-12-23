package com.example.tea_service.service;

import com.example.tea_service.model.Tea;
import com.example.tea_service.repository.TeaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeaService {

    private final TeaRepository repository;

    public TeaService(TeaRepository repository) {
        this.repository = repository;
    }

    public Tea create(Tea tea) {
        return repository.save(tea);
    }

    public Collection<Tea> getAll() {
        return repository.findAll();
    }

    public Tea getById(Long id) {
        return repository.findById(id);
    }

    public Tea update(Long id, Tea tea) {
        tea.setId(id);
        return repository.save(tea);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
