package bbm.main;

import bbm.UserAuthentication;
import bbm.customer.CustomerView;
import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.manager.ManagerView;
import bbm.model.account.*;
import bbm.authentication.*;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.owner.OwnerView;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.salesExecutive.SalesExecutiveView;
import bbm.utility.UtilUserInput;
import bbm.utility.Validation;

import java.util.Scanner;

public class BikeBookingManagement {

    static {
        IDatabase db = Database.getInstance();
        db.addUser(new Manager("m", "m", "manager", "r", "@gmail", "3456234234L"));
        db.addUser(new Owner("m", "m", "owner", "t", "@gmail", "3456234234L"));
        db.addUser(new Customer("m", "m", "customer", "h", "@gmail", "3456234234L"));
        db.addUser(new SalesExecutive("m", "m", "sales", "x", "@gmail", "3456234234L"));
        db.addBike(new MBike(1, 2, 3, 4, 5, "1", "2", "3", "4", 5, 1, "2", "3", "4", "5", "3"));
        db.addBike(new MBike(1, 2, 3, 4, 5, "1", "2", "3", "4", 5, 1, "2", "3", "4", "5", "3"));
        db.addBike(new EBike(5, 4, 3, 2, 1, "5", "4", "3", "2", 1, 5, 4, 3, 2));
        db.addBike(new EBike(5, 4, 3, 2, 1, "5", "4", "3", "2", 1, 5, 4, 3, 2));
    }

    enum UserCategory {
        OWNER,
        MANAGER,
        SALES_EXECUTIVE,
        CUSTOMER,
        EXIT,
    }
    enum AccountAction{
        SIGN_UP,
        SING_IN
    }

    private void mainLoop() {
        User user;
        String val;
        UserCategory userCategory;
        UserAuthentication authentication;
        SalesExecutiveController salesExecutive = new SalesExecutiveController();
        Scanner sc = new Scanner(System.in);
        try {
            for (int i = 0; i < UserCategory.values().length; i++) {
                System.out.println(i + 1 + "." + UserCategory.values()[i]);
            }
            do {
                System.out.println("Enter number :");
                val = sc.nextLine();
            } while (!Validation.validateNumber(val, UserCategory.values().length));
            userCategory = UserCategory.values()[Integer.parseInt(val) - 1];
            switch (userCategory) {
                case OWNER:
                    authentication = new OwnerAuthenticator();
                    user = authentication.authenticate(UtilUserInput.getUserName(),UtilUserInput.getPassword());
                    if (user != null) {
                        OwnerView ownerView = new OwnerView();
                        ownerView.viewPortal((Owner) user);
                    }
                    break;
                case MANAGER:
                    authentication = new ManagerAuthenticator();
                    user = authentication.authenticate(UtilUserInput.getUserName(),UtilUserInput.getPassword());
                    if (user instanceof Manager) {
                        ManagerView managerView = new ManagerView();
                        managerView.viewPortal((Manager) user);
                    }
                    break;
                case SALES_EXECUTIVE:
                    authentication = new SalesExecutiveAuthenticator();
                    user = authentication.authenticate(UtilUserInput.getUserName(),UtilUserInput.getPassword());
                    if (user instanceof SalesExecutive) {
                        SalesExecutiveView salesExecutiveView = new SalesExecutiveView();
                        salesExecutiveView.viewPortal((SalesExecutive) user);
                    }
                    break;
                case CUSTOMER:
                    for(int i=0;i<AccountAction.values().length;i++){
                        System.out.println(i+1+"."+AccountAction.values()[i]);
                    }
                    String type;
                    do {
                        System.out.println("Enter number :");
                        type = sc.nextLine();
                    } while (!Validation.validateNumber(val, AccountAction.values().length));
                    AccountAction action = AccountAction.values()[Integer.parseInt(type) - 1];
                    switch (action) {
                        case SIGN_UP:
                            salesExecutive.addCustomer(UtilUserInput.getSignUpDetails());
                            System.out.println("Customer added successfully");
                        case SING_IN:
                            authentication = new CustomerAuthenticator();
                            user = authentication.authenticate(UtilUserInput.getUserName(),UtilUserInput.getPassword());
                            if (user instanceof Customer) {
                                CustomerView customerView = new CustomerView();
                                customerView.viewPortal((Customer) user);
                            }
                            break;
                    }
                    break;
                case EXIT:
                    System.out.println("Console Closing !!!");
                    return;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        mainLoop();
    }

    public static void main(String[] args) {
        BikeBookingManagement bikeBookingManagement = new BikeBookingManagement();
        bikeBookingManagement.mainLoop();
    }
}