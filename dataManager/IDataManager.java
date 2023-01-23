package bbm.dataManager;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface IDataManager {
    void addUser(Customer customer);

    void addUser(Manager manager);
    void addUser(SalesExecutive salesExecutive);

    void removeUser(Manager manager);
    void removeUser(SalesExecutive salesExecutive);
    void addBike(EBike eBike, Manager manager);
    void addBike(MBike mBike, Manager manager);
    void removeBike(EBike eBike,Manager manager);
    void removeBike(MBike mBike,Manager manager);
    List<Customer> getCustomerList();
    List<SalesExecutive> getSalesExecutiveList();
    List<Manager> getManagerList();
    List<EBike> getEBikeList();
    List<MBike> getMBikeList();
    void addSalesDetails(SalesRecord salesRecord);
    List<SalesRecord> getSalesDetailsList();

    List<Owner> getOwnerList();
}
