package ir.maktab.models;

import ir.maktab.base.models.BaseModel;

import javax.print.attribute.DateTimeSyntax;

public class User extends BaseModel<Long> {
    Long id;
    String userHandle;
    String userFirstName;
    String userLastName;
    Long nationalCode;
    DateTimeSyntax birthday;
    String password;

    public User() {
    }

    public User(String username, String password) {
        this.userHandle = username;
        this.password = password;
    }

    public User(Long id,
                String userHandle,
                String userFirstName,
                String userLastName,
                Long nationalCode,
            DateTimeSyntax birthday,
                String password)
    {
        this.id = id;
        this.userHandle = userHandle;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public Long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public DateTimeSyntax getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTimeSyntax birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + userHandle + '\'' +
                ", nationalCode=" + nationalCode +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                '}';
    }
}
