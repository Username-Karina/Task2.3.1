package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        User deleteUser = em.find(User.class,id);
        em.remove(deleteUser);
    }

    @Override
    public void edit(User user) {
        em.merge(user);
    }
}
