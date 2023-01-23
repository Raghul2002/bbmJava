package bbm.Factory;


import bbm.Factory.enumeration.DatabaseTypes;
import bbm.Factory.enumeration.IDataManagerTypes;
import bbm.application.*;
import bbm.customer.CustomerController;
import bbm.customer.CustomerView;
import bbm.customer.ICustomerController;
import bbm.dataManager.DataManager;
import bbm.dataManager.IDataManager;
import bbm.application.BBMAccess;
import bbm.database.ListDatabase;
import bbm.database.Database;
import bbm.main.BBMController;
import bbm.main.BBMView;
import bbm.main.IBBMController;
import bbm.manager.IManagerController;
import bbm.manager.ManagerController;
import bbm.manager.ManagerView;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.owner.IOwnerController;
import bbm.owner.OwnerController;
import bbm.owner.OwnerView;
import bbm.salesExecutive.ISalesExecutiveController;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.salesExecutive.SalesExecutiveView;

public class InstanceFactory {
    private InstanceFactory() {
    }

    public static Database getDatabaseInstance(DatabaseTypes types) {
        if (types == DatabaseTypes.ListDatabase) {
            return ListDatabase.getInstance();
        }
        return null;
    }

    public static IDataManager getIDataManagerInstance(IDataManagerTypes types) {
        if (types == IDataManagerTypes.DataManager) {
            return DataManager.getInstance();
        }
        return null;
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

    public static ManagerController getManagerControllerInstance(Manager manager, ManagerAccess managerAccess) {
        return new ManagerController(manager, managerAccess);
    }

    public static SalesExecutiveController getSalesExecutiveControllerInstance(SalesExecutive salesExecutive, SalesExecutiveAccess salesExecutiveAccess) {
        return new SalesExecutiveController(salesExecutive, salesExecutiveAccess);
    }

    public static OwnerController getOwnerControllerInstance(Owner owner, OwnerAccess ownerAccess) {
        return new OwnerController(owner, ownerAccess);
    }

    public static ICustomerController getCustomerControllerInstance(Customer customer, CustomerAccess customerAccess) {
        return new CustomerController(customer, customerAccess);
    }

    public static BBMView getBBMViewInstance(IBBMController bbmController) {
        return new BBMView(bbmController);
    }

    public static CustomerView getCustomerViewInstance(Customer customer, ICustomerController customerController) {
        return new CustomerView(customer, customerController);
    }

    public static SalesExecutiveView getSalesExecutiveViewInstance(ISalesExecutiveController salesExecutiveController) {
        return new SalesExecutiveView(salesExecutiveController);
    }

    public static ManagerView getManagerViewInstance(IManagerController managerController) {
        return new ManagerView(managerController);
    }

    public static OwnerView getOwnerViewInstance(IOwnerController ownerController) {
        return new OwnerView(ownerController);
    }
}