package bbm.customer;

import bbm.model.bike.Bike;
import bbm.model.bike.BikeTypes;
import bbm.SalesRecord.SalesRecord;
import bbm.application.CustomerAccess;
import bbm.model.account.Customer;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.ArrayList;
import java.util.List;

public final class CustomerController implements ICustomerController {
    private final Customer customer;
    private final CustomerAccess customerAccess;

    public CustomerController(Customer customer,CustomerAccess customerAccess) {
        this.customer = customer;
        this.customerAccess = customerAccess;
    }


    public List<Customer> showPersonalDetails() {
        List<Customer> userList = new ArrayList<>();
        userList.add(this.customer);
        return (userList);
    }

    @Override
    public List<EBike> viewAvailableEBike() {
        return customerAccess.getAvailableEBike();
    }

    @Override
    public List<MBike> viewAvailableMBike() {
        return customerAccess.getAvailableMBike();
    }
    public boolean compareBike(BikeTypes bikeType, int bikeId1, int bikeId2) {
        return customerAccess.compareBike(bikeType, bikeId1, bikeId2);
    }

    public boolean buyBike(String customerId, int bikeId, BikeTypes bikeType) {
        SalesRecord salesRecord = new SalesRecord(bikeId, customerId);
        return customerAccess.addBookingOrder(salesRecord, bikeType);
    }
    public List<MBike> getCustomerMBike(){
        List<MBike> mBikeList = new ArrayList<>();
        List<Bike> bikeList = new ArrayList<>(customerAccess.getCustomerBike(customer.getCustomerId()));
        for(Bike bike :bikeList){
            if(bike instanceof MBike){
                mBikeList.add((MBike)bike);
            }
        }
        return mBikeList;
    }

    @Override
    public List<EBike> getCustomerEBike() {
        List<EBike> eBikeList = new ArrayList<>();
        List<Bike> bikeList = new ArrayList<>(customerAccess.getCustomerBike(customer.getCustomerId()));
        for(Bike bike :bikeList){
            if(bike instanceof EBike){
                eBikeList.add((EBike)bike);
            }
        }
        return eBikeList;
    }
}
