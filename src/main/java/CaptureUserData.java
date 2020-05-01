import com.bridgelabz.model.*;

import java.util.Scanner;

public class CaptureUserData {
    private final Scanner sc = new Scanner(System.in);

    public BasicDetails getBasicDetails() {
        System.out.println("Enter first name");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        return new BasicDetails(firstName, lastName);
    }

    public ContactDetails getContactDetails() {
        System.out.println("Enter mobile number");
        String mobileNumber = sc.nextLine();
        System.out.println("Enter email id");
        String email = sc.nextLine();
        return new ContactDetails(mobileNumber, email);
    }

    public LoginCredentials getLoginCredentials() {
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        return new LoginCredentials(username, password);
    }

    public String getAddress() {
        System.out.println("Enter address");
        return sc.nextLine();
    }
}
