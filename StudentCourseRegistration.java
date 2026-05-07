import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("CSC161: Java I", 3));
        courses.add(new Course("MAT131: Calculus", 25));
        courses.add(new Course("ENG121: Composition", 20));

        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Registration System ---");
            System.out.println("1. Register for a Course");
            System.out.println("2. Drop a Course");
            System.out.println("3. View Course Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    Course regCourse = selectCourse(courses, input);
                    if (regCourse != null) {
                        System.out.print("Enter student name: ");
                        String name = input.nextLine();
                        regCourse.registerStudent(name);
                    }
                    break;

                case 2:
                    Course dropCourse = selectCourse(courses, input);
                    if (dropCourse != null) {
                        System.out.print("Enter student name to drop: ");
                        String name = input.nextLine();
                        dropCourse.dropStudent(name);
                    }
                    break;

                case 3:
                    for (Course c : courses) {
                        c.displayCourseDetails();
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Good luck with your studies!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();
    }

    private static Course selectCourse(ArrayList<Course> courses, Scanner input) {
        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }
        System.out.print("Select a course number: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index >= 0 && index < courses.size()) {
            return courses.get(index);
        } else {
            System.out.println("Invalid course selection.");
            return null;
        }
    }
}