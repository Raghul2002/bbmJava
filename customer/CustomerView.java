package bbm.customer;

import bbm.model.bike.BikeTypes;
import bbm.model.account.Customer;
import bbm.utility.UserView.UtilCustomerView;
import bbm.utility.UtilBikeInput;
import bbm.utility.UtilBikeView;
import bbm.utility.UtilUserInput;

public final class CustomerView implements ICustomerView{
    private final Customer customer;
    private final ICustomerController customerController;

    enum CustomerRoles {
        VIEW_AVAILABLE_MECHANICAL_BIKE,
        VIEW_AVAILABLE_ELECTRIC_BIKE,
        COMPARE_BIKE,
        BUY_BIKE,
        VIEW_PERSONAL_DETAILS,
        MY_BIKE_DETAILS,
        LOGOUT
    }

    public CustomerView(Customer customer,ICustomerController customerController) {
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
                case VIEW_AVAILABLE_MECHANICAL_BIKE:
                    UtilBikeView.printMBikeList(customerController.viewAvailableMBike());
                    break;
                case VIEW_AVAILABLE_ELECTRIC_BIKE:
                    UtilBikeView.printEBikeList(customerController.viewAvailableEBike());
                    break ;
                case COMPARE_BIKE:
                    BikeTypes bikeType = UtilBikeInput.getBikeType();
                    int bikeId1 = UtilBikeInput.getBikeId();
                    int bikeId2 = UtilBikeInput.getBikeId();
                    if (!customerController.compareBike(bikeType, bikeId1, bikeId2))
                        System.out.println("Enter valid input!!!");
                    break;
                case BUY_BIKE:
                    UtilBikeView.printMBikeList(customerController.viewAvailableMBike());
                    UtilBikeView.printEBikeList(customerController.viewAvailableEBike());
                    bikeType = UtilBikeInput.getBikeType();
                    int bikeId = UtilBikeInput.getBikeId();
                    if (customerController.buyBike(customer.getCustomerId(), bikeId, bikeType))       //TO check bike in data
                        System.out.println("Bike is registered to your name");
                    else
                        System.out.println("Enter valid Bike Id");
                    break;
                case VIEW_PERSONAL_DETAILS:
                    UtilCustomerView.showCustomerDetails(customerController.showPersonalDetails());
                    break ;
                case MY_BIKE_DETAILS:
                    UtilBikeView.printMBikeList(customerController.getCustomerMBike());
                    UtilBikeView.printEBikeList(customerController.getCustomerEBike());
                    break;
                case LOGOUT:
                    System.out.println("Logged out successfully !!");
                    break whileLoop;
            }
        }
    }
}
