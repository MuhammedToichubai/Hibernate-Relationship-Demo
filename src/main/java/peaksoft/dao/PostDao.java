package peaksoft.dao;

import peaksoft.models.Post;

import java.util.Optional;


public interface PostDao {
    void save(Post post);

    void assignPostToUser(Long userId, Long postId);
    void deleteById(Long postId);

    Optional<Post> findById(Long postId);
}
