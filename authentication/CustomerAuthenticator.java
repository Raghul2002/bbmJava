package bbm.authentication;

import bbm.UserAuthentication;
import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.Customer;
import bbm.model.account.User;

import java.util.List;

public class CustomerAuthenticator implements UserAuthentication {

    public User authenticate(List<String> loginCredentials){
        IDatabase db = Database.getInstance();
        List<Customer> customerList = db.getCustomerList();
        for (Customer i : customerList)
            if( i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
