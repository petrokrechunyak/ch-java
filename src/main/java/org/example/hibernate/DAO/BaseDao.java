package org.example.hibernate.DAO;


import java.util.List;
import java.util.UUID;

public interface BaseDao<T> {
    List<T> findAll();

    T findById(UUID id);

    T save(T t);

    T update(T t);

    void delete(T t);

    void deleteById(UUID id);
}
