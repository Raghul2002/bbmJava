package bbm.customer;

import bbm.manager.BikeManagerController;
import bbm.model.account.Customer;
import bbm.utility.UserView.UtilCustomerView;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    Customer customer ;
    CustomerController(Customer customer){
        this.customer = customer;
    }
    BikeManagerController bikeManagerController = new BikeManagerController();
    protected void showPersonalDetails(){
        List<Customer> userList = new ArrayList<>();
        userList.add(this.customer);
        UtilCustomerView.showCustomerDetails(userList);
    }
    protected void viewAvailableBike(){
        bikeManagerController.viewAvailableBike();
    }
//    boolean buyBike(){
//
//    }
}
