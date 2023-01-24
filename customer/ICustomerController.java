package bbm.customer;

import bbm.model.account.Customer;
import bbm.model.bike.BikeTypes;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;


public interface ICustomerController {
    List<Customer> showPersonalDetails();

    List<EBike> viewAvailableEBike();
    List<MBike> viewAvailableMBike();

    boolean compareBike(BikeTypes bikeType, int bikeId1, int bikeId2);

    boolean buyBike(String customerId, int bikeId, BikeTypes bikeType);
    List<MBike> getCustomerMBike();
    List<EBike> getCustomerEBike();
}