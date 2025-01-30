package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.ProfileDao;
import peaksoft.models.Profile;
import peaksoft.models.User;

public class ProfileDaoImpl implements ProfileDao {
    private final EntityManager entityManager =
            HibernateConfig.getEntityManagerFactory().createEntityManager();

    @Override
    public void save(Long userId, Profile profile) {
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            user.setProfile(profile);
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

    }

    @Override
    public void deleteById(Long profileId) {
        try {
            entityManager.getTransaction().begin();

//            User user = entityManager.createQuery("""
//                            select u from User u where u.profile.id = :profileId
//                            """, User.class)
//                    .setParameter("profileId", profileId)
//                    .getSingleResult();
//            user.setProfile(null);
//            entityManager.merge(user);

            entityManager.createQuery("""
                            update User
                            u set  u.profile = null
                            where u.profile.id = ?1
                            """)
                    .setParameter(1, profileId)
                    .executeUpdate();

            entityManager.remove(
                    entityManager.find(Profile.class, profileId)
            );
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

    }
}
