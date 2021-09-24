package ir.maktab.views;

import ir.maktab.base.views.Page;
import ir.maktab.services.ArticleService;

public class ShowAllArticlesPage extends Page {
    public ShowAllArticlesPage() {
        new ArticleService();
    }
}
