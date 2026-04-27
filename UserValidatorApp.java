import java.util.Scanner;
import java.util.ArrayList;

public class UserValidatorApp {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> validUsers = new ArrayList<>();
		boolean continueEntry = true;
		
		System.out.println("---User Input Validation System---");
		
		while(continueEntry) {
			String name = "";
			int age = 0;
			String email = "";
			String phone = "";
			
			while (true) {
				try {
					System.out.println("Enter name");
					name = UserInputValidator.validateName(scan.nextLine());
					break;
				} catch(InvalidInputException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			
			while (true) {
				try {
					System.out.println("Enter age");
					age = UserInputValidator.validateAge(scan.nextLine());
					break;
				} catch(InvalidInputException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			
			while (true) {
				try {
					System.out.println("Enter email");
					email = UserInputValidator.validateEmail(scan.nextLine());
					break;
				} catch(InvalidInputException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			
			while (true) {
				try {
					System.out.println("Enter phone");
					phone = UserInputValidator.validatePhone(scan.nextLine());
					break;
				} catch(InvalidInputException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			
			String userData = String.format("Name: %s | Age %d | Email %s | Phone %s", name, age, email, phone);
			validUsers.add(userData);
			System.out.println("Success");
			
			System.out.println("Would you like to add another yes/no");
			String choice = scan.nextLine().toLowerCase();
			if(!choice.equals("yes")) {
				continueEntry = false;
			}
		}
		
		System.out.println("Report");
		for (String user : validUsers) {
			System.out.println(user);
		}
		
		scan.close();
		}
}
