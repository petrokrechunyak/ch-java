package org.example.hibernate.DAO;

import org.example.hibernate.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User> {
}
