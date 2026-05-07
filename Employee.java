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

public class Exercise {
    public static void main(String[] args) {
        Employee e = new Employee("Bob", 30, 50000.0);
        e.introduce();
        e.displaySalary();
    }
}