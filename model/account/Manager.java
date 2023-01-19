package bbm.model.account;

public class Manager extends User  {
    private static int mId = 1;
    private final String managerId ;

    public Manager(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        this.managerId = "MID"+mId;
        mId++;
    }
    public String getManagerId() {
        return managerId;
    }

}