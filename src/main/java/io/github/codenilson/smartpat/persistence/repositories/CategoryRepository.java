package io.github.codenilson.smartpat.persistence.repositories;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.Category;

public class CategoryRepository extends BaseRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }

    public Category findByName(String name) {
        var em = emf.createEntityManager();
        var query = em.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class);
        query.setParameter("name", name);
        var resultList = query.getResultList();
        em.close();
        if (resultList.isEmpty()) {
            System.out.println("Category not found with name: " + name);
            return null;
        } else {
            return resultList.get(0);
        }
    }
}
