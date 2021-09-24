package ir.maktab.repositories;

import ir.maktab.base.repositories.Repo;
import ir.maktab.models.Article;

public class ArticleRepo extends Repo<Article,Long> {
    @Override
    public void createTableIfNotExists() {

    }

    public void readAllArticles(){
        String sql = "SELECT * FROM articles_app.article_table;";
        queryOperation(sql,resultSet -> {
            return null;
        });
    }
}
