package bbm.utility.UserView;

import bbm.model.account.SalesExecutive;

import java.util.List;

public class UtilSalesExecutiveView {
    private UtilSalesExecutiveView(){}
    private static void salesExecutiveHeader() {
        divider();
        System.out.printf("|%18s |%15s |%15s |%15s |%20s |%15s |\n", "SalesExecutive Id", "First Name", "Last Name", "User Name", "Email Id", "Phone No");
        divider();
    }

    private static void printSalesExecutive(SalesExecutive i) {
        System.out.format("|%18s |%15s |%15s |%15s |%20s |%15s |\n", i.getSalesExecutiveId(), i.getFirstName(), i.getLastName(), i.getUserName(), i.getEmailId(), i.getPhoneNo());
    }

    public static void showSalesExecutiveDetails(List<SalesExecutive> salesExecutiveList) {
        if (!salesExecutiveList.isEmpty()) {
            System.out.println("Sales Executive Details :");
            salesExecutiveHeader();
            for (SalesExecutive i : salesExecutiveList) {
                printSalesExecutive(i);
            }
            divider();
        } else System.out.println("Sorry !!\nCurrently no sales executives registered");
    }


    private static void divider() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
