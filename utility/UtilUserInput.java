package bbm.utility;

import bbm.encryption.IEncryption;
import bbm.encryption.Encryption;
import bbm.enumPackage.EnumUserDetails;

import java.util.*;

public class UtilUserInput {
    static Scanner sc = new Scanner(System.in);
    private static String firstName, lastName, userName, password, emailId, phoneNo;

    private UtilUserInput() {
    }

    private static String getUserNameDetails() {
        do {
            System.out.println("Enter User Name \t:");
            userName = sc.next();
        } while (!Validation.validateString(userName));
        return userName;
    }

    private static String getPasswordDetails() {
        IEncryption encryption = new Encryption();
        System.out.println("Enter Password \t:");
        password = sc.next();
        password = encryption.encryptPassword(password);
        return password;
    }

    private static String getFirstNameDetails() {
        do {
            System.out.println("Enter First Name \t:");
            firstName = sc.next();
        } while (!Validation.validateString(firstName));

        return firstName;
    }

    private static String getLastNameDetails() {
        do {
            System.out.println("Enter Last Name \t:");
            lastName = sc.next();
        } while (!Validation.validateString(lastName));

        return lastName;
    }

    private static String getEmailIdDetails() {
        do {
            System.out.println("Enter Email \t:");
            emailId = sc.next();
        } while (!Validation.validateEmail(emailId));
        return emailId;

    }

    private static String getPhoneNoDetails() {
        do {
            System.out.println("Enter Phone number \t:");
            phoneNo = sc.next();
        } while (!Validation.validatePhoneNo(phoneNo));

        return phoneNo;
    }

    public static List<String> getSignInDetails() {
        getUserNameDetails();
        getPasswordDetails();
        List<String> details = new ArrayList<>();
        details.add(userName);
        details.add(password);
        return details;
    }

    public static HashMap<EnumUserDetails, String> getSignUpDetails() {
        System.out.println("Enter sign up details :");
        HashMap<EnumUserDetails, String> details = new HashMap<>();
        getFirstNameDetails();
        getLastNameDetails();
        getSignInDetails();
        getEmailIdDetails();
        getPhoneNoDetails();
        details.put(EnumUserDetails.FIRST_NAME, firstName);
        details.put(EnumUserDetails.LAST_NAME, lastName);
        details.put(EnumUserDetails.USER_NAME, userName);
        details.put(EnumUserDetails.PASSWORD, password);
        details.put(EnumUserDetails.EMAIL_ID, emailId);
        details.put(EnumUserDetails.PHONE_NO, phoneNo);
        return details;
    }
}