package bbm.customer;

import bbm.model.account.Customer;
import bbm.utility.UserView.UtilCustomerView;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    protected void showPersonalDetails(Customer customer){
        List<Customer> userList = new ArrayList<>();
        userList.add(customer);
        UtilCustomerView.showCustomerDetails(userList);
    }
}
