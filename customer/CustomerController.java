package bbm.customer;

import bbm.Factory.BBMFactory;
import bbm.model.bike.BikeTypes;
import bbm.SalesRecord.SalesRecord;
import bbm.application.CustomerAccess;
import bbm.model.account.Customer;
import bbm.utility.UserView.UtilCustomerView;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;

public final class CustomerController {
    private final Customer customer;
    private final CustomerAccess customerAccess;

    public CustomerController(Customer customer,CustomerAccess customerAccess) {
        this.customer = customer;
        this.customerAccess = customerAccess;
    }


    public void showPersonalDetails() {
        List<Customer> userList = new ArrayList<>();
        userList.add(this.customer);
        UtilCustomerView.showCustomerDetails(userList);
    }

    public void viewAvailableBike() {
        UtilBikeView.printEBikeList(customerAccess.getAvailableEBike());
        UtilBikeView.printMBikeList(customerAccess.getAvailableMBike());
    }


    public boolean compareBike(BikeTypes bikeType, int bikeId1, int bikeId2) {
        return customerAccess.compareBike(bikeType, bikeId1, bikeId2);
    }

    public boolean buyBike(String customerId, int bikeId, BikeTypes bikeType) {
        SalesRecord salesRecord = new SalesRecord(bikeId, customerId);
        return customerAccess.addBookingOrder(salesRecord, bikeType);
    }

}
