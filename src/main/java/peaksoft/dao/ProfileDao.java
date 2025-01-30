package peaksoft.dao;

import peaksoft.models.Profile;

public interface ProfileDao {
    void save(Long userId, Profile profile);
    void deleteById(Long profileId);

}

