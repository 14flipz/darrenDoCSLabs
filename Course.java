import java.util.ArrayList;

class Course {
    private String courseName;
    private int maxSeats;
    private ArrayList<String> registeredStudents;

    public Course(String courseName, int maxSeats) {
        this.courseName = courseName;
        this.maxSeats = maxSeats;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean registerStudent(String studentName) {
        if (registeredStudents.size() < maxSeats) {
            registeredStudents.add(studentName);
            System.out.println(studentName + " has been successfully registered for " + courseName);
            return true;
        } else {
            System.out.println("Error: " + courseName + " is currently full.");
            return false;
        }
    }

    public boolean dropStudent(String studentName) {
        if (registeredStudents.contains(studentName)) {
            registeredStudents.remove(studentName);
            System.out.println(studentName + " has been dropped from " + courseName);
            return true;
        } else {
            System.out.println("Error: Student " + studentName + " not found in " + courseName);
            return false;
        }
    }

    public void displayCourseDetails() {
        System.out.println("\n--- Course Details ---");
        System.out.println("Course: " + courseName);
        System.out.println("Capacity: " + registeredStudents.size() + "/" + maxSeats);
        System.out.println("Registered Students: " + (registeredStudents.isEmpty() ? "None" : registeredStudents));
    }
}