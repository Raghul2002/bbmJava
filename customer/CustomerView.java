package bbm.customer;

import bbm.Factory.BBMFactory;
import bbm.model.bike.BikeTypes;
import bbm.model.account.Customer;
import bbm.utility.UtilBikeInput;
import bbm.utility.UtilUserInput;

public final class CustomerView {
    private final Customer customer;
    private final CustomerController customerController;

    enum CustomerRoles {
        VIEW_BIKE,
        COMPARE_BIKE,
        BUY_BIKE,
        VIEW_PERSONAL_DETAILS,
        LOGOUT;
    }

    public CustomerView(Customer customer,CustomerController customerController) {
        this.customer = customer;
        this.customerController = customerController;
    }

    public void viewPortal() {

        System.out.println("--------------------Welcome to customer Portal---------------------------");
        whileLoop:
        while (true) {
            CustomerRoles customerRoles;
            for (int i = 0; i < CustomerRoles.values().length; i++) {
                System.out.println(i + 1 + "." + CustomerRoles.values()[i]);
            }
            String option = UtilUserInput.getNumberForSwitch(CustomerRoles.values().length);
            customerRoles = CustomerRoles.values()[Integer.parseInt(option) - 1];
            switch (customerRoles) {
                case VIEW_BIKE:
                    customerController.viewAvailableBike();
                    break;
                case COMPARE_BIKE:
                    BikeTypes bikeType = UtilBikeInput.getBikeType();
                    int bikeId1 = UtilBikeInput.getBikeId();
                    int bikeId2 = UtilBikeInput.getBikeId();
                    if (!customerController.compareBike(bikeType, bikeId1, bikeId2))
                        System.out.println("Enter valid input!!!");
                    break;
                case BUY_BIKE:
                    bikeType = UtilBikeInput.getBikeType();
                    int bikeId = UtilBikeInput.getBikeId();
                    if (customerController.buyBike(customer.getCustomerId(), bikeId, bikeType))       //TO check bike in data
                        System.out.println("Bike is registered to your name");
                    else
                        System.out.println("Enter valid Bike Id");
                    break;
                case VIEW_PERSONAL_DETAILS:
                    customerController.showPersonalDetails();
                    break;
                case LOGOUT:
                    System.out.println("Logged out successfully !!");
                    break whileLoop;
            }
        }
    }
}
