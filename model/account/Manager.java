package bbm.model.account;

public class Manager extends User  {
    private static int mId = 1;
    private final int managerId ;

    public Manager(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        this.managerId = mId;
        mId++;
    }
    public int getManagerId() {
        return managerId;
    }

}