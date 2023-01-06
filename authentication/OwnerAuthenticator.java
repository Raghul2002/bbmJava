package bbm.authentication;

import bbm.UserAuthentication;
import bbm.dataManager.DataManager;
import bbm.dataManager.IDataManager;
import bbm.model.account.Owner;
import bbm.model.account.User;

import java.util.List;

public class OwnerAuthenticator implements UserAuthentication {
    public User authenticate(String userName,String password){
        IDataManager dataManager = new DataManager();
        List<Owner> ownerList = dataManager.getOwnerList();
        for (Owner i : ownerList)
            if( i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }
}
