package org.example.hibernate.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {
    List<T> findAll();

    T findById(UUID id);

    T save(T t);

    T update(T t);

    void delete(T t);

    void deleteById(UUID id);
}
