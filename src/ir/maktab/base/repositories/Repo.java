package ir.maktab.base.repositories;


import ir.maktab.base.models.BaseModel;
import ir.maktab.utils.DButils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Function;

public abstract class Repo<E extends BaseModel<ID>, ID> implements RepoApi<E, ID> {

    protected Connection connection;

    {
        connection = DButils.connection;
        createTableIfNotExists();
    }

    protected void printErr(Exception e) {
        System.out.println("=".repeat(100));
        e.printStackTrace();
        System.out.println("=".repeat(100));
    }

    @Override
    public <T> T queryOperation(String sqlQuery, Function<ResultSet, T> function) {
        ResultSet resultSet;
        T result = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            result = function.apply(resultSet);
            statement.close();
        } catch (SQLException e) {
            printErr(e);
        }
        return result;
    }

    @Override
    public boolean basicUpdate(String sqlUpdate) {
        int update = -1;
        try {
            Statement statement = connection.createStatement();
            update = statement.executeUpdate(sqlUpdate);
            statement.close();
        } catch (SQLException e) {
            printErr(e);
        }
        boolean status = update >= 0;
        operationStatus(status);
        return status;
    }

    @Override
    public void operationStatus(boolean update) {
        if (update) System.out.println("[ Ok ]: success ");
        else System.err.println("[ err ]:  operation failed  ");
    }
}
