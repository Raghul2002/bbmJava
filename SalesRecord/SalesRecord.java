package bbm.SalesRecord;

public class SalesRecord {
    private final int bikeId, customerId;
    private int salesExecutiveId;
    public SalesRecord(int bikeId, int customerId) {
        this.bikeId = bikeId;
        this.customerId = customerId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getSalesExecutiveId() {
        return salesExecutiveId;
    }
    public void setSalesExecutiveId(int salesExecutiveId){
        this.salesExecutiveId = salesExecutiveId;
    }
}