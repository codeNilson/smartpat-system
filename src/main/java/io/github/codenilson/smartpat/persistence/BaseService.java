package io.github.codenilson.smartpat.persistence;

public abstract class BaseService<T> {

    protected final BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    protected void save(T entity) {
        sanitizeEntity(entity);
        repository.save(entity);
    }

    protected T findById(Integer id) {
        return repository.findById(id);
    }

    protected void update(T entity) {
        repository.update(entity);
    }

    protected void delete(T entity) {
        repository.delete(entity);
    }

    protected abstract void sanitizeEntity(T entity);

}
