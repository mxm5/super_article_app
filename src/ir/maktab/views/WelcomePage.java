package ir.maktab.views;

import ir.maktab.base.views.Page;

public class WelcomePage extends Page {
    public WelcomePage(){
        printOptions("login","register","show all articles","exit");
        int option = selectOption(4);
        switch (option){
            case 1 -> new LoginPage();
            case 2 -> new RegisterPage();
            case 3 -> new ShowAllArticlesPage();
        }

    }
}
