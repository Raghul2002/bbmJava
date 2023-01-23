package bbm.application;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface OwnerAccess {
    List<MBike> getSoldMBike();

    List<EBike> getSoldEBike();

    List<MBike> getAvailableMBike();

    List<EBike> getAvailableEBike();

    List<SalesRecord> getSoldDetails();

    void addUser(Manager manager);

    void addUser(SalesExecutive salesExecutive);

    boolean removeManager(String id);

    List<Manager> getManagerList();

    List<SalesExecutive> getSalesExecutiveList();

    List<Customer> getCustomerList();

    boolean removeSalesExecutive(String id);
}
