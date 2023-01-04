package bbm.utility;

import java.util.regex.*;

public class Validation {
    private Validation (){}
    private static boolean validate(String regex,String string){
        Pattern p = Pattern.compile(regex);
        if (string == null) {
            return false;
        }
        Matcher m = p.matcher(string);
        return m.matches();
    }
    public static boolean validateString(String string){
        String regex = "[a-zA-Z\\s]{3,40}$";
        return validate(regex,string);
    }

    public static boolean validatePhoneNo(String number){
        String regex = "[0-9]{10}$";
        return validate(regex,number);
    }

    public static boolean validateEmail(String email){
        String regex = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$";
        return validate(regex,email);
    }
    public static boolean validateNumber(String num,int length){
        String regex = "[0-9]{1,2}$";
        if(validate(regex,num)) {
            return Integer.parseInt(num) <= length;
        }
        return false;
    }
}
