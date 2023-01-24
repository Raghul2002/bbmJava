package bbm.salesExecutive;

import bbm.application.SalesExecutiveAccess;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.utility.UserView.UtilSalesExecutiveView;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;

public final class SalesExecutiveController implements ISalesExecutiveController{
    SalesExecutive salesExecutive;
    SalesExecutiveAccess salesExecutiveAccess;

    public SalesExecutiveController(SalesExecutive salesExecutive,SalesExecutiveAccess salesExecutiveAccess) {
        this.salesExecutive = salesExecutive;
        this.salesExecutiveAccess = salesExecutiveAccess;
    }

    public List<SalesExecutive> showPersonalDetails() {
        List<SalesExecutive> userList = new ArrayList<>();
        userList.add(salesExecutive);
        return (userList);
    }
    public List<EBike> viewAvailableEBike() {
        return salesExecutiveAccess.getAvailableEBike();
    }

    @Override
    public List<MBike> viewAvailableMBike() {
        return salesExecutiveAccess.getAvailableMBike();
    }

    public List<MBike> viewReservedMBike() {
        return salesExecutiveAccess.getReservedMBike();
    }
    public List<EBike> viewReservedEBike() {
        return salesExecutiveAccess.getReservedEBike();
    }

    public boolean confirmBikeBooking() {
        return salesExecutiveAccess.confirmBookingOrders(salesExecutive);
    }

}
