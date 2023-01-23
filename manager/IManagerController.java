package bbm.manager;

import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

public interface IManagerController {
    void addBike(MBike mBike);

    void addBike(EBike eBike);

    void viewAvailableBike();

    void showPersonalDetails();

    boolean removeMBike(int bikeId);

    boolean removeEBike(int bikeId);
}
