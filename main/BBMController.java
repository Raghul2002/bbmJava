package bbm.main;

import bbm.Factory.BBMFactory;
import bbm.application.*;
import bbm.customer.CustomerController;
import bbm.customer.CustomerView;
import bbm.manager.ManagerController;
import bbm.manager.ManagerView;
import bbm.model.account.*;
import bbm.owner.OwnerController;
import bbm.owner.OwnerView;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.salesExecutive.SalesExecutiveView;

public final class BBMController {
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
        OwnerAccess ownerAccess = BBMFactory.getOwnerAccessInstance();
        OwnerController ownerController = BBMFactory.getOwnerControllerInstance(owner, ownerAccess);
        OwnerView ownerView = BBMFactory.getOwnerViewInstance(ownerController);
        ownerView.viewPortal();
        return true;
    }

    public boolean renderManagerPortal(Manager manager) {
        if (manager == null)
            return false;
        ManagerAccess managerAccess = BBMFactory.getManagerAccessInstance();
        ManagerController managerController = BBMFactory.getManagerControllerInstance(manager,managerAccess);
        ManagerView managerView = BBMFactory.getManagerViewInstance(managerController);
        managerView.viewPortal();
        return true;
    }

    public boolean renderSalesExecutivePortal(SalesExecutive salesExecutive) {
        if (salesExecutive == null)
            return false;
        SalesExecutiveAccess salesExecutiveAccess = BBMFactory.getSalesExecutiveAccessInstance();
        SalesExecutiveController salesExecutiveController = BBMFactory.getSalesExecutiveControllerInstance(salesExecutive,salesExecutiveAccess);
        SalesExecutiveView salesExecutiveView = BBMFactory.getSalesExecutiveViewInstance(salesExecutiveController);
        salesExecutiveView.viewPortal();
        return true;
    }

    public boolean renderCustomerPortal(Customer customer) {
        if (customer == null)
            return false;
        CustomerAccess customerAccess = BBMFactory.getCustomerAccessInstance();
        CustomerController customerController = BBMFactory.getCustomerControllerInstance(customer, customerAccess);
        CustomerView customerView = BBMFactory.getCustomerViewInstance(customer, customerController);
        customerView.viewPortal();
        return true;
    }


    public void addCustomer(String firstName, String lastName, String userName, String password, String emailId, String phoneNo) {
        Customer customer = new Customer(firstName, lastName, userName, password, emailId, phoneNo);
        bbmAccess.addUser(customer);
    }

}
