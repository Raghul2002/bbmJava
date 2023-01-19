package bbm.application;

import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface SalesExecutiveAccess {
    List<MBike> getAvailableMBike();

    List<EBike> getAvailableEBike();
    List<MBike> getReservedMBike();
    List<EBike> getReservedEBike();
    void confirmBookingOrders(SalesExecutive salesExecutive);
}
