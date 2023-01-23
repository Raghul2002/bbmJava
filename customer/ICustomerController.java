package bbm.customer;

import bbm.model.bike.BikeTypes;


public interface ICustomerController {
    void showPersonalDetails();

    void viewAvailableBike();

    boolean compareBike(BikeTypes bikeType, int bikeId1, int bikeId2);

    boolean buyBike(String customerId, int bikeId, BikeTypes bikeType);
}