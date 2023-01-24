package bbm.main;

import bbm.factory.enumeration.accessEnum.BBMAccessImplTypes;
import bbm.factory.enumeration.DatabaseImplTypes;
import bbm.factory.InstanceFactory;
import bbm.application.BBMAccess;
import bbm.database.Database;
import bbm.factory.enumeration.controllerEnum.BBMControllerImplTypes;
import bbm.factory.enumeration.viewEnum.BBMViewImplTypes;
import bbm.model.account.*;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

public final class BikeBookingManagement {
    static {
        Database db = InstanceFactory.getDatabaseInstance(DatabaseImplTypes.ListDatabase);
        if(db != null) {
            db.addUser(new Manager("AAA", "M", "manager", "r", "manager@gmail.com", "3456234234L"));
            db.addUser(new Owner("BBB", "O", "owner", "t", "owner@gmail.com", "3423434562L"));
            db.addUser(new Customer("CCC", "C", "customer", "h", "customer@gmail.com", "3423456234L"));
            db.addUser(new SalesExecutive("DDD", "S", "sales", "x", "sales@gmail.com", "2343456234L"));
            db.addBike(new MBike(110, 165, 2, 13, 114000, "FZS-V3", "Sports Bikes", "Digital", "Single Seat", 50, 1, "4-stroke", "149 cc", "Air Cooled", "Fuel Injection", "5 Speed"));
            db.addBike(new MBike(95, 145, 1, 8, 71502, "DIO", "Scooter", "Analog", "Single", 48, 1, "4-stroke", "110 cc", "Air Cooled", "Fuel Injection", "-"));
            db.addBike(new EBike(42, 120, 1, 2, 1, "Optima CX", "Scooter", "Digital", "Single", 30, 37, 42, 1800, 7));
            db.addBike(new EBike(60, 125, 2, 2, 1, "Magnus EX", "Scooter", "Analog", "Split", 40, 50, 60, 2100, 10));
        }
    }
    public static void main(String[] args) {
        BBMAccess bbmAccess = InstanceFactory.getBBMAccessInstance(BBMAccessImplTypes.ApplicationManager);
        IBBMController bbmController = InstanceFactory.getBBMControllerInstance(BBMControllerImplTypes.BBMController,bbmAccess);
        IBBMView bbmView = InstanceFactory.getBBMViewInstance(BBMViewImplTypes.BBMView,bbmController);
        if (bbmView != null)
            bbmView.renderMainView();
    }
}