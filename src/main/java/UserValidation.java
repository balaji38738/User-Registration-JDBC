import com.bridgelabz.BasicDetails;
import com.bridgelabz.ContactDetails;
import com.bridgelabz.LoginCredentials;
import com.bridgelabz.service.UserService;
import com.bridgelabz.service.UserServiceImpl;

public class UserValidation {
    private static final String NAME_PATTERN = "^[a-zA-Z]{2,}$";
    private static final String EMAIL_PATTERN = "^[0-9a-zA-Z]+([_+-.][0-9a-zA-Z]+)*" +
            "@[0-9a-zA-Z]+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2})?$";
    private static final String MOBILE_PATTERN = "^(0|91)?[7-9][0-9]{9}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z]\\w{8,30}$";

    public static boolean validateBasicDetails(BasicDetails basicDetails) {
        if (!basicDetails.getFirstName().matches(NAME_PATTERN)) {
            System.out.println("Invalid first name");
            return false;
        }
        if (!basicDetails.getLastName().matches(NAME_PATTERN)) {
            System.out.println("Invalid Last name");
            return false;
        }
        return true;
    }

    public static boolean validateContactDetails(ContactDetails contactDetails) {
        if (!contactDetails.getMobileNumber().matches(MOBILE_PATTERN)) {
            System.out.println("Invalid mobile number");
            return false;
        }
        if (!contactDetails.getEmail().matches(EMAIL_PATTERN)) {
            System.out.println("Invalid email id");
            return false;
        }
        return true;
    }

    public static boolean validateLoginCredentials(LoginCredentials loginCredentials) {
        UserService userService = new UserServiceImpl();

        if (!loginCredentials.getUsername().matches(USERNAME_PATTERN)) {
            System.out.println("Invalid username");
            return false;
        }
        if (userService.checkUsernameExistence(loginCredentials.getUsername())) {
            System.out.println("Username already present");
            return false;
        }
        if (!loginCredentials.getPassword().matches(PASSWORD_PATTERN)) {
            System.out.println("Password should have at least 1 uppercase letter, 1 digit ," +
                    " 1 special character ,& minimum 8 characters");
            return false;
        }
        return true;
    }
}
