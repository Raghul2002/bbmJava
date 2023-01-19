package bbm.model.account;


public class SalesExecutive extends User {
    private static int SEId = 1;
    private final String salesExecutiveId;

    public SalesExecutive(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        this.salesExecutiveId = "SEID"+SEId;
        SEId++;
    }
    public String getSalesExecutiveId() {
        return salesExecutiveId;
    }

}