package ir.maktab.views;

import ir.maktab.base.views.Page;
import ir.maktab.models.User;
import ir.maktab.services.UserService;

public class LoginPage extends Page {

    LoginPage() {
        UserService userService = new UserService();
        String userName = enterValue("enter your user name");
        String password = enterPassword();
        User login = new User(userName, password);

        userService.login(login);
    }
}
