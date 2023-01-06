package bbm.authentication;

import bbm.UserAuthentication;
import bbm.dataManager.DataManager;
import bbm.dataManager.IDataManager;
import bbm.model.account.SalesExecutive;
import bbm.model.account.User;

import java.util.List;

public class SalesExecutiveAuthenticator implements UserAuthentication {
    @Override
    public User authenticate(String userName, String password) {
        IDataManager dataManager = new DataManager();
        List<SalesExecutive> salesExecutiveList = dataManager.getSalesExecutiveList();
        for (SalesExecutive i : salesExecutiveList)
            if( i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }
}
