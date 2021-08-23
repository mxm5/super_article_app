package ir.maktab.base.repositories;

import ir.maktab.base.models.BaseModel;

import java.sql.ResultSet;
import java.util.function.Function;

public interface RepoApi<E extends BaseModel<ID>, ID> {
    void createTableIfNotExists();

    <T> T queryOperation(String sqlQuery, Function<ResultSet, T> function);

    boolean basicUpdate(String sqlUpdate);

    void operationStatus(boolean update);


}
