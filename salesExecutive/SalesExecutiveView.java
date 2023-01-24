package bbm.salesExecutive;

import bbm.utility.UserView.UtilSalesExecutiveView;
import bbm.utility.UtilBikeView;
import bbm.utility.UtilUserInput;

public final class SalesExecutiveView implements ISalesExecutiveView{
    ISalesExecutiveController salesExecutiveController;
    enum SalesExecutiveRoles {
        VIEW_AVAILABLE_MECHANICAL_BIKE,
        VIEW_AVAILABLE_ELECTRIC_BIKE,
        VIEW_BIKE_ORDERS,
        CONFIRM_BOOKING,
        VIEW_PERSONAL_DETAILS,
        LOGOUT,
    }

    public SalesExecutiveView(ISalesExecutiveController salesExecutiveController) {
        this.salesExecutiveController = salesExecutiveController;
    }

    public void viewPortal() {
        salesExecutiveWhile:
        while (true) {
            SalesExecutiveRoles salesExecutiveRoles;
            for (int i = 0; i < SalesExecutiveRoles.values().length; i++) {
                System.out.println(i + 1 + "." + SalesExecutiveRoles.values()[i]);
            }
            String option = UtilUserInput.getNumberForSwitch(SalesExecutiveRoles.values().length);
            salesExecutiveRoles = SalesExecutiveRoles.values()[Integer.parseInt(option) - 1];
            switch (salesExecutiveRoles) {
                case VIEW_AVAILABLE_MECHANICAL_BIKE:
                    UtilBikeView.printMBikeList(salesExecutiveController.viewAvailableMBike());
                    break;
                case VIEW_AVAILABLE_ELECTRIC_BIKE:
                    UtilBikeView.printEBikeList(salesExecutiveController.viewAvailableEBike());
                    break ;
                case VIEW_BIKE_ORDERS:
                    salesExecutiveController.viewReservedBike();
                    break;
                case CONFIRM_BOOKING:
                    if(salesExecutiveController.confirmBikeBooking())
                        System.out.println("Successfully Booked");
                    else
                        System.out.println("Sorry Currently No Bike Available for booking");
                    break;
                case VIEW_PERSONAL_DETAILS:
                    UtilSalesExecutiveView.showSalesExecutiveDetails(salesExecutiveController.showPersonalDetails());
                    break;
                case LOGOUT:
                    System.out.println("Logged out successfully !!");
                    break salesExecutiveWhile;
            }
        }
    }
}
