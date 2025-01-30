package peaksoft.service;

import peaksoft.models.User;

public interface UserService {
    void save(User user);
    void deleteById(Long id);

    User findById(Long id);
}
