package by.dorozhuk.stressjsp.entity;

public class User {
    private String usermane;
    private String pass;
    private String firstname;
    private String lastname;
    private String email;
    private boolean valid;
    private boolean isDupl;

    public User(String usermane, String pass) {
        this.usermane = usermane;
        this.pass = pass;
    }

    public User(String usermane, String pass, String firstname, String lastname, String email) {
        this.usermane = usermane;
        this.pass = pass;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User() {
    }

    public boolean isDupl() {
        return isDupl;
    }

    public void setDupl(boolean dupl) {
        isDupl = dupl;
    }

    public String getUsermane() {
        return usermane;
    }

    public void setUsermane(String usermane) {
        this.usermane = usermane;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValid() {
        return valid;
    }

    public  void setValid(boolean valid) {
        this.valid = valid;
    }
}
