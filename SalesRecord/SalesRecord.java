package bbm.SalesRecord;

public final class SalesRecord {
    private final int bikeId;
    private String salesExecutiveId, customerId;

    public SalesRecord(int bikeId, String customerId) {
        this.bikeId = bikeId;
        this.customerId = customerId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getSalesExecutiveId() {
        return salesExecutiveId;
    }

    public void setSalesExecutiveId(String salesExecutiveId) {
        this.salesExecutiveId = salesExecutiveId;
    }
}