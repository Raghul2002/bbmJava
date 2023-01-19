package bbm.manager;

import bbm.Factory.BBMFactory;
import bbm.main.BBMView;
import bbm.model.account.Manager;
import bbm.model.bike.BikeTypes;
import bbm.utility.UtilBikeInput;
import bbm.utility.UtilUserInput;

import java.util.Scanner;

public final class ManagerView {
    enum ManagerRoles {
        ADD_BIKE,
        REMOVE_BIKE,
        VIEW_BIKE,
        VIEW_PERSONAL_DETAILS,
        LOGOUT,
    }

    private final ManagerController managerController;

    public ManagerView(ManagerController managerController) {
        this.managerController = managerController;
    }

    final Scanner sc = new Scanner(System.in);

    public void viewPortal() {
        System.out.println("--------------------Welcome to manager Portal---------------------------");
        whileLoop:
        while (true) {
            ManagerRoles managerRoles;
            for (int i = 0; i < ManagerRoles.values().length; i++) {
                System.out.println(i + 1 + "." + ManagerRoles.values()[i]);
            }
            String option = UtilUserInput.getNumberForSwitch(ManagerRoles.values().length);
            managerRoles = ManagerRoles.values()[Integer.parseInt(option) - 1];
            switch (managerRoles) {
                case ADD_BIKE:
                    for (int i = 0; i < BikeTypes.values().length; i++) {
                        System.out.println(i + 1 + ".ADD_" + BikeTypes.values()[i]);
                    }
                    UtilBikeInput utilBikeInput = new UtilBikeInput();
                    switch (sc.nextLine()) {
                        case "1":
                            managerController.addBike(utilBikeInput.getMBikeDetails());
                            break;
                        case "2":
                            managerController.addBike(utilBikeInput.getEBikeDetails());
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case REMOVE_BIKE:
                    for (int i = 0; i < BikeTypes.values().length; i++) {
                        System.out.println(i + 1 + ".REMOVE_" + BikeTypes.values()[i]);
                    }
                    switch (sc.nextLine()) {
                        case "1":
                            System.out.println("Enter Mechanical bike ID to remove :");
                            if (managerController.removeMBike(sc.nextInt()))
                                System.out.println("Mechanical Bike successfully removed");
                            else System.out.println("The Mechanical Bike Id you entered does not exist");
                            break;
                        case "2":
                            System.out.println("Enter Electrical bike id to remove :");
                            if (managerController.removeEBike(sc.nextInt()))
                                System.out.println("Electric Bike successfully removed");
                            else System.out.println("The Electrical Bike Id you entered does not exist");
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case VIEW_BIKE:
                    managerController.viewAvailableBike();
                    break;
                case VIEW_PERSONAL_DETAILS:
                    managerController.showPersonalDetails();
                    break;
                case LOGOUT:
                    System.out.println("Logged out successfully !!");
                    break whileLoop;
            }
        }
    }
}
