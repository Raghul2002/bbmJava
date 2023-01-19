package bbm.database;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Customer;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.account.Manager;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.ArrayList;
import java.util.List;

public final class Database implements IDatabase {
    private static Database database;

    private Database() {}

    public static Database getInstance() {
        if (database == null) database = new Database();
        return database;
    }

    final private List<Owner> ownerList = new ArrayList<>();
    final private List<Manager> managerList = new ArrayList<>();
    final private List<SalesExecutive> salesExecutiveList = new ArrayList<>();
    final private List<Customer> customerList = new ArrayList<>();
    final private List<EBike> eBikeList = new ArrayList<>();
    final private List<MBike> mBikeList = new ArrayList<>();
    final private List<SalesRecord> salesRecordList = new ArrayList<>();


    public void addUser(Owner owner) {
        ownerList.add(owner);
    }

    public void addUser(Customer customer) {
        customerList.add(customer);
    }

    public void addUser(SalesExecutive salesExecutive) {
        salesExecutiveList.add(salesExecutive);
    }

    public void addUser(Manager manager) {
        managerList.add(manager);
    }

    public void addBike(EBike eBike) {
        eBikeList.add(eBike);
    }

    public void addBike(MBike mBike) {
        mBikeList.add(mBike);
    }

    public void removeUser(SalesExecutive salesExecutive) {
        salesExecutiveList.remove(salesExecutive);
    }

    public void removeUser(Manager manager) {

        managerList.remove(manager);
    }

    @Override
    public void removeUser(Owner owner) {
        ownerList.remove(owner);
    }

    @Override
    public void removeUser(Customer customer) {
        customerList.remove(customer);
    }

    @Override
    public void removeBike(EBike eBike) {
        eBikeList.remove(eBike);

    }

    @Override
    public void removeBike(MBike mBike) {
        mBikeList.remove(mBike);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<SalesExecutive> getSalesExecutiveList() {
        return salesExecutiveList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public List<EBike> getEBikeList() {
        return eBikeList;
    }

    public List<MBike> getMBikeList() {
        return mBikeList;
    }

    public void addOrderDetails(SalesRecord salesRecord) {
        salesRecordList.add(salesRecord);
    }

    public List<SalesRecord> getOrderDetailsList() {
        return salesRecordList;
    }
}