class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}

class Student extends Person {
    String school;

    Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    void introduce() {
        super.introduce();
        System.out.println("I attend " + school + ".");
    }
}

public class Exercise {
    public static void main(String[] args) {
        Student s = new Student("Alice", 19, "State University");
        s.introduce();
    }
}