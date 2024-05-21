package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public void save(User user);

    public User findById(int id);

    public void delete(int id);

    public void edit(User user);
}

