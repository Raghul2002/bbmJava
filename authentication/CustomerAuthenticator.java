package bbm.authentication;

import bbm.UserAuthentication;
import bbm.dataManager.DataManager;
import bbm.dataManager.IDataManager;
import bbm.model.account.Customer;
import bbm.model.account.User;

import java.util.List;

public class CustomerAuthenticator implements UserAuthentication {

    public User authenticate(String userName,String password){
        IDataManager dataManager = new DataManager();
        List<Customer> customerList = dataManager.getCustomerList();
        for (Customer i : customerList)
            if( i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }
}
