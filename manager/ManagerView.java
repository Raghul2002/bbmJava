package bbm.manager;

import bbm.bikeManager.EBikeManager;
import bbm.bikeManager.MBikeManager;
import bbm.model.account.Manager;
import bbm.utility.UtilBikeInput;
import bbm.utility.Validation;

import java.util.Scanner;


public class ManagerView {

    enum ManagerRoles {
        ADD_BIKE,
        REMOVE_BIKE,
        VIEW_BIKE,
        VIEW_PERSONAL_DETAILS,
        LOGOUT,
    }

    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    EBikeManager eBikeManager = new EBikeManager();
    MBikeManager mBikeManager = new MBikeManager();

    public void viewPortal(Manager manager) {
        System.out.println("--------------------Welcome to manager Portal---------------------------");
        whileLoop:
        while (true) {
            String option;
            ManagerRoles managerRoles;
            for (int i = 0; i < ManagerRoles.values().length; i++) {
                System.out.println(i + 1 + "." + ManagerRoles.values()[i]);
            }
            do {
                System.out.println("Enter number :");
                option = sc.nextLine();
            } while (!Validation.validateNumber(option, ManagerRoles.values().length));
            managerRoles = ManagerRoles.values()[Integer.parseInt(option) - 1];
            switch (managerRoles) {
                case ADD_BIKE:
                    System.out.println("1.Add Mechanical Bike\n2.Add Electronic Bike");
                    UtilBikeInput utilBikeInput = new UtilBikeInput();
                    switch (sc.nextLine()) {
                        case "1":
                            mBikeManager.addBike(utilBikeInput.getMBikeDetails(), manager);
                            break;
                        case "2":
                            eBikeManager.addBike(utilBikeInput.getEBikeDetails(), manager);
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case REMOVE_BIKE:
                    System.out.println("1.Remove Mechanical Bike\n2.Remove Electric Bike");
                    switch (sc.nextLine()) {
                        case "1":
                            System.out.println("Enter Mechanical bike ID to remove :");
                            if (mBikeManager.removeBike(sc.nextInt(), manager))
                                System.out.println("Mechanical Bike successfully removed");
                            else System.out.println("The Mechanical Bike Id you entered does not exist");
                            break;
                        case "2":
                            System.out.println("Enter Electrical bike id to remove :");
                            if (eBikeManager.removeBike(sc.nextInt(), manager))
                                System.out.println("Electric Bike successfully removed");
                            else System.out.println("The Electrical Bike Id you entered does not exist");
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case VIEW_BIKE:
                    bikeManager.viewAvailableBike();
                    break;
                case VIEW_PERSONAL_DETAILS:
                    bikeManager.showPersonalDetails(manager);
                    break;
                case LOGOUT:
                    break whileLoop;
            }
        }
    }
}
