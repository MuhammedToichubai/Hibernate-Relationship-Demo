package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.UserDao;
import peaksoft.models.User;

import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager =
            HibernateConfig.getEntityManagerFactory().createEntityManager();

    @Override
    public void save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();

        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(
                entityManager.createQuery("select u from User u where u.id = :id", User.class)
                        .setParameter("id", id)
                        .getSingleResult()
        );
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));

    }
}
