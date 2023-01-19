package bbm.salesExecutive;

import bbm.Factory.BBMFactory;
import bbm.application.SalesExecutiveAccess;
import bbm.model.account.SalesExecutive;
import bbm.utility.UserView.UtilSalesExecutiveView;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;

public final class SalesExecutiveController {
    SalesExecutive salesExecutive;
    SalesExecutiveAccess salesExecutiveAccess;

    public SalesExecutiveController(SalesExecutive salesExecutive,SalesExecutiveAccess salesExecutiveAccess) {
        this.salesExecutive = salesExecutive;
        this.salesExecutiveAccess = salesExecutiveAccess;
    }

    public void showPersonalDetails() {
        List<SalesExecutive> userList = new ArrayList<>();
        userList.add(salesExecutive);
        UtilSalesExecutiveView.showSalesExecutiveDetails(userList);
    }
    public void viewAvailableBike() {
        UtilBikeView.printEBikeList(salesExecutiveAccess.getAvailableEBike());
        UtilBikeView.printMBikeList(salesExecutiveAccess.getAvailableMBike());
    }
    public void viewReservedBike() {
        UtilBikeView.printEBikeList(salesExecutiveAccess.getReservedEBike());
        UtilBikeView.printMBikeList(salesExecutiveAccess.getReservedMBike());
    }

    public void confirmBikeBooking() {
        salesExecutiveAccess.confirmBookingOrders(salesExecutive);
    }

}
