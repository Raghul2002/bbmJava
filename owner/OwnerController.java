package bbm.owner;

import bbm.dataManager.DataManager;
import bbm.model.account.*;
import bbm.dataManager.IDataManager;
import bbm.utility.UserView.UtilOwnerView;
import bbm.enumPackage.EnumUserDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnerController {
    IDataManager dataManager = new DataManager();
    protected void addManager(Owner owner, HashMap<EnumUserDetails, String> details) {
        String firstName =  details.get(EnumUserDetails.FIRST_NAME);
        String lastName =  details.get(EnumUserDetails.LAST_NAME);
        String userName =  details.get(EnumUserDetails.USER_NAME);
        String password =  details.get(EnumUserDetails.PASSWORD);
        String emailId =  details.get(EnumUserDetails.EMAIL_ID);
        String phoneNo =  details.get(EnumUserDetails.PHONE_NO);
        Manager manager = new Manager(firstName, lastName, userName, password, emailId, phoneNo);
        dataManager.addUser(manager);
    }
    protected void addSalesExecutive(Owner owner,HashMap<EnumUserDetails, String> details) {
        String firstName =  details.get(EnumUserDetails.FIRST_NAME);
        String lastName =  details.get(EnumUserDetails.LAST_NAME);
        String userName =  details.get(EnumUserDetails.USER_NAME);
        String password =  details.get(EnumUserDetails.PASSWORD);
        String emailId =  details.get(EnumUserDetails.EMAIL_ID);
        String phoneNo =  details.get(EnumUserDetails.PHONE_NO);
        SalesExecutive salesExecutive = new SalesExecutive(firstName, lastName, userName, password, emailId, phoneNo);
        dataManager.addUser(salesExecutive);
    }

    protected boolean removeManger(Owner owner,int id) {
        List <Manager> managerList = dataManager.getManagerList();
        for (Manager i : managerList) {
            if( i.getManagerId() == id){
                dataManager.removeUser(i);
                return true;
            }
        }
        return false;
    }
    protected boolean removeSalesExecutive(Owner owner,int id) {
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
    protected void showPersonalDetails(Owner owner){
        List<Owner> userList = new ArrayList<>();
        userList.add(owner);
        UtilOwnerView.showOwnerDetail(userList);
    }
}