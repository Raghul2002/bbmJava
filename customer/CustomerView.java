package bbm.customer;

import bbm.enumPackage.EnumBikeTypes;
import bbm.manager.BikeManagerController;
import bbm.model.account.Customer;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.utility.UtilBikeInput;
import bbm.utility.Validation;

import java.util.Scanner;


public class CustomerView {
    enum CustomerRoles {
        VIEW_BIKE,
        COMPARE_BIKE,
        BUY_BIKE,
        VIEW_PERSONAL_DETAILS,
        LOGOUT
    }

    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    SalesExecutiveController salesExecutive = new SalesExecutiveController();
    CustomerController customerController = new CustomerController();

    public void viewPortal(Customer customer) {
        System.out.println("--------------------Welcome to customer Portal---------------------------");
        whileLoop:
        while (true) {
            String option;
            CustomerRoles customerRoles;
            for (int i = 0; i < CustomerRoles.values().length; i++) {
                System.out.println(i + 1 + "." + CustomerRoles.values()[i]);
            }
            do {
                System.out.println("Enter number :");
                option = sc.nextLine();
            } while (!Validation.validateNumber(option, CustomerRoles.values().length));
            customerRoles = CustomerRoles.values()[Integer.parseInt(option) - 1];
            switch (customerRoles) {
                case VIEW_BIKE:
                    bikeManager.viewAvailableBike();
                    break;
                case COMPARE_BIKE:
                    if (!salesExecutive.compareBike(UtilBikeInput.getBikesIdToCompare()))
                        System.out.println("Enter valid input!!!");
                    break;
                case BUY_BIKE:
                    EnumBikeTypes bikeType = bikeManager.getBikeType();
                    if (salesExecutive.buyBike(customer.getCustomerId(), bikeManager.getBikeId(bikeType), bikeType))       //TO check bike in data
                        System.out.println("Bike is registered to your name");
                    else
                        System.out.println("Enter valid Bike Id");
                    break;
                case VIEW_PERSONAL_DETAILS:
                    customerController.showPersonalDetails(customer);
                    break;
                case LOGOUT:
                    break whileLoop;
            }
        }
    }
}
