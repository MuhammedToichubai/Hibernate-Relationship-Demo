package peaksoft.service.impl;

import peaksoft.dao.ProfileDao;
import peaksoft.dao.UserDao;
import peaksoft.dao.impl.ProfileDaoImpl;
import peaksoft.dao.impl.UserDaoImpl;
import peaksoft.models.Profile;
import peaksoft.service.ProfileService;

import java.util.NoSuchElementException;

public class ProfileServiceImpl implements ProfileService {
    private final ProfileDao profileDao = new ProfileDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public String saveProfile(Long userId, Profile profile) {
        try {
            userDao.findById(userId)
                    .orElseThrow(() -> new NoSuchElementException("User not found"));
            profileDao.save(userId, profile);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Profile saved";
    }

    @Override
    public String deleteById(Long id) {
        try {
            profileDao.deleteById(id);
        } catch (Exception e) {
           return e.getMessage();
        }
        return "Successfully deleted profile";
    }
}
