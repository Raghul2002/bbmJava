package bbm.owner;

import bbm.SalesRecord.SalesRecord;
import bbm.application.OwnerAccess;
import bbm.model.account.*;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.utility.UserView.UtilOwnerView;
import bbm.utility.UtilBikeView;
import bbm.utility.UtilOrderDetailsView;

import java.util.ArrayList;
import java.util.List;

public final class OwnerController implements IOwnerController{
    private final Owner owner;
    private final OwnerAccess ownerAccess;

    public OwnerController(Owner owner,OwnerAccess ownerAccess) {
        this.owner = owner;
        this.ownerAccess = ownerAccess;
    }
    public void addManager(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        Manager manager = new Manager(firstName, lastName, userName, password, emailId, phoneNo);
        ownerAccess.addUser(manager);
    }

    public void addSalesExecutive(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        SalesExecutive salesExecutive = new SalesExecutive(firstName, lastName, userName, password, emailId, phoneNo);
        ownerAccess.addUser(salesExecutive);
    }

    public boolean removeManger(String id) {
        return ownerAccess.removeManager(id);
    }

    public boolean removeSalesExecutive(String id) {
        return ownerAccess.removeSalesExecutive(id);
    }

    public List<Manager> getManagerList() {
        return ownerAccess.getManagerList();
    }

    public List<SalesExecutive> getSalesExecutiveList() {
        return ownerAccess.getSalesExecutiveList();
    }

    public List<Customer> getCustomerList() {
        return ownerAccess.getCustomerList();
    }

    public List<Owner> showPersonalDetails() {
        List<Owner> userList = new ArrayList<>();
        userList.add(owner);
        return (userList);
    }

    public List<EBike> viewAvailableEBike() {
        return ownerAccess.getAvailableEBike();
    }

    @Override
    public List<MBike> viewAvailableMBike() {
        return ownerAccess.getAvailableMBike();
    }

    public List<SalesRecord> viewSoldDetails() {
        return (ownerAccess.getSoldDetails());
    }

    public List<EBike> viewSoldEBike() {
        return ownerAccess.getSoldEBike();
    }
    public List<MBike> viewSoldMBike() {
        return ownerAccess.getSoldMBike();
    }


}