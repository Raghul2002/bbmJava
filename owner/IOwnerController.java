package bbm.owner;

import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface IOwnerController {
    void addManager(String firstName, String lastName, String userName, String password, String emailId, String phoneNo);

    void addSalesExecutive(String firstName, String lastName, String userName, String password, String emailId, String phoneNo);

    boolean removeManger(String id);

    boolean removeSalesExecutive(String id);

    List<Manager> getManagerList();

    List<SalesExecutive> getSalesExecutiveList();

    List<Customer> getCustomerList();

    List<Owner> showPersonalDetails();

    List<EBike> viewAvailableEBike();
    List<MBike> viewAvailableMBike();
    void viewSoldDetails();

    void viewSoldBike();
}
