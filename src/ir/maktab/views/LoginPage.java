package ir.maktab.views;

import ir.maktab.base.views.Page;
import ir.maktab.models.User;
import ir.maktab.services.UserService;

public class LoginPage extends Page {

    LoginPage() {
        UserService userService = new UserService();
        String userName = enterValue("enter your user name");
        String password = enterValue("enter your password");
        User login = new User(userName, password);

        User found = userService.login(login);

        if(found ==null) {
            warning("invalid input");
            new WelcomePage();
        }
        else{
            success("you are logged in as > "+found.getUserFirstName());
        }
    }
}
