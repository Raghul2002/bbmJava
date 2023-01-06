package bbm.authentication;

import bbm.UserAuthentication;
import bbm.dataManager.DataManager;
import bbm.dataManager.IDataManager;
import bbm.model.account.Manager;
import bbm.model.account.User;

import java.util.List;

public class ManagerAuthenticator implements UserAuthentication {
    @Override
    public User authenticate(String userName,String password) {
        IDataManager dataManager = new DataManager();
        List<Manager> managerList = dataManager.getManagerList();
        for (Manager i : managerList)
            if (i.getUserName().equals(userName) && i.getPassword().equals(password))
                return i;
        return null;
    }
}
