package bbm.salesExecutive;

import bbm.utility.UtilUserInput;

public final class SalesExecutiveView implements ISalesExecutiveView{
    ISalesExecutiveController salesExecutiveController;
    enum SalesExecutiveRoles {
        VIEW_BIKE,
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
                case VIEW_BIKE:
                    salesExecutiveController.viewAvailableBike();
                    break;
                case VIEW_BIKE_ORDERS:
                    salesExecutiveController.viewReservedBike();
                    break;
                case CONFIRM_BOOKING:
                    salesExecutiveController.confirmBikeBooking();
                    break;
                case VIEW_PERSONAL_DETAILS:
                    salesExecutiveController.showPersonalDetails();
                    break;
                case LOGOUT:
                    System.out.println("Logged out successfully !!");
                    break salesExecutiveWhile;
            }
        }
    }
}
