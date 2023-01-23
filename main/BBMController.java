package bbm.main;

import bbm.factory.InstanceFactory;
import bbm.application.*;
import bbm.customer.ICustomerController;
import bbm.customer.ICustomerView;
import bbm.factory.enumeration.accessEnum.CustomerAccessImplTypes;
import bbm.factory.enumeration.accessEnum.ManagerAccessImplTypes;
import bbm.factory.enumeration.accessEnum.OwnerAccessImplTypes;
import bbm.factory.enumeration.accessEnum.SalesExecutiveAccessImplTypes;
import bbm.factory.enumeration.controllerEnum.CustomerControllerImplTypes;
import bbm.factory.enumeration.controllerEnum.ManagerControllerImplTypes;
import bbm.factory.enumeration.controllerEnum.OwnerControllerImplTypes;
import bbm.factory.enumeration.controllerEnum.SalesExecutiveControllerImplTypes;
import bbm.factory.enumeration.viewEnum.CustomerViewImplTypes;
import bbm.factory.enumeration.viewEnum.ManagerViewImplTypes;
import bbm.factory.enumeration.viewEnum.OwnerViewImplTypes;
import bbm.factory.enumeration.viewEnum.SalesExecutiveViewImplTypes;
import bbm.manager.IManagerController;
import bbm.manager.IManagerView;
import bbm.model.account.*;
import bbm.owner.IOwnerController;
import bbm.owner.IOwnerView;
import bbm.salesExecutive.ISalesExecutiveController;
import bbm.salesExecutive.ISalesExecutiveView;

public final class BBMController implements IBBMController {
    private final BBMAccess bbmAccess;

    public BBMController(BBMAccess bbmAccess) {
        this.bbmAccess = bbmAccess;
    }

    public Owner authenticateOwner(String userName, String password) {
        return bbmAccess.authenticateOwner(userName, password);
    }

    public Manager authenticateManager(String userName, String password) {
        return bbmAccess.authenticateManager(userName, password);
    }

    public SalesExecutive authenticateSalesExecutive(String userName, String password) {
        return bbmAccess.authenticateSalesExecutive(userName, password);
    }

    public Customer authenticateCustomer(String userName, String password) {
        return bbmAccess.authenticateCustomer(userName, password);
    }

    public boolean renderOwnerPortal(Owner owner) {
        if (owner == null)
            return false;
        OwnerAccess ownerAccess = InstanceFactory.getOwnerAccessInstance(OwnerAccessImplTypes.ApplicationManager);
        IOwnerController ownerController = InstanceFactory.getOwnerControllerInstance(OwnerControllerImplTypes.OwnerController,owner, ownerAccess);
        IOwnerView ownerView = InstanceFactory.getOwnerViewInstance(OwnerViewImplTypes.OwnerView,ownerController);
        if( ownerView != null)
            ownerView.viewPortal();
        return true;
    }

    public boolean renderManagerPortal(Manager manager) {
        if (manager == null)
            return false;
        ManagerAccess managerAccess = InstanceFactory.getManagerAccessInstance(ManagerAccessImplTypes.ApplicationManager);
        IManagerController managerController = InstanceFactory.getManagerControllerInstance(ManagerControllerImplTypes.ManagerController,manager, managerAccess);
        IManagerView managerView = InstanceFactory.getManagerViewInstance(ManagerViewImplTypes.ManagerView,managerController);
        if(managerView != null)
            managerView.viewPortal();
        return true;
    }

    public boolean renderSalesExecutivePortal(SalesExecutive salesExecutive) {
        if (salesExecutive == null)
            return false;
        SalesExecutiveAccess salesExecutiveAccess = InstanceFactory.getSalesExecutiveAccessInstance(SalesExecutiveAccessImplTypes.ApplicationManager);
        ISalesExecutiveController salesExecutiveController = InstanceFactory.getSalesExecutiveControllerInstance(SalesExecutiveControllerImplTypes.SalesExecutiveController,salesExecutive, salesExecutiveAccess);
        ISalesExecutiveView salesExecutiveView = InstanceFactory.getSalesExecutiveViewInstance(SalesExecutiveViewImplTypes.SalesExecutiveView,salesExecutiveController);
        if (salesExecutiveView != null)
            salesExecutiveView.viewPortal();
        return true;
    }

    public boolean renderCustomerPortal(Customer customer) {
        if (customer == null)
            return false;
        CustomerAccess customerAccess = InstanceFactory.getCustomerAccessInstance(CustomerAccessImplTypes.ApplicationManager);
        ICustomerController customerController = InstanceFactory.getCustomerControllerInstance(CustomerControllerImplTypes.CustomerController,customer, customerAccess);
        ICustomerView customerView = InstanceFactory.getCustomerViewInstance(CustomerViewImplTypes.CustomerView,customer, customerController);
        if (customerView != null)
            customerView.viewPortal();
        return true;
    }

    public void addCustomer(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        Customer customer = new Customer(firstName, lastName, userName, password, emailId, phoneNo);
        bbmAccess.addUser(customer);
    }

}
