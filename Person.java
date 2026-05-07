class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}

public class Exercise {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "John";
        p.age = 20;
        p.introduce();
    }
}