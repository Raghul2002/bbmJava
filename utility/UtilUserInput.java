package bbm.utility;

import bbm.encryption.IEncryption;
import bbm.encryption.Encryption;

import java.util.*;

public final class UtilUserInput {
    static Scanner sc = new Scanner(System.in);

    private UtilUserInput() {
    }

    public static String getUserName() {
        String userName;
        System.out.println("Enter User Name \t:");
        userName = sc.next();
        while (!Validation.validateString(userName)) {
            System.out.println("Enter valid input (Min 3 letters)\t:");
            userName = sc.next();
        }
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

    public static String getFirstName() {
        String firstName;
        System.out.println("Enter First Name \t:");
        firstName = sc.next();
        while (!Validation.validateString(firstName)) {
            System.out.println("Enter valid input (Min 3 letters)\t:");
            firstName = sc.next();
        }

        return firstName;
    }

    public static String getLastName() {
        String lastName;
        System.out.println("Enter Last Name \t:");
        lastName = sc.next();
        while (!Validation.validateString(lastName)) {
            System.out.println("Enter valid input (Min 3 letters)\t:");
            lastName = sc.next();
        }
        return lastName;
    }

    public static String getEmailId() {
        String emailId;
        System.out.println("Enter Email \t:");
        emailId = sc.next();
        while (!Validation.validateEmail(emailId)) {
            System.out.println("Enter valid email\t:");
            emailId = sc.next();
        }
        return emailId;

    }

    public static String getPhoneNo() {
        String phoneNo;
        System.out.println("Enter Phone number \t:");
        phoneNo = sc.next();
        while (!Validation.validatePhoneNo(phoneNo)) {
            System.out.println("Enter valid input (Enter 10 digit number!!)\t:");
            phoneNo = sc.next();
        }

        return phoneNo;
    }

    public static String getNumberForSwitch(int enumLength) {
        String val;
        System.out.println("Enter number :");
        val = sc.next();
        while (!Validation.validateNumber(val, enumLength)) {
            System.out.println("Enter valid number :");
            val = sc.next();
        }
        return val;
    }
}