package bbm.salesExecutive;

import bbm.manager.BikeManagerController;
import bbm.model.account.SalesExecutive;
import bbm.utility.Validation;

import java.util.Scanner;

public class SalesExecutiveView {
    enum SalesExecutiveRoles {
        VIEW_BIKE,
        VIEW_BIKE_ORDERS,
        CONFIRM_BOOKING,
        VIEW_PERSONAL_DETAILS,
        LOGOUT,
    }

    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    SalesExecutiveController salesExecutiveController = new SalesExecutiveController();

    public void viewPortal(SalesExecutive salesExecutive) {
        salesExecutiveWhile:
        while (true) {
            String option;
            SalesExecutiveRoles salesExecutiveRoles;
            for (int i = 0; i < SalesExecutiveRoles.values().length; i++) {
                System.out.println(i + 1 + "." + SalesExecutiveRoles.values()[i]);
            }
            do {
                System.out.println("Enter number :");
                option = sc.nextLine();
            } while (!Validation.validateNumber(option, SalesExecutiveRoles.values().length));
            salesExecutiveRoles = SalesExecutiveRoles.values()[Integer.parseInt(option)-1];
            switch (salesExecutiveRoles) {
                case VIEW_BIKE:
                    bikeManager.viewAvailableBike();
                    break;
                case VIEW_BIKE_ORDERS:
                    bikeManager.viewReservedBike(salesExecutive);
                    break;
                case CONFIRM_BOOKING:
                    bikeManager.confirmBikeBooking(salesExecutive);
                    break;
                case VIEW_PERSONAL_DETAILS:
                    salesExecutiveController.showPersonalDetails(salesExecutive);
                    break;
                case LOGOUT:
                    break salesExecutiveWhile;
            }
        }
    }
}
