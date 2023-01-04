package bbm.database;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface IDatabase {
    static Database createDatabaseInstance(){
        return Database.getInstance();
    }
    void addUser(Owner owner);
    void addUser(Customer customer);
    void addUser(SalesExecutive salesExecutive);
    void addUser(Manager manager);
    void addBike(EBike eBike);
    void addBike(MBike mBike);
    void removeUser(SalesExecutive salesExecutive);
    void removeUser(Manager manager);

    void removeUser(Owner owner);
    void removeUser(Customer customer);
    void removeBike(EBike eBike);
    void removeBike(MBike mBike);
    List<Customer> getCustomerList();
    List<SalesExecutive> getSalesExecutiveList();
    List<Manager> getManagerList();
    List<Owner> getOwnerList();
    List<EBike> getEBikeList();
    List<MBike> getMBikeList();
    void addOrderDetails(SalesRecord salesRecord);
    List<SalesRecord> getOrderDetailsList();

}
