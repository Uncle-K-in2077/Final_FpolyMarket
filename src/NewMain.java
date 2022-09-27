
import java.util.regex.*;

class GFG {

    // Function to validate the password.
    public static boolean
            isValidPassword(String password) {

        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }

    // Driver Code.
    public static void main(String args[]) {
        System.out.println(HELPER.helper.isFullname("Nguyễn Viết Hồng Anh"));
        System.out.println(HELPER.helper.isFullname("Nguyễn 2 viết Hồng Anh"));
        System.out.println(HELPER.helper.isFullname("Nguyễn Viết Hồng Anh "));
        System.out.println(HELPER.helper.isEmail("heiasfuo"));
        System.out.println(HELPER.helper.isEmail("hichau25@gmail.com"));
    }
}
