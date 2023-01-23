package bbm.main;

import bbm.Factory.InstanceFactory;
import bbm.application.*;
import bbm.customer.ICustomerController;
import bbm.customer.ICustomerView;
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
        OwnerAccess ownerAccess = InstanceFactory.getOwnerAccessInstance();
        IOwnerController ownerController = InstanceFactory.getOwnerControllerInstance(owner, ownerAccess);
        IOwnerView ownerView = InstanceFactory.getOwnerViewInstance(ownerController);
        ownerView.viewPortal();
        return true;
    }

    public boolean renderManagerPortal(Manager manager) {
        if (manager == null)
            return false;
        ManagerAccess managerAccess = InstanceFactory.getManagerAccessInstance();
        IManagerController managerController = InstanceFactory.getManagerControllerInstance(manager, managerAccess);
        IManagerView managerView = InstanceFactory.getManagerViewInstance(managerController);
        managerView.viewPortal();
        return true;
    }

    public boolean renderSalesExecutivePortal(SalesExecutive salesExecutive) {
        if (salesExecutive == null)
            return false;
        SalesExecutiveAccess salesExecutiveAccess = InstanceFactory.getSalesExecutiveAccessInstance();
        ISalesExecutiveController salesExecutiveController = InstanceFactory.getSalesExecutiveControllerInstance(salesExecutive, salesExecutiveAccess);
        ISalesExecutiveView salesExecutiveView = InstanceFactory.getSalesExecutiveViewInstance(salesExecutiveController);
        salesExecutiveView.viewPortal();
        return true;
    }

    public boolean renderCustomerPortal(Customer customer) {
        if (customer == null)
            return false;
        CustomerAccess customerAccess = InstanceFactory.getCustomerAccessInstance();
        ICustomerController customerController = InstanceFactory.getCustomerControllerInstance(customer, customerAccess);
        ICustomerView customerView = InstanceFactory.getCustomerViewInstance(customer, customerController);
        customerView.viewPortal();
        return true;
    }

    public void addCustomer(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        Customer customer = new Customer(firstName, lastName, userName, password, emailId, phoneNo);
        bbmAccess.addUser(customer);
    }

}
