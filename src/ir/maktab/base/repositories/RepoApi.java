package ir.maktab.base.repositories;

import ir.maktab.base.models.BaseModel;

import java.sql.SQLException;

public interface RepoApi<E extends BaseModel<ID>,ID> {
    void createTableIfNotExists();



}
