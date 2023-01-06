package bbm.utility;

import bbm.encryption.IEncryption;
import bbm.encryption.Encryption;
import bbm.model.account.SignUpDetails;

import java.util.*;

public final class UtilUserInput {
    static Scanner sc = new Scanner(System.in);
    private UtilUserInput() {
    }

    public static String getUserName() {
        String userName;
        do {
            System.out.println("Enter User Name \t:");
            userName = sc.next();
        } while (!Validation.validateString(userName));
        return userName;
    }

    public static String getPassword() {
        String password;
        IEncryption encryption = new Encryption();
        System.out.println("Enter Password \t:");
        password = sc.next();
        password = encryption.encryptPassword(password);
        return password;
    }

    private static String getFirstName() {
        String firstName;
        do {
            System.out.println("Enter First Name \t:");
            firstName = sc.next();
        } while (!Validation.validateString(firstName));

        return firstName;
    }

    private static String getLastName() {
        String lastName;
        do {
            System.out.println("Enter Last Name \t:");
            lastName = sc.next();
        } while (!Validation.validateString(lastName));

        return lastName;
    }

    private static String getEmailId() {
        String emailId;
        do {
            System.out.println("Enter Email \t:");
            emailId = sc.next();
        } while (!Validation.validateEmail(emailId));
        return emailId;

    }

    private static String getPhoneNo() {
        String phoneNo;
        do {
            System.out.println("Enter Phone number \t:");
            phoneNo = sc.next();
        } while (!Validation.validatePhoneNo(phoneNo));

        return phoneNo;
    }


    public static SignUpDetails getSignUpDetails() {
        System.out.println("Enter sign up details :");
        return new SignUpDetails(getFirstName(), getLastName(), getUserName(), getPassword(), getEmailId(), getPhoneNo());
    }
}