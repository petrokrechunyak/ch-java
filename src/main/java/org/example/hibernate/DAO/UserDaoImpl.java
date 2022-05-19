package org.example.hibernate.DAO;

import org.example.hibernate.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Override
    public List<User> findAll() {
        return getSession().createQuery("FROM User", User.class).getResultList();
    }
}
