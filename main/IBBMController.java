package bbm.main;

import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;

public interface IBBMController {
    Owner authenticateOwner(String userName, String password);

    Manager authenticateManager(String userName, String password);

    SalesExecutive authenticateSalesExecutive(String userName, String password);

    Customer authenticateCustomer(String userName, String password);

    boolean renderOwnerPortal(Owner owner);

    boolean renderManagerPortal(Manager manager);

    boolean renderSalesExecutivePortal(SalesExecutive salesExecutive);

    boolean renderCustomerPortal(Customer customer);


    void addCustomer(String firstName, String lastName, String userName, String password, String emailId, String phoneNo);
}
