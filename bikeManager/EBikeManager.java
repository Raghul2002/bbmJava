package bbm.bikeManager;

import bbm.dataManager.DataManager;
import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.EBike;
import bbm.dataManager.IDataManager;
import bbm.model.bike.MBike;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;

public class EBikeManager implements BikeManager<EBike> {
    IDataManager dataManager = new DataManager();

    @Override
    public void addBike(EBike bike, Manager manager) {
        dataManager.addBike(bike, manager);
    }


    @Override
    public boolean removeBike(int bikeId, Manager manager) {
        for (EBike i : dataManager.getEBikeList()) {
            if (i.getBikeId() == bikeId) {
                dataManager.removeBike(i, manager);
                return true;
            }
        }
        return false;
    }

    public void viewBike(BikeStatus bikeStatus) {
        List<EBike> eBikeList = dataManager.getEBikeList();
        List<EBike> eBikes = new ArrayList<>();
        for (EBike bike : eBikeList) {
            if (bike.getAvailabilityStatus().equals(bikeStatus))
                eBikes.add(bike);
        }
        UtilBikeView.printEBikeList(eBikes);
    }

    @Override
    public void compareBike(int bikeId1, int bikeId2) {
        List<EBike> EBikeList = dataManager.getEBikeList();
        List<EBike> eBikes = new ArrayList<>();
        for (EBike i : EBikeList) {
            if (i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE) && (i.getBikeId() == bikeId1 || i.getBikeId() == bikeId2))
                eBikes.add(i);
        }
        UtilBikeView.printEBikeList(eBikes);
    }

    @Override
    public boolean addOrderDetails(SalesRecord salesRecord) {
        for (Bike bike : dataManager.getEBikeList())
            if (salesRecord.getBikeId() == bike.getBikeId()) {
                dataManager.addOrderDetails(salesRecord);
                setBikeStatus(bike, BikeStatus.RESERVED);
                return true;
            }
        return false;
    }

    public void setBikeStatus(Bike bike, BikeStatus bikeStatus) {
        bike.setAvailabilityStatus(bikeStatus);
    }
}
