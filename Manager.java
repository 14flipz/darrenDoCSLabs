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

class Employee extends Person {
    double salary;

    Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    void displaySalary() {
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int age, double salary, int teamSize) {
        super(name, age, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displaySalary() {
        super.displaySalary();
        System.out.println("I manage a team of " + teamSize + " people.");
    }
}

public class Exercise {
    public static void main(String[] args) {
        Employee emp = new Employee("Charlie", 25, 45000.0);
        Manager mgr = new Manager("Diana", 40, 90000.0, 8);

        emp.displaySalary();
        System.out.println();
        mgr.displaySalary();
    }
}