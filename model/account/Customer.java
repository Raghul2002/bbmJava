package bbm.model.account;


public class Customer extends User {
    private static int cId = 1;
    private final int customerId = cId;

    public Customer(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        cId++;
    }

    public int getCustomerId() {
        return customerId;
    }
}
 