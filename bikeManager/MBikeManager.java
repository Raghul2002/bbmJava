package bbm.bikeManager;

import bbm.dataManager.IDataManager;
import bbm.SalesRecord.SalesRecord;
import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.MBike;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;

public final class MBikeManager implements BikeManager<MBike> {
    IDataManager dataManager;
    public MBikeManager(IDataManager dataManager){
        this.dataManager = dataManager;
    }
    @Override
    public void addBike(MBike bike, Manager manager) {
        dataManager.addBike(bike, manager);
    }

    @Override
    public boolean removeBike(int bikeId, Manager manager) {
        for (MBike i : dataManager.getMBikeList()) {
            if (i.getBikeId() == bikeId) {
                dataManager.removeBike(i, manager);
                return true;
            }
        }
        return false;
    }

    public List<MBike> getBike(BikeStatus bikeStatus) {
        List<MBike> mBikeList = dataManager.getMBikeList();
        List<MBike> mBikes = new ArrayList<>();
        for (MBike bike : mBikeList) {
            if (bike.getBikeStatus().equals(bikeStatus))
                mBikes.add(bike);
        }
        return mBikes;
    }

    @Override
    public void compareBike(int bikeId1, int bikeId2) {
        List<MBike> mBikeList = dataManager.getMBikeList();
        List<MBike> mBikes = new ArrayList<>();
        for (MBike i : mBikeList) {
            if (i.getBikeStatus().equals(BikeStatus.AVAILABLE) && (i.getBikeId() == bikeId1 || i.getBikeId() == bikeId2))
                mBikes.add(i);
        }
        UtilBikeView.printMBikeList(mBikes);
    }

    public boolean addBookingOrder(SalesRecord salesRecord) {
        for (Bike bike : dataManager.getMBikeList())
            if (salesRecord.getBikeId() == bike.getBikeId()) {
                dataManager.addSalesDetails(salesRecord);
                bike.setBikeStatus(BikeStatus.RESERVED);
                return true;
            }
        return false;
    }
}
