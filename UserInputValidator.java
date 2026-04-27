
public class UserInputValidator 
{
	public static String validateName(String name) throws InvalidInputException{
		if(name == null || name.trim().isEmpty()) {
			throw new InvalidInputException("Name cannot be blank");
		}
		
		return name.trim();
	}
	
	public static int validateAge(String ageStr) throws InvalidInputException{
			try {
			int age = Integer.parseInt(ageStr);
			if (age < 0) {
				throw new InvalidInputException("Age must be positive");
			}
			return age;
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Age must be numeric int");
		}
	}
	
	public static String validateEmail(String email) throws InvalidInputException{
		if (!email.contains("@") || !(email.endsWith(".com") || email.endsWith(".edu"))) {
			throw new InvalidInputException("Email must contain an @ and end with .com or .edu");
		}
		return email;
	}
	
	public static String validatePhone(String phone) throws InvalidInputException{
		String cleanPhone = phone.replaceAll("\\s", "");
		if(cleanPhone.length() != 10 || !cleanPhone.matches("\\d+")) {
			throw new InvalidInputException("must be exactly 10 digits");
		}
		return cleanPhone;
	}
}