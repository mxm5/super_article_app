package ir.maktab.services;

import ir.maktab.repositories.ArticleRepo;

public class ArticleService {


    private final ArticleRepo articleRepo;

    public ArticleService() {
        this.articleRepo = new ArticleRepo();
    }

}
