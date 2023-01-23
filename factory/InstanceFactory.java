package bbm.factory;


import bbm.customer.ICustomerView;
import bbm.factory.enumeration.accessEnum.*;
import bbm.factory.enumeration.DatabaseImplTypes;
import bbm.factory.enumeration.IDataManagerImplTypes;
import bbm.application.*;
import bbm.customer.CustomerController;
import bbm.customer.CustomerView;
import bbm.customer.ICustomerController;
import bbm.dataManager.DataManager;
import bbm.dataManager.IDataManager;
import bbm.application.BBMAccess;
import bbm.database.ListDatabase;
import bbm.database.Database;
import bbm.factory.enumeration.controllerEnum.*;
import bbm.factory.enumeration.viewEnum.*;
import bbm.main.BBMController;
import bbm.main.BBMView;
import bbm.main.IBBMController;
import bbm.manager.IManagerController;
import bbm.manager.IManagerView;
import bbm.manager.ManagerController;
import bbm.manager.ManagerView;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.owner.IOwnerController;
import bbm.owner.IOwnerView;
import bbm.owner.OwnerController;
import bbm.owner.OwnerView;
import bbm.salesExecutive.ISalesExecutiveController;
import bbm.salesExecutive.ISalesExecutiveView;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.salesExecutive.SalesExecutiveView;

public class InstanceFactory {
    private InstanceFactory() {
    }

    public static Database getDatabaseInstance(DatabaseImplTypes type) {
        if (type == DatabaseImplTypes.ListDatabase) {
            return ListDatabase.getInstance();
        }
        return null;
    }

    public static IDataManager getIDataManagerInstance(IDataManagerImplTypes type) {
        if (type == IDataManagerImplTypes.DataManager) {
            return DataManager.getInstance();
        }
        return null;
    }

    public static BBMAccess getBBMAccessInstance(BBMAccessImplTypes type) {
        if (type == BBMAccessImplTypes.ApplicationManager) {
            return new ApplicationManager();
        }
        return null;
    }

    public static OwnerAccess getOwnerAccessInstance(OwnerAccessImplTypes type) {
        if (type == OwnerAccessImplTypes.ApplicationManager) {
            return new ApplicationManager();
        }
        return null;
    }

    public static ManagerAccess getManagerAccessInstance(ManagerAccessImplTypes type) {
        if (type == ManagerAccessImplTypes.ApplicationManager) {
            return new ApplicationManager();
        }
        return null;
    }

    public static SalesExecutiveAccess getSalesExecutiveAccessInstance(SalesExecutiveAccessImplTypes type) {
        if (type == SalesExecutiveAccessImplTypes.ApplicationManager) {
            return new ApplicationManager();
        }
        return null;
    }

    public static CustomerAccess getCustomerAccessInstance(CustomerAccessImplTypes type) {
        if (type == CustomerAccessImplTypes.ApplicationManager) {
            return new ApplicationManager();
        }
        return null;    }

    public static BBMController getBBMControllerInstance(BBMControllerImplTypes type, BBMAccess bbmAccess) {
        if (type == BBMControllerImplTypes.BBMController) {
            return new BBMController(bbmAccess);
        }
        return null;
    }

    public static IManagerController getManagerControllerInstance(ManagerControllerImplTypes type, Manager manager, ManagerAccess managerAccess) {
        if (type == ManagerControllerImplTypes.ManagerController) {
            return new ManagerController(manager, managerAccess);
        }
        return null;
    }

    public static ISalesExecutiveController getSalesExecutiveControllerInstance(SalesExecutiveControllerImplTypes type, SalesExecutive salesExecutive, SalesExecutiveAccess salesExecutiveAccess) {
        if (type == SalesExecutiveControllerImplTypes.SalesExecutiveController) {
            return new SalesExecutiveController(salesExecutive, salesExecutiveAccess);
        }
        return null;
    }

    public static IOwnerController getOwnerControllerInstance(OwnerControllerImplTypes type,Owner owner, OwnerAccess ownerAccess) {
        if (type == OwnerControllerImplTypes.OwnerController) {
            return new OwnerController(owner, ownerAccess);
        }
        return null;
    }

    public static ICustomerController getCustomerControllerInstance(CustomerControllerImplTypes type,Customer customer, CustomerAccess customerAccess) {
        if (type == CustomerControllerImplTypes.CustomerController) {
            return new CustomerController(customer, customerAccess);
        }
        return null;
    }

    public static BBMView getBBMViewInstance(BBMViewImplTypes type, IBBMController bbmController) {
        if (type == BBMViewImplTypes.BBMView) {
            return new BBMView(bbmController);
        }
        return null;
    }

    public static ICustomerView getCustomerViewInstance(CustomerViewImplTypes type, Customer customer, ICustomerController customerController) {
        if (type == CustomerViewImplTypes.CustomerView) {
            return new CustomerView(customer, customerController);
        }
        return null;
    }

    public static ISalesExecutiveView getSalesExecutiveViewInstance(SalesExecutiveViewImplTypes type, ISalesExecutiveController salesExecutiveController) {
        if (type == SalesExecutiveViewImplTypes.SalesExecutiveView) {
            return new SalesExecutiveView(salesExecutiveController);
        }
        return null;
    }

    public static IManagerView getManagerViewInstance(ManagerViewImplTypes type, IManagerController managerController) {
        if (type == ManagerViewImplTypes.ManagerView) {
            return new ManagerView(managerController);
        }
        return null;
    }

    public static IOwnerView getOwnerViewInstance(OwnerViewImplTypes type, IOwnerController ownerController) {
        if (type == OwnerViewImplTypes.OwnerView) {
            return new OwnerView(ownerController);
        }
        return null;
    }
}