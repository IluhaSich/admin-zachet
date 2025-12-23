package com.example.tea_service.repository;

import com.example.tea_service.model.Tea;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TeaRepository {

    private final Map<Long, Tea> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Tea save(Tea tea) {
        if (tea.getId() == null) {
            tea.setId(idGenerator.getAndIncrement());
        }
        storage.put(tea.getId(), tea);
        return tea;
    }

    public Tea findById(Long id) {
        return storage.get(id);
    }

    public Collection<Tea> findAll() {
        return storage.values();
    }

    public void delete(Long id) {
        storage.remove(id);
    }
}
