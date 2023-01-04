package bbm.authentication;

import bbm.UserAuthentication;
import bbm.dataManager.IDataManager;
import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.Manager;
import bbm.model.account.User;

import java.util.List;

public class ManagerAuthenticator implements UserAuthentication {
    @Override
    public User authenticate(List<String> loginCredentials) {
        IDataManager dataManager = IDataManager.createDataManagerInstance();
        List<Manager> managerList = dataManager.getManagerList();
        for (Manager i : managerList)
            if (i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
