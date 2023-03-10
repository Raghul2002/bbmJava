package bbm.manager;

import bbm.SalesRecord.SalesRecord;
import bbm.application.ManagerAccess;
import bbm.model.account.Manager;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.utility.UtilBikeView;
import bbm.utility.UtilOrderDetailsView;

import java.util.ArrayList;
import java.util.List;

public final class ManagerController implements IManagerController{
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

    public List<EBike> viewAvailableEBike() {
        return managerAccess.getAvailableEBike();
    }

    @Override
    public List<MBike> viewAvailableMBike() {
        return managerAccess.getAvailableMBike();
    }

    public List<Manager> showPersonalDetails() {
        List<Manager> userList = new ArrayList<>();
        userList.add(manager);
        return userList;
    }

    public boolean removeMBike(int bikeId) {
        return managerAccess.removeMBike(bikeId, manager);
    }

    public boolean removeEBike(int bikeId) {
        return managerAccess.removeEBike(bikeId, manager);
    }
    public List<SalesRecord> viewSoldDetails() {
        return managerAccess.getSoldDetails();
    }

    public List<MBike> viewSoldMBike() {
        return (managerAccess.getSoldMBike());
    }
    public List<EBike> viewSoldEBike(){
        return(managerAccess.getSoldEBike());
    }
}
