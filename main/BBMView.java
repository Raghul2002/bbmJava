package bbm.main;

import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.utility.UtilUserInput;

public final class BBMView {
    enum UserCategory {
        OWNER,
        MANAGER,
        SALES_EXECUTIVE,
        CUSTOMER,
        EXIT,
    }

    enum AccountAction {
        SIGN_UP,
        SING_IN
    }

    final BBMController bbmController;

    public BBMView(BBMController bbmController) {
        this.bbmController = bbmController;
    }

    public void renderMainView() {
        String val;
        UserCategory userCategory;
        try {
            for (int i = 0; i < UserCategory.values().length; i++) {
                System.out.println(i + 1 + "." + UserCategory.values()[i]);
            }
            val = UtilUserInput.getNumberForSwitch(UserCategory.values().length);
            userCategory = UserCategory.values()[Integer.parseInt(val) - 1];
            switch (userCategory) {
                case OWNER:
                    Owner owner = bbmController.authenticateOwner(UtilUserInput.getUserName(), UtilUserInput.getPassword());
                    if (!bbmController.renderOwnerPortal(owner))
                        System.out.println("Enter valid credentials!!!");
                    break;
                case MANAGER:
                    Manager manager = bbmController.authenticateManager(UtilUserInput.getUserName(), UtilUserInput.getPassword());
                    if (!bbmController.renderManagerPortal(manager))
                        System.out.println("Enter valid credentials!!!");
                    break;
                case SALES_EXECUTIVE:
                    SalesExecutive salesExecutive = bbmController.authenticateSalesExecutive(UtilUserInput.getUserName(), UtilUserInput.getPassword());
                    if (!bbmController.renderSalesExecutivePortal(salesExecutive))
                        System.out.println("Enter valid credentials!!!");
                    break;
                case CUSTOMER:
                    for (int i = 0; i < AccountAction.values().length; i++) {
                        System.out.println(i + 1 + "." + AccountAction.values()[i]);
                    }
                    String type = UtilUserInput.getNumberForSwitch(AccountAction.values().length);
                    AccountAction action = AccountAction.values()[Integer.parseInt(type) - 1];
                    switch (action) {
                        case SIGN_UP:
                            String firstName = UtilUserInput.getFirstName();
                            String lastName = UtilUserInput.getLastName();
                            String userName = UtilUserInput.getUserName();
                            String password = UtilUserInput.getPassword();
                            String emailId = UtilUserInput.getEmailId();
                            String phoneNo = UtilUserInput.getPhoneNo();
                            bbmController.addCustomer(firstName, lastName, userName, password, emailId, phoneNo);
                            System.out.println("Customer added successfully");
                        case SING_IN:
                            Customer customer = bbmController.authenticateCustomer(UtilUserInput.getUserName(), UtilUserInput.getPassword());
                            if (!bbmController.renderCustomerPortal(customer))
                                System.out.println("Enter valid credentials!!!");
                            break;
                    }
                    break;
                case EXIT:
                    System.out.println("Console Closing !!!");
                    return;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        renderMainView();
    }

}
