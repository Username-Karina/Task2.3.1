package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void save(User user);
    public void edit(User user);
    public User findById(int id);
    public void delete(int id);

}
