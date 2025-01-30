package peaksoft.dao;

import peaksoft.models.User;

import java.util.Optional;

public interface UserDao {
    void save(User user);

    void deleteById(Long id);

    Optional<User> findById(Long id);
}
