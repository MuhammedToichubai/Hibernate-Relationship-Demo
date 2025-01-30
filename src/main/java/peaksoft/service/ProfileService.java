package peaksoft.service;

import peaksoft.models.Profile;

public interface ProfileService {
    String saveProfile(Long userId, Profile profile);

    String deleteById(Long id);
}
