package bbm.authentication;

import bbm.UserAuthentication;
import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.SalesExecutive;
import bbm.model.account.User;

import java.util.List;

public class SalesExecutiveAuthenticator implements UserAuthentication {
    @Override
    public User authenticate(List<String> loginCredentials) {
        IDatabase db = Database.getInstance();
        List<SalesExecutive> salesExecutiveList = db.getSalesExecutiveList();
        for (SalesExecutive i : salesExecutiveList)
            if( i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
