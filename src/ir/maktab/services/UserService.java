package ir.maktab.services;

import ir.maktab.models.User;
import ir.maktab.repositories.UserRepo;

public class UserService {

    private final UserRepo userRepo;

    public UserService() {
        userRepo = new UserRepo();
    }

    public User login(User login) {
        return userRepo.findValidUser(login);
    }
}
