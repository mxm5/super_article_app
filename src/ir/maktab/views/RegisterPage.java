package ir.maktab.views;

import ir.maktab.base.views.Page;
import ir.maktab.models.User;
import ir.maktab.services.UserService;

import java.sql.Timestamp;

public class RegisterPage extends Page {

    public RegisterPage() {
        UserService userService = new UserService();
//        "('jojo', 'saeed', 'azimi', '1351551', '2010-10-10', '123');",
        String handle = enterValue("enter your user handle");
        String firstName = enterValue("enter your first name");
        String lastName = enterValue("enter your last name");
        String nationalCode = enterValue("enter your national code", 8, 10);
        String birthday = selectDate();
        Timestamp birthdayTimestamp = parseDateFromInput(birthday);
        String password = enterPassword();

        User register = new User(
                handle,
                firstName,
                lastName,
                nationalCode,
                birthdayTimestamp,
                password
        );

        boolean success = userService.registerNewUser(register);

        if (success) {
            System.out.println("user created successfully ");

        }

        new LoginPage();

    }
}
