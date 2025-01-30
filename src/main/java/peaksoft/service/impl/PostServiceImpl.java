package peaksoft.service.impl;

import peaksoft.dao.PostDao;
import peaksoft.dao.UserDao;
import peaksoft.dao.impl.PostDaoImpl;
import peaksoft.dao.impl.UserDaoImpl;
import peaksoft.models.Post;
import peaksoft.models.User;
import peaksoft.service.PostService;

import java.util.NoSuchElementException;

public class PostServiceImpl implements PostService {
    private final PostDao postDao = new PostDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public String save(Post post){
        try {
            postDao.save(post);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Post saved";
    }

    @Override
    public String assignPostToUser(Long postId, Long userId){
        User user = userDao.findById(userId).orElse(null);
        Post post = postDao.findById(postId).orElse(null);
        if (user == null) {
            return "User with id " + userId + " not found";
        } else if (post == null) {
            return "Post with id " + postId + " not found";
        }
        postDao.assignPostToUser(userId, postId);
        return "Post assigned to user " + userId + " with id " + postId;
    }

    @Override
    public String deleteById(Long id){
        userDao.findById(id).orElseThrow(() ->
                new NoSuchElementException("User with id " + id + " not found"));
        try {
            postDao.deleteById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Post deleted with id " + id;
    }
}
