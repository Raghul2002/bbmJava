package bbm.bikeManager;

import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.EBike;
import bbm.dataManager.IDataManager;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;

public final class EBikeManager implements BikeManager<EBike> {
    IDataManager dataManager;
    public EBikeManager(IDataManager dataManager){
        this.dataManager = dataManager;
    }
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

    public List<EBike> getBike(BikeStatus bikeStatus) {
        List<EBike> eBikeList = dataManager.getEBikeList();
        List<EBike> eBikes = new ArrayList<>();
        for (EBike bike : eBikeList) {
            if (bike.getBikeStatus().equals(bikeStatus))
                eBikes.add(bike);
        }
        return eBikes;
    }

    @Override
    public void compareBike(int bikeId1, int bikeId2) {
        List<EBike> EBikeList = dataManager.getEBikeList();
        List<EBike> eBikes = new ArrayList<>();
        for (EBike i : EBikeList) {
            if (i.getBikeStatus().equals(BikeStatus.AVAILABLE) && (i.getBikeId() == bikeId1 || i.getBikeId() == bikeId2))
                eBikes.add(i);
        }
        UtilBikeView.printEBikeList(eBikes);
    }

    @Override
    public boolean addBookingOrder(SalesRecord salesRecord) {
        for (Bike bike : dataManager.getEBikeList())
            if (salesRecord.getBikeId() == bike.getBikeId()) {
                dataManager.addOrderDetails(salesRecord);
                bike.setBikeStatus(BikeStatus.RESERVED);
                return true;
            }
        return false;
    }

}
