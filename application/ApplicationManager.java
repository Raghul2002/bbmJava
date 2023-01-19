package bbm.application;

import bbm.Factory.BBMFactory;
import bbm.model.account.Owner;
import bbm.model.bike.BikeTypes;
import bbm.bikeManager.BikeManager;
import bbm.bikeManager.EBikeManager;
import bbm.bikeManager.MBikeManager;
import bbm.dataManager.IDataManager;
import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public final class ApplicationManager implements OwnerAccess, ManagerAccess, CustomerAccess, SalesExecutiveAccess, BBMAccess {
    IDataManager dataManager = BBMFactory.getIDataManagerInstance();
    BikeManager<EBike> eBikeManager = new EBikeManager(dataManager);
    BikeManager<MBike> mBikeManager = new MBikeManager(dataManager);

    public List<EBike> getAvailableEBike() {
        BikeStatus bikeStatus = BikeStatus.AVAILABLE;
        return eBikeManager.getBike(bikeStatus);
    }

    public List<MBike> getAvailableMBike() {
        BikeStatus bikeStatus = BikeStatus.AVAILABLE;
        return mBikeManager.getBike(bikeStatus);
    }

    public List<MBike> getSoldMBike() {
        BikeStatus bikeStatus = BikeStatus.SOLD;
        return mBikeManager.getBike(bikeStatus);
    }
    public List<EBike> getSoldEBike() {
        BikeStatus bikeStatus = BikeStatus.SOLD;
        return eBikeManager.getBike(bikeStatus);
    }

    public List<MBike> getReservedMBike() {
        BikeStatus bikeStatus = BikeStatus.RESERVED;
        return mBikeManager.getBike(bikeStatus);
    }
    public List<EBike> getReservedEBike() {
        BikeStatus bikeStatus = BikeStatus.RESERVED;
        return eBikeManager.getBike(bikeStatus);
    }

    private Bike getBike(int bikeId) {
        for (Bike bike : dataManager.getEBikeList()) {
            if (bike.getBikeId() == bikeId) {
                return bike;
            }
        }
        for (Bike bike : dataManager.getMBikeList()) {
            if (bike.getBikeId() == bikeId) {
                return bike;
            }
        }
        return null;
    }

    public void confirmBookingOrders(SalesExecutive salesExecutive) {
        int bikeId = 0;
        Bike bike = getBike(0);
        for (SalesRecord salesRecord : dataManager.getOrderDetailsList()) {
            if (salesRecord.getSalesExecutiveId() == null) {
                salesRecord.setSalesExecutiveId(salesExecutive.getSalesExecutiveId());
                bikeId = salesRecord.getBikeId();
                bike = getBike(bikeId);
            }
        }
        assert bike != null;
        bike.setBikeStatus(BikeStatus.SOLD);
    }

    @Override
    public void addUser(Customer customer) {
        dataManager.addUser(customer);
    }

    public List<SalesRecord> getSoldDetails() {
        return (dataManager.getOrderDetailsList());
    }

    @Override
    public void addUser(Manager manager) {
        dataManager.addUser(manager);
    }

    @Override
    public void addUser(SalesExecutive salesExecutive) {
        dataManager.addUser(salesExecutive);
    }

    @Override
    public boolean removeManager(String id) {
        List<Manager> managerList = dataManager.getManagerList();
        for (Manager i : managerList) {
            if (i.getManagerId().equals(id)) {
                dataManager.removeUser(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Manager> getManagerList() {
        return dataManager.getManagerList();
    }

    @Override
    public List<SalesExecutive> getSalesExecutiveList() {
        return dataManager.getSalesExecutiveList();
    }

    @Override
    public List<Customer> getCustomerList() {
        return dataManager.getCustomerList();
    }

    @Override
    public boolean removeSalesExecutive(String id) {
        List<SalesExecutive> salesExecutiveList = dataManager.getSalesExecutiveList();
        for (SalesExecutive i : salesExecutiveList) {
            if (i.getSalesExecutiveId().equals(id)) {
                dataManager.removeUser(i);
                return true;
            }
        }
        return false;
    }

    public void addBike(EBike bike, Manager manager) {
        eBikeManager.addBike(bike, manager);
    }

    public void addBike(MBike bike, Manager manager) {
        mBikeManager.addBike(bike, manager);
    }

    public boolean removeMBike(int bikeId, Manager manager) {
        return mBikeManager.removeBike(bikeId, manager);
    }

    public boolean removeEBike(int bikeId, Manager manager) {
        return eBikeManager.removeBike(bikeId, manager);
    }

    public boolean addBookingOrder(SalesRecord salesRecord, BikeTypes bikeType) {
        if (bikeType.equals(BikeTypes.MECHANICAL_BIKE)) {
            return mBikeManager.addBookingOrder(salesRecord);
        }
        return eBikeManager.addBookingOrder(salesRecord);
    }

    public boolean compareBike(BikeTypes bikeType, int bikeId1, int bikeId2) {
        if (bikeId1 == bikeId2)
            return false;
        switch (bikeType) {
            case MECHANICAL_BIKE:
                mBikeManager.compareBike(bikeId1, bikeId2);
                break;
            case ELECTRICAL_BIKE:
                eBikeManager.compareBike(bikeId1, bikeId2);
                break;
        }
        return true;
    }
    public Customer authenticateCustomer(String userName, String password) {
        List<Customer> customerList = dataManager.getCustomerList();
        for (Customer i : customerList)
            if (i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }

    public Manager authenticateManager(String userName, String password) {
        List<Manager> managerList = dataManager.getManagerList();
        for (Manager i : managerList)
            if (i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }

    public SalesExecutive authenticateSalesExecutive(String userName, String password) {
        List<SalesExecutive> salesExecutiveList = dataManager.getSalesExecutiveList();
        for (SalesExecutive i : salesExecutiveList)
            if (i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }

    public Owner authenticateOwner(String userName, String password) {
        List<Owner> ownerList = dataManager.getOwnerList();
        for (Owner i : ownerList)
            if (i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }
}
