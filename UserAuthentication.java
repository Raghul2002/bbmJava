package bbm;
import bbm.model.account.User;

public interface UserAuthentication {
    User authenticate(String userName,String password);
}