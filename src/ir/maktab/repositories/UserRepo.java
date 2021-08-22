package ir.maktab.repositories;

import ir.maktab.base.repositories.Repo;
import ir.maktab.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepo extends Repo<User, Long> {
    @Override
    public void createTableIfNotExists() {
       String  createTableSql = "CREATE TABLE IF NOT EXISTS `articles_app`.`user_table` (\n" +
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

    User findValidUser(User user){

        try {
            // TODO : insert query
            String sqlQuery =String.format("    %s %s " ,
                    user.getUserHandle(),user.getPassword());
            ResultSet queryResult = connection.createStatement().executeQuery(sqlQuery);
            if (queryResult.next()){
                User foundUser = new User();
                //TODO: insert column names
                user.setId(queryResult.getLong("user_id"));
                user.setUserHandle(queryResult.getString("user_handle"));
//                user.setBirthday();
                user.setUserFirstName(queryResult.getString("user_first_name"));
                user.setUserLastName(queryResult.getString("user_last_name"));
//                user.setPassword();
//                user.setNationalCode();
                return foundUser;
            }


        } catch (SQLException e) {
            printErr(e);
        }
        return null;
    }

}
