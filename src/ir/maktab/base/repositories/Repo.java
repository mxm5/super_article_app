package ir.maktab.base.repositories;


import ir.maktab.base.models.BaseModel;
import ir.maktab.utils.DButils;

import java.sql.Connection;
import java.util.function.Consumer;

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

}
