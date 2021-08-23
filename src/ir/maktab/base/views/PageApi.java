package ir.maktab.base.views;

import java.sql.Timestamp;
import java.util.Collection;

public interface PageApi {

    int printOptions(String... options);

    <T> void br(T value);

    void br();

    void line();

    void jump();

    String enterValue(String msg, int minimumLength);

    String enterValue(String msg, int minimumLength,int maximumLength);

    String enterLine(String msg );

    String enterValue(String msg);

    int selectOption(int maxOpt);

    <E> void printTitle(E value);

    void printTitle();

    <K> void warning(K warningMessage);

    void warning();

    <Z> void success(Z warningMessage);

    void success();

    String enterPassword();

    int selectOption(int minOpt, int maxOpt);

    String selectDate();

    Timestamp parseDateFromInput(String date);
}
