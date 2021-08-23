package ir.maktab.base.views;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

public class Page implements PageApi {

    {
        printTitle();
    }

    public Page() {
    }


    @Override
    public int printOptions(String... options) {
        int k = 0;
        for (Object opt : options) {
            System.out.println(++k + ". " + opt.toString());
        }
        return k;
    }

// TODO: ask a question for this

//    protected int selectFrom(Collection<String> list) {
//
//        int sel = selectOpt(printOptions(list));
//        return selectOpt(sel);
//    }

    @Override
    public <T> void br(T value) {
        System.out.println(value);
    }

    @Override
    public void br() {
        System.out.println();
    }

    @Override
    public void line() {
        System.out.println("_".repeat(100));
    }

    @Override
    public void jump() {
        br();
        br();
        br();
        br();
    }

    @Override
    public String enterValue(String msg, int minimumLength) {
        String val;
        System.out.print(msg + " > ");
        while (true) {
            val = new Scanner(System.in).next().strip();
            if (val.length() >= minimumLength)
                break;
            else
                warning("entered value must have at least " + minimumLength + " characters");
        }

        return val;
    }

    @Override
    public String enterLine(String msg) {
        String val;
        System.out.print(msg + " > ");
        val = new Scanner(System.in).nextLine();
        return val;
    }

    @Override
    public String enterValue(String msg) {
        String val;
        System.out.print(msg + " > ");
        val = new Scanner(System.in).next();
        return val;
    }

    @Override
    public int selectOption(int maxOpt) {
//        br();
        int opt;
        System.out.println("enter an option between 1 to " + maxOpt);
        while (true) {
            try {
                opt = new Scanner(System.in).nextInt();
                if (opt > maxOpt)
                    warning("enter an option between 1 to " + maxOpt);
                else break;
            } catch (Exception e) {

                warning("insert correct value");
            }
        }
        success("selected " + opt);
        return opt;
    }

    @Override
    public <E> void printTitle(E value) {
        int l = value.toString().length();
        boolean even = l % 2 == 0;
        int dist;
        if (even) {
            int total = 96;
            dist = (total - l) / 2;
        } else {
            dist = (95 - l) / 2;

        }

        line();
        String k = " ";
        System.out.println("||" + " ".repeat(dist) + value + " ".repeat(dist - 1) + (even ? " " : "  ") + "||");
        br("||" + "_".repeat(96) + "||");
        br();
    }

    @Override
    public void printTitle() {
        String className = getClass().getSimpleName();
//        String className = getClass().getName();
//        String[] classNArr = className.split("\\.");
//        className = classNArr[classNArr.length - 1];
        printTitle(className);

    }

    @Override
    public <K> void warning(K warningMessage) {
        System.out.println("[ Err ]: " + warningMessage);
    }

    @Override
    public void warning() {
        System.out.println(" [ Err ] ");

    }

    @Override
    public <Z> void success(Z warningMessage) {
        System.out.println("[ Ok ]: " + warningMessage);
    }

    @Override
    public void success() {
        System.out.println(" [ Ok ] ");
    }

    @Override
    public String enterPassword() {
        String password;
        while (true) {
            password = enterLine("enter your password ");
            String passwordConfirm = enterLine("confirm your password");
            if (passwordConfirm.equals(password)) break;
        }
        return password;
    }

    @Override
    public int selectOption(int minOpt, int maxOpt) {
        br();
        int opt;
        br("enter an option between " + minOpt + " to " + maxOpt);
        while (true) {
            try {
                opt = new Scanner(System.in).nextInt();
                if (opt > maxOpt)
                    warning("enter an option between " + minOpt + " to " + maxOpt);
                else if (opt < minOpt)
                    warning("enter an option between " + minOpt + " to " + maxOpt);
                else break;
            } catch (Exception e) {

                warning("insert correct value");
            }
        }
        success("selected " + opt);
        return opt;
    }


    @Override
    public String selectDate() {
        String date = "%d-%d-%d";
        System.out.println("select a year ");
        int year = selectOption(2021 - 145, 2021 - 7);
        System.out.println("select a month");
        int month = selectOption(12);
        System.out.println("select a day");
        int day = selectOption(31);
        return String.format(date, year, month, day);
    }

    @Override
    public Timestamp parseDateFromInput(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return Timestamp.valueOf(parsedDate.atStartOfDay());
    }

    @Override
    public String enterValue(String msg, int minimumLength, int maximumLength) {
        String val;
        System.out.print(msg + " > ");
        while (true) {
            val = new Scanner(System.in).next();
            if (val.length() < minimumLength)
                warning("entered value must have between "
                        + minimumLength + " characters and "
                        + maximumLength + " characters");


            else if (val.length() > maximumLength)
                warning("entered value must have between "
                        + minimumLength + " characters and "
                        + maximumLength + " characters");
            else
                break;
        }

        return val;
    }
}
