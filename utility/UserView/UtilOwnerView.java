package bbm.utility.UserView;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.User;

import java.util.List;

public class UtilOwnerView {
    private UtilOwnerView(){}
    private static void ownerHeader() {
        divider();
        System.out.printf("|%15s |%15s |%15s |%20s |%15s |\n","First Name","Last Name","User Name","Email Id","Phone No");
        divider();
    }

    private static void printOwner(User user) {
        System.out.format("|%15s |%15s |%15s |%20s |%15s |\n",user.getFirstName(),user.getLastName(),user.getUserName(),user.getEmailId(),user.getPhoneNo());

    }

    private static void divider() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

    }

    public static void showOwnerDetail(List<Owner> users) {
        if (!users.isEmpty()) {
            System.out.println("Owner Details :");
            ownerHeader();
            for(User user : users)
                printOwner(user);
            divider();
        }
        else System.out.println("Sorry !!\nCurrently no Owner available");

    }
}
