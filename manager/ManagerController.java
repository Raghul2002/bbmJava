package bbm.manager;

import bbm.Factory.BBMFactory;
import bbm.application.ManagerAccess;
import bbm.model.account.Manager;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.utility.UserView.UtilManagerView;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;

public final class ManagerController {
    private final Manager manager;
    private final ManagerAccess managerAccess;

    public ManagerController(Manager manager,ManagerAccess managerAccess) {
        this.manager = manager;
        this.managerAccess = managerAccess;
    }

    public void addBike(MBike mBike) {
        managerAccess.addBike(mBike, manager);
    }

    public void addBike(EBike eBike) {
        managerAccess.addBike(eBike, manager);
    }

    public void viewAvailableBike() {
        UtilBikeView.printEBikeList(managerAccess.getAvailableEBike());
        UtilBikeView.printMBikeList(managerAccess.getAvailableMBike());
    }

    public void showPersonalDetails() {
        List<Manager> userList = new ArrayList<>();
        userList.add(manager);
        UtilManagerView.showManagerDetails(userList);
    }

    public boolean removeMBike(int bikeId) {
        return managerAccess.removeMBike(bikeId, manager);
    }

    public boolean removeEBike(int bikeId) {
        return managerAccess.removeEBike(bikeId, manager);
    }

}
