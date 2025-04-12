package io.github.codenilson.smartpat.persistence;

import java.util.List;

public interface Service<T> {

    void save(T entity);

    T findById(Integer id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);

}
