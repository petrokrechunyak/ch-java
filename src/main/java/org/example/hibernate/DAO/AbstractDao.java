package org.example.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDao<T> implements BaseDao<T> {

    @Autowired
    SessionFactory sessionFactory;

    public Class<T> genericClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findById(UUID id) {
        return getSession().get(genericClass(), id);
    }

    public List<T> findAll() {
        return getSession().createQuery("FROM " + genericClass().getName(), genericClass()).getResultList();
    }

    public T save(T t) {
        getSession().save(t);
        return t;
    }

    public T update(T t) {
        getSession().merge(t);
        return t;
    }

    public boolean deleteById(UUID id) {
        try{
            T t = findById(id);
            getSession().delete(t);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
