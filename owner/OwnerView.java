package bbm.owner;

import bbm.utility.UserView.UtilCustomerView;
import bbm.utility.UserView.UtilManagerView;
import bbm.utility.UserView.UtilSalesExecutiveView;
import bbm.utility.UtilUserInput;

import bbm.model.account.*;
import bbm.utility.Validation;

import java.util.List;
import java.util.Scanner;

public class OwnerView {
    enum OwnerRoles {
        ADD_MANAGER,
        ADD_SALES_EXECUTIVE,
        REMOVE_MANAGER,
        REMOVE_SALES_EXECUTIVE,
        VIEW_MANAGER_DETAILS,
        VIEW_SALES_EXECUTIVE_DETAILS,
        VIEW_CUSTOMER_DETAILS,
        VIEW_BIKE_DETAILS,
        VIEW_SOLD_DETAILS,
        VIEW_PERSONAL_DETAILS,
        VIEW_SOLD_BIKE_DETAIL,
        LOGOUT,
    }

    Scanner sc = new Scanner(System.in);

    public void viewPortal(Owner owner) {
        OwnerController ownerController = new OwnerController(owner);
        System.out.println("--------------------Welcome to Owner Portal---------------------------");
        whileLoop:
        while (true) {
            String option;
            OwnerRoles ownerRoles;
            for (int i = 0; i < OwnerRoles.values().length; i++) {
                System.out.println(i + 1 + "." + OwnerRoles.values()[i]);
            }
            do {
                System.out.println("Enter number :");
                option = sc.nextLine();
                System.out.println(option);
            } while (!Validation.validateNumber(option, OwnerRoles.values().length));
            ownerRoles = OwnerRoles.values()[Integer.parseInt(option) - 1];
            switch (ownerRoles) {
                case ADD_MANAGER:
                    System.out.println("Enter Manager Details ");
                    ownerController.addManager(UtilUserInput.getSignUpDetails());
                    break;
                case ADD_SALES_EXECUTIVE:
                    System.out.println("Enter Sales Executive Details ");
                    ownerController.addSalesExecutive(UtilUserInput.getSignUpDetails());
                    break;
                case REMOVE_MANAGER:
                    System.out.println("Enter manager id you want to remove :");
                    if (ownerController.removeManger(sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case REMOVE_SALES_EXECUTIVE:
                    System.out.println("Enter Sales Executive id you want to remove :");
                    if (ownerController.removeSalesExecutive(sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case VIEW_MANAGER_DETAILS:
                    List<Manager> managerList = ownerController.getManagerList();
                    UtilManagerView.showManagerDetails(managerList);
                    break;
                case VIEW_SALES_EXECUTIVE_DETAILS:
                    List<SalesExecutive> salesExecutiveList = ownerController.getSalesExecutiveList();
                    UtilSalesExecutiveView.showSalesExecutiveDetails(salesExecutiveList);
                    break;
                case VIEW_CUSTOMER_DETAILS:
                    List<Customer> customerList = ownerController.getCustomerList();
                    UtilCustomerView.showCustomerDetails(customerList);
                    break;
                case VIEW_BIKE_DETAILS:
                    ownerController.viewAvailableBike();
                    break;
                case VIEW_SOLD_DETAILS:
                    ownerController.viewSoldDetails();
                    break;
                case VIEW_PERSONAL_DETAILS:
                    ownerController.showPersonalDetails();
                    break;
                case VIEW_SOLD_BIKE_DETAIL:
                    ownerController.viewSoldBike();
                    break;
                case LOGOUT:
                    System.out.println("Logged out successfully !!");
                    break whileLoop;
            }
        }
    }
}
