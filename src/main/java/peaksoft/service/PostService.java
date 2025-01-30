package peaksoft.service;

import peaksoft.models.Post;

public interface PostService {
    String save(Post post);

    String assignPostToUser(Long postId, Long userId);

    String deleteById(Long id);
}
