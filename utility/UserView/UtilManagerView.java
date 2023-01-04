package bbm.utility.UserView;


import bbm.model.account.Manager;

import java.util.List;

public class UtilManagerView {
    private UtilManagerView(){}
    private static void managerHeader(){
        divider();
        System.out.printf("|%11s |%15s |%15s |%15s |%20s |%15s |\n","Manager Id","First Name","Last Name","User Name","Email Id","Phone No");
        divider();
    }
    private static void printManager(Manager user){
        System.out.format("|%11s |%15s |%15s |%15s |%20s |%15s |\n",user.getManagerId(),user.getFirstName(),user.getLastName(),user.getUserName(),user.getEmailId(),user.getPhoneNo());
    }
    public static void showManagerDetails(List<Manager> managerList){
        if (!managerList.isEmpty()) {
            System.out.println("Manager Details :");
            managerHeader();
            for (Manager i : managerList) {
                printManager(i);
            }
            divider();
        }
        else System.out.println("Sorry !!\nCurrently no managers registered");
    }

    private static void divider(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
