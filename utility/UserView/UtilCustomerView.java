package bbm.utility.UserView;

import bbm.model.account.Customer;

import java.util.List;

public class UtilCustomerView {
    private UtilCustomerView(){}
    private static void customerHeader() {
        divider();
        System.out.printf("|%11s |%15s |%15s |%15s |%20s |%15s |\n", "Customer Id", "First Name", "Last Name", "User Name", "Email Id", "Phone No");
        divider();
    }

    private static void printCustomer(Customer user) {
        System.out.format("|%11s |%15s |%15s |%15s |%20s |%15s |\n", user.getCustomerId(), user.getFirstName(), user.getLastName(), user.getUserName(), user.getEmailId(), user.getPhoneNo());
    }

    public static void showCustomerDetails(List<Customer> customerList) {
        if (!customerList.isEmpty()) {
            System.out.println("Customer Details :");
            customerHeader();
            for (Customer i : customerList) {
                printCustomer(i);
            }
            divider();
        } else System.out.println("Sorry !!\nCurrently no customers registered");
    }

    private static void divider() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}
