import com.bridgelabz.model.*;
import com.bridgelabz.service.*;
import java.util.Scanner;

public class UserApplication {
    private static final UserService userService = new UserServiceImpl();
    private static final Scanner sc = new Scanner(System.in);
    private static final CaptureUserData captureUserData = new CaptureUserData();

    public static void main(String[] args) {
        int choice;
        System.out.println("Press 1 for registration, 2 for login");
        do {
            choice = sc.nextInt();
            if (choice == 1) {
                addNewUser();
                break;
            }
            if (choice == 2) {
                loginUser();
                break;
            }
        } while (true);
    }

    private static void addNewUser() {
        BasicDetails basicDetails;
        ContactDetails contactDetails;
        LoginCredentials loginCredentials;
        String address;
        boolean valid;
        sc.nextLine();
        do {
            basicDetails = captureUserData.getBasicDetails();
            valid = UserValidation.validateBasicDetails(basicDetails);
        } while (!valid);

        do {
            contactDetails = captureUserData.getContactDetails();
            valid= UserValidation.validateContactDetails(contactDetails);
        } while (!valid);

        do {
            loginCredentials = captureUserData.getLoginCredentials();
            valid = UserValidation.validateLoginCredentials(loginCredentials);
        } while (!valid);

        address = captureUserData.getAddress();

        User user = new User(basicDetails, contactDetails, loginCredentials);
        user.setAddress(address);
        userService.registerUser(user);
    }

    private static void loginUser() {
        LoginCredentials loginCredentials;
        boolean loginSuccess;
        sc.nextLine();
        do {
            loginCredentials = captureUserData.getLoginCredentials();
            loginSuccess = userService.loginUser(loginCredentials);
        } while (!loginSuccess) ;
    }
}
