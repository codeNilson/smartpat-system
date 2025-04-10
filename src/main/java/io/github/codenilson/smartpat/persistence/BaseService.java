package io.github.codenilson.smartpat.persistence;

public abstract class BaseService<T> {

    protected final BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public void save(T entity) {
        repository.save(entity);
    }

    public T findById(Integer id) {
        return repository.findById(id);
    }

    public void update(T entity) {
        repository.update(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

}
