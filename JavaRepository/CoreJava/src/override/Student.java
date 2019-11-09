package override;

public class Student {
    private String name;

    public String getName(String a, String b) {
        return a + b;
    }

    private int getName(String a, int b) {
        return b;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
    }
}

class Animal {
    private String getName() {
        return "a";
    }
}

class Dog extends Animal {
    public int getNum() {
        return 1;
    }
}
