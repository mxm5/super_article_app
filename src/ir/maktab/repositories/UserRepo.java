package ir.maktab.repositories;

import ir.maktab.base.repositories.Repo;
import ir.maktab.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepo extends Repo<User, Long> {
    @Override
    public void createTableIfNotExists() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS `articles_app`.`user_table` (\n" +
                "  `user_id` INT NOT NULL,\n" +
                "  `user_handle` VARCHAR(45) NOT NULL,\n" +
                "  `user_first_name` VARCHAR(45) NOT NULL,\n" +
                "  `user_last_name` VARCHAR(45) NOT NULL,\n" +
                "  `user_national_code` VARCHAR(10) NOT NULL,\n" +
                "  `user_birthday` DATETIME NOT NULL,\n" +
                "  `user_password` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`user_id`),\n" +
                "  UNIQUE INDEX `user_handle_UNIQUE` (`user_handle` ASC) VISIBLE);\n";
        try {
            connection.createStatement().executeUpdate(createTableSql);
        } catch (SQLException e) {
            printErr(e);
        }
    }

    public User findValidUser(User user) {

        try {

            String sqlQuery = String.format("SELECT * FROM articles_app.user_table where \n" +
                            "user_handle = '%s' and user_password = '%s' ;",
                    user.getUserHandle(), user.getPassword());
            ResultSet r = connection.createStatement().executeQuery(sqlQuery);
            if (r.next()) {
                //                user.setId(queryResult.getLong(1));
//                user.setUserHandle(queryResult.getString("user_handle"));
//                user.setBirthday(queryResult.getTimestamp("user_birthday"));
//                user.setUserFirstName(queryResult.getString("user_first_name"));
//                user.setUserLastName(queryResult.getString("user_last_name"));
//                user.setPassword(queryResult.getString("user_password"));
//                user.setNationalCode(Long.parseLong(queryResult.getString("user_national_code")));
                return new User(
                        r.getLong("user_id"), r.getString("user_handle"),
                        r.getString("user_first_name"), r.getString("user_last_name")
                        , r.getString("user_national_code"),
                        r.getTimestamp("user_birthday"), ""


                );
            }


        } catch (SQLException e) {
            printErr(e);
        }
        return null;
    }

}
