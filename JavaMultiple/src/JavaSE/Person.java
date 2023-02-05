package JavaSE;

public class Person {
    private String name;
    private int age;
    private int gender;

    public Person() {
        this.name = "test";
        this.gender = 0;
        this.age = 18;
    }

    public Person(String name, int age, int gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender == 0 ? "man" : "woman";
    }

    public void work() {
        if (18 <= age && age <= 50) {
            System.out.println(name + " is working very hard;");
        } else {
            System.out.println(name + " can't work any more;");
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.work();

    }
}
