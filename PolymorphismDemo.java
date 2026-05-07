class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}

class Student extends Person {
    String school;

    Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    @Override
    void introduce() {
        System.out.println("I am a student at " + school + " named " + name + ".");
    }
}

class Employee extends Person {
    double salary;

    Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    void introduce() {
        System.out.println("I am an employee named " + name + " with a salary of $" + salary + ".");
    }
}

public class Exercise {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Generic Person", 50);
        people[1] = new Student("Steve", 20, "Tech Institute");
        people[2] = new Employee("Emma", 35, 75000.0);

        for (Person p : people) {
            p.introduce();
        }
    }
}