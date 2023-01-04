package bbm.model.account;

public abstract class User {
    private final String firstName,lastName, userName, password,emailId,phoneNo;

    public User(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}