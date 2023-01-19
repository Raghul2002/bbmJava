package bbm.model.account;


public class Customer extends User {
    private static int cId = 1;
    private final String customerId;

    public Customer(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        customerId = "CID"+cId;
        cId++;
    }

    public String getCustomerId() {
        return customerId;
    }
}
 