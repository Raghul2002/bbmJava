package bbm.salesExecutive;

import bbm.enumPackage.EnumBikeTypes;
import bbm.bikeManager.EBikeManager;
import bbm.bikeManager.MBikeManager;
import bbm.dataManager.DataManager;
import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Customer;
import bbm.model.account.SalesExecutive;
import bbm.model.account.SignUpDetails;
import bbm.utility.UserView.UtilSalesExecutiveView;

import java.util.ArrayList;
import java.util.List;

public class SalesExecutiveController {
    DataManager dataManager = new DataManager();
    EBikeManager eBikeManager = new EBikeManager();
    MBikeManager mBikeManager = new MBikeManager();

    public boolean compareBike(List<Integer> bikeDetails) {
        if (bikeDetails.get(1).equals(bikeDetails.get(2)))
            return false;
        switch (bikeDetails.get(0)) {
            case 1:
                mBikeManager.compareBike(bikeDetails.get(1), bikeDetails.get(2));
                break;
            case 2:
                eBikeManager.compareBike(bikeDetails.get(1), bikeDetails.get(2));
                break;
            default:
                return false;
        }
        return true;
    }

    protected void showPersonalDetails(SalesExecutive salesExecutive) {
        List<SalesExecutive> userList = new ArrayList<>();
        userList.add(salesExecutive);
        UtilSalesExecutiveView.showSalesExecutiveDetails(userList);
    }

    public boolean buyBike(int customerId, int bikeId, EnumBikeTypes bikeType) {
        SalesRecord salesRecord = new SalesRecord(bikeId, customerId);
        if (bikeType.equals(EnumBikeTypes.MECHANICAL_BIKE)) {
            return mBikeManager.addOrderDetails(salesRecord);
        }
        return eBikeManager.addOrderDetails(salesRecord);
    }

    public void addCustomer(SignUpDetails details) {
        Customer customer = new Customer(details.getFirstName(), details.getLastName(), details.getUserName(), details.getPassword(), details.getEmailId(), details.getPhoneNo());
        dataManager.addUser(customer);
    }
}
