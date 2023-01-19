package bbm.Factory;


import bbm.application.*;
import bbm.customer.CustomerController;
import bbm.customer.CustomerView;
import bbm.dataManager.DataManager;
import bbm.dataManager.IDataManager;
import bbm.application.BBMAccess;
import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.main.BBMController;
import bbm.main.BBMView;
import bbm.manager.ManagerController;
import bbm.manager.ManagerView;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.owner.OwnerController;
import bbm.owner.OwnerView;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.salesExecutive.SalesExecutiveView;

public class BBMFactory {
    private BBMFactory(){}
    public static IDatabase getIDatabaseInstance(){
        return Database.getInstance();
    }
    public static IDataManager getIDataManagerInstance(){
        return DataManager.getInstance();
    }
    public static BBMAccess getBBMAccessInstance() {
        return new ApplicationManager();
    }

    public static OwnerAccess getOwnerAccessInstance() {
        return new ApplicationManager();
    }

    public static ManagerAccess getManagerAccessInstance() {
        return new ApplicationManager();
    }

    public static SalesExecutiveAccess getSalesExecutiveAccessInstance() {
        return new ApplicationManager();
    }

    public static CustomerAccess getCustomerAccessInstance() {
        return new ApplicationManager();
    }

    public static BBMController getBBMControllerInstance(BBMAccess bbmAccess) {
        return new BBMController(bbmAccess);
    }
    public static ManagerController getManagerControllerInstance(Manager manager,ManagerAccess managerAccess){
        return new ManagerController(manager,managerAccess);
    }
    public static SalesExecutiveController getSalesExecutiveControllerInstance(SalesExecutive salesExecutive,SalesExecutiveAccess salesExecutiveAccess){
        return new SalesExecutiveController(salesExecutive,salesExecutiveAccess);
    }
    public static OwnerController getOwnerControllerInstance(Owner owner,OwnerAccess ownerAccess){
        return new OwnerController(owner,ownerAccess);
    }
    public static CustomerController getCustomerControllerInstance(Customer customer,CustomerAccess customerAccess){
        return new CustomerController(customer,customerAccess);
    }
    public static BBMView getBBMViewInstance(BBMController bbmController) {
        return new BBMView(bbmController);
    }

    public static CustomerView getCustomerViewInstance(Customer customer,CustomerController customerController) {
        return new CustomerView(customer,customerController);
    }

    public static SalesExecutiveView getSalesExecutiveViewInstance(SalesExecutiveController salesExecutiveController) {
        return new SalesExecutiveView(salesExecutiveController);
    }

    public static ManagerView getManagerViewInstance(ManagerController managerController) {
        return new ManagerView(managerController);
    }

    public static OwnerView getOwnerViewInstance(OwnerController ownerController) {
        return new OwnerView(ownerController);
    }

}