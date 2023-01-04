package bbm;
import bbm.model.account.User;

import java.util.List;

public interface UserAuthentication {
    User authenticate(List<String> loginCredentials);
}