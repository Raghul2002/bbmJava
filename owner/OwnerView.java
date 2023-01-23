package bbm.owner;

import bbm.utility.UserView.UtilCustomerView;
import bbm.utility.UserView.UtilManagerView;
import bbm.utility.UserView.UtilSalesExecutiveView;
import bbm.utility.UtilUserInput;

import bbm.model.account.*;

import java.util.List;
import java.util.Scanner;

public final class OwnerView implements IOwnerView{
    private final IOwnerController ownerController;
    private final Scanner sc = new Scanner(System.in);

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

    public OwnerView(IOwnerController ownerController) {
        this.ownerController = ownerController;
    }

    public void viewPortal() {
        String firstName = null, lastName = null, userName = null, password = null, emailId = null, phoneNo = null;
        System.out.println("--------------------Welcome to Owner Portal---------------------------");
        whileLoop:
        while (true) {
            OwnerRoles ownerRoles;
            for (int i = 0; i < OwnerRoles.values().length; i++) {
                System.out.println(i + 1 + "." + OwnerRoles.values()[i]);
            }
            String option = UtilUserInput.getNumberForSwitch(OwnerRoles.values().length);
            ownerRoles = OwnerRoles.values()[Integer.parseInt(option) - 1];
            if (ownerRoles == OwnerRoles.ADD_MANAGER || ownerRoles == OwnerRoles.ADD_SALES_EXECUTIVE) {
                System.out.println("\tEnter User Details");
                firstName = UtilUserInput.getFirstName();
                lastName = UtilUserInput.getLastName();
                userName = UtilUserInput.getUserName();
                password = UtilUserInput.getPassword();
                emailId = UtilUserInput.getEmailId();
                phoneNo = UtilUserInput.getPhoneNo();
            }
            switch (ownerRoles) {
                case ADD_MANAGER:
                    ownerController.addManager(firstName, lastName, userName, password, emailId, phoneNo);
                    break;
                case ADD_SALES_EXECUTIVE:
                    ownerController.addSalesExecutive(firstName, lastName, userName, password, emailId, phoneNo);
                    break;
                case REMOVE_MANAGER:
                    System.out.println("Enter manager id you want to remove :");
                    if (ownerController.removeManger(sc.nextLine()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case REMOVE_SALES_EXECUTIVE:
                    System.out.println("Enter Sales Executive id you want to remove :");
                    if (ownerController.removeSalesExecutive(sc.nextLine()))
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
