package bbm.database;

import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;

public interface Authentication {
    Customer authenticateCustomer(String userName, String password);
    Manager authenticateManager(String userName, String password);
    Owner authenticateOwner(String userName, String password);
    SalesExecutive authenticateSalesExecutive(String userName, String password);
}
