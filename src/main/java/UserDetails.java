import com.bridgelabz.BasicDetails;
import com.bridgelabz.ContactDetails;
import com.bridgelabz.LoginCredentials;
import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;
import com.bridgelabz.service.UserServiceImpl;
import java.util.Scanner;

public class UserDetails {
    private static final UserService userService = new UserServiceImpl();
    static Scanner sc = new Scanner(System.in);

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
            basicDetails = getBasicDetails();
            valid = UserValidation.validateBasicDetails(basicDetails);
        } while (!valid);

        do {
            contactDetails = getContactDetails();
            valid= UserValidation.validateContactDetails(contactDetails);
        } while (!valid);

        do {
            loginCredentials = getLoginCredentials();
            valid = UserValidation.validateLoginCredentials(loginCredentials);
        } while (!valid);

        address = getAddress();

        User user = new User(basicDetails, contactDetails, loginCredentials);
        user.setAddress(address);
        userService.registerUser(user);
    }

    private static void loginUser() {
        LoginCredentials loginCredentials;
        boolean loginSuccess;
        sc.nextLine();
        do {
            loginCredentials = getLoginCredentials();
            loginSuccess = userService.loginUser(loginCredentials);
        } while (!loginSuccess) ;
    }

    public static BasicDetails getBasicDetails() {
        System.out.println("Enter first name");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        return new BasicDetails(firstName, lastName);
    }

    public static ContactDetails getContactDetails() {
        System.out.println("Enter mobile number");
        String mobileNumber = sc.nextLine();
        System.out.println("Enter email id");
        String email = sc.nextLine();
        return new ContactDetails(mobileNumber, email);
    }

    public static LoginCredentials getLoginCredentials() {
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        return new LoginCredentials(username, password);
    }

    public static String getAddress() {
        System.out.println("Enter address");
        return sc.nextLine();
    }
}
