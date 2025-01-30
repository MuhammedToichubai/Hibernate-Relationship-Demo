package peaksoft.service.impl;

import peaksoft.dao.UserDao;
import peaksoft.dao.impl.UserDaoImpl;
import peaksoft.models.User;
import peaksoft.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }


    @Override
    public User findById(Long id){
      return   userDao.findById(id).orElse(null);
    }
}
