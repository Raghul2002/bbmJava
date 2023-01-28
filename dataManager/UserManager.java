package bbm.dataManager;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.*;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface IDataManager{
    void addUser(Customer customer);
    void addUser(Manager manager);
    void addUser(SalesExecutive salesExecutive);
    void removeUser(Manager manager);
    void removeUser(SalesExecutive salesExecutive);
    List<Customer> getCustomerList();
    List<SalesExecutive> getSalesExecutiveList();
    List<Manager> getManagerList();
    List<EBike> getEBikeList();
    List<MBike> getMBikeList();
    List<SalesRecord> getSalesDetailsList();

    List<Owner> getOwnerList();
}
