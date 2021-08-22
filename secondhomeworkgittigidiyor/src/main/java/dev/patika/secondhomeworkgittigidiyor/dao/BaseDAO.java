package dev.patika.secondhomeworkgittigidiyor.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDAO<T> {

    List<T> findAll();
    T findById(int id);
    T save(T object);
    void delete(T object);
    void deleteById(int id);
    T update(T object);
    void updateById(T object, int id);
}
