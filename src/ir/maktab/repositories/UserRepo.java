package ir.maktab.repositories;

import ir.maktab.base.repositories.Repo;
import ir.maktab.models.User;

import java.sql.SQLException;


public class UserRepo extends Repo<User, Long> {
    @Override
    public void createTableIfNotExists() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS `user_table` (\n" +
                "  `user_id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `user_handle` varchar(45) NOT NULL,\n" +
                "  `user_first_name` varchar(45) NOT NULL,\n" +
                "  `user_last_name` varchar(45) NOT NULL,\n" +
                "  `user_national_code` varchar(10) NOT NULL,\n" +
                "  `user_birthday` datetime NOT NULL,\n" +
                "  `user_password` varchar(45) NOT NULL,\n" +
                "  PRIMARY KEY (`user_id`),\n" +
                "  UNIQUE KEY `user_handle_UNIQUE` (`user_handle`),\n" +
                "  UNIQUE KEY `user_id_UNIQUE` (`user_id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;\n";

        basicUpdate(createTableSql);


    }


    public User findValidUser(User user) {


        String sqlQuery = String.format("SELECT * FROM articles_app.user_table where \n" +
                        "user_handle = '%s' and user_password = '%s' ;",
                user.getUserHandle(), user.getPassword());

        return queryOperation(sqlQuery, (resultSet) -> {
                    try {
                        if (resultSet.next()) {

                            return new User(
                                    resultSet.getLong("user_id"),
                                    resultSet.getString("user_handle"),
                                    resultSet.getString("user_first_name"),
                                    resultSet.getString("user_last_name"),
                                    resultSet.getString("user_national_code"),
                                    resultSet.getTimestamp("user_birthday"),
                                    ""
                            );
                        }
                    } catch (SQLException e) {
                        printErr(e);
                    }
                    return null;
                }

        );


    }


    public boolean createUser(User user) {
        String createUserSql = String.format("INSERT INTO `articles_app`.`user_table` " +
                "(`user_handle`, `user_first_name`, `user_last_name`, `user_national_code`, `user_birthday`, `user_password`) VALUES " +
                "('%s', '%s', '%s', '%s', '%s', '%s');",


                user.getUserHandle(), user.getUserFirstName(), user.getUserLastName(), user.getNationalCode(), user.getBirthday(), user.getPassword()
        );

        return basicUpdate(createUserSql);
    }

}
