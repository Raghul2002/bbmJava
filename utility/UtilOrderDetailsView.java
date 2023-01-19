package bbm.utility;

import bbm.SalesRecord.SalesRecord;

import java.util.List;

public final class UtilOrderDetailsView {
    private UtilOrderDetailsView() {
    }

    public static void viewOrderDetails(List<SalesRecord> orderDetails) {
        if (!orderDetails.isEmpty()) {
            System.out.println("Ordered Bike Details :");
            for (SalesRecord i : orderDetails) {
                System.out.println("Customer Id : " + i.getCustomerId() + "\tBike Id : " + i.getBikeId() + "\tDealer Id : " + i.getSalesExecutiveId());
            }
        } else {
            System.out.println("Sorry Currently no bike sold");
        }
    }
}
