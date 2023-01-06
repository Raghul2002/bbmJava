package bbm.owner;

import bbm.dataManager.DataManager;
import bbm.manager.BikeManagerController;
import bbm.model.account.*;
import bbm.dataManager.IDataManager;
import bbm.utility.UserView.UtilOwnerView;

import java.util.ArrayList;
import java.util.List;

public class OwnerController {
    Owner owner;
    OwnerController(Owner owner){
        this.owner = owner;
    }
    IDataManager dataManager = new DataManager();
    BikeManagerController bikeManagerController = new BikeManagerController();
    protected void addManager(SignUpDetails details) {
        Manager manager = new Manager(details.getFirstName(), details.getLastName(), details.getUserName(), details.getPassword(), details.getEmailId(), details.getPhoneNo());
        dataManager.addUser(manager);
    }
    protected void addSalesExecutive(SignUpDetails details) {
        SalesExecutive salesExecutive = new SalesExecutive(details.getFirstName(), details.getLastName(), details.getUserName(), details.getPassword(), details.getEmailId(), details.getPhoneNo());
        dataManager.addUser(salesExecutive);
    }

    protected boolean removeManger(int id) {
        List <Manager> managerList = dataManager.getManagerList();
        for (Manager i : managerList) {
            if( i.getManagerId() == id){
                dataManager.removeUser(i);
                return true;
            }
        }
        return false;
    }
    protected boolean removeSalesExecutive(int id) {
        List <SalesExecutive> salesExecutiveList = dataManager.getSalesExecutiveList();
        for (SalesExecutive i : salesExecutiveList) {
            if( i.getSalesExecutiveId() == id){
                dataManager.removeUser(i);
                return true;
            }
        }
        return false;
    }

    protected List<Manager> getManagerList() {
        return dataManager.getManagerList();
    }
    protected List<SalesExecutive> getSalesExecutiveList() {
        return dataManager.getSalesExecutiveList();
    }
    protected List<Customer> getCustomerList() {
        return dataManager.getCustomerList();
    }
    protected void showPersonalDetails(){
        List<Owner> userList = new ArrayList<>();
        userList.add(owner);
        UtilOwnerView.showOwnerDetail(userList);
    }
    protected void viewAvailableBike(){
        bikeManagerController.viewAvailableBike();
    }
    protected void viewSoldDetails(){
        bikeManagerController.viewSoldDetails(owner);
    }

    protected void viewSoldBike(){
        bikeManagerController.viewSoldBike(owner);
    }
}