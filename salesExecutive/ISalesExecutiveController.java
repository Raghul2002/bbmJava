package bbm.salesExecutive;


import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface ISalesExecutiveController {
    List<SalesExecutive> showPersonalDetails() ;
    List<EBike> viewAvailableEBike();
    List<MBike> viewAvailableMBike();
    List<MBike> viewReservedMBike();
    List<EBike> viewReservedEBike();

    boolean confirmBikeBooking();
}
