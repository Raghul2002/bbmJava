package bbm.owner;

import bbm.Factory.BBMFactory;
import bbm.application.OwnerAccess;
import bbm.model.account.*;
import bbm.utility.UserView.UtilOwnerView;
import bbm.utility.UtilBikeView;
import bbm.utility.UtilOrderDetailsView;

import java.util.ArrayList;
import java.util.List;

public final class OwnerController {
    private final Owner owner;
    private final OwnerAccess ownerAccess;

    public OwnerController(Owner owner,OwnerAccess ownerAccess) {
        this.owner = owner;
        this.ownerAccess = ownerAccess;
    }
    void addManager(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        Manager manager = new Manager(firstName, lastName, userName, password, emailId, phoneNo);
        ownerAccess.addUser(manager);
    }

    void addSalesExecutive(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        SalesExecutive salesExecutive = new SalesExecutive(firstName, lastName, userName, password, emailId, phoneNo);
        ownerAccess.addUser(salesExecutive);
    }

    boolean removeManger(String id) {
        return ownerAccess.removeManager(id);
    }

    boolean removeSalesExecutive(String id) {
        return ownerAccess.removeSalesExecutive(id);
    }

    List<Manager> getManagerList() {
        return ownerAccess.getManagerList();
    }

    List<SalesExecutive> getSalesExecutiveList() {
        return ownerAccess.getSalesExecutiveList();
    }

    List<Customer> getCustomerList() {
        return ownerAccess.getCustomerList();
    }

    public void showPersonalDetails() {
        List<Owner> userList = new ArrayList<>();
        userList.add(owner);
        UtilOwnerView.showOwnerDetail(userList);
    }

    public void viewAvailableBike() {
        UtilBikeView.printEBikeList(ownerAccess.getAvailableEBike());
        UtilBikeView.printMBikeList(ownerAccess.getAvailableMBike());
    }

    void viewSoldDetails() {
        UtilOrderDetailsView.viewOrderDetails(ownerAccess.getSoldDetails());
    }

    void viewSoldBike() {
        UtilBikeView.printEBikeList(ownerAccess.getSoldEBike());
        UtilBikeView.printMBikeList(ownerAccess.getSoldMBike());
    }
}