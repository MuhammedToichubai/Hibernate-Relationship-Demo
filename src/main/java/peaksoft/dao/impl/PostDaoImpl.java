package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.PostDao;
import peaksoft.models.Post;
import peaksoft.models.User;

import java.util.ArrayList;
import java.util.Optional;

public class PostDaoImpl implements PostDao {
    private final EntityManager em
            = HibernateConfig.getEntityManagerFactory().createEntityManager();

    @Override
    public void save(Post post) {
        try {
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void assignPostToUser(Long userId, Long postId) {
        em.getTransaction().begin();
        Post post = em.find(Post.class, postId);
        User user = em.find(User.class, userId);
        post.setOwner(user);
        if (user.getPosts() == null) {user.setPosts(new ArrayList<>());}
        user.getPosts().add(post);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(Long postId) {
        try {
            em.getTransaction().begin();

            em.remove(
                    em.find(Post.class, postId)
            );

            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }

    }

    @Override
    public Optional<Post> findById(Long postId) {
       return Optional.ofNullable(em.find(Post.class, postId));
    }
}
