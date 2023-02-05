package JavaSE;

public class CalculatePoint {


    public static void main(String[] args) {
//        argsTransport();
        FloatAndDouble();
    }


    /**
     * Java 的参数是以值传递的形式传入方法中，而不是引用传递。
     * 以下代码中 Dog dog 的 dog 是一个指针，存储的是对象的地址。在将一个参数传入一个方法时，本质上是将对象的地址以值的方式传递到形参中。
     * 因此在方法中改变指针引用的对象，那么这两个指针此时指向的是完全不同的对象，一方改变其所指向对象的内容对另一方没有影响。
     *
     * 但是如果在方法中改变对象的字段值会改变原对象该字段值，因为改变的是同一个地址指向的内容。
     */
    public static void argsTransport(){
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        func(dog);
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        System.out.println(dog.getName());          // A
    }

    private static void func(Dog dog) {
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress()); // Dog@74a14482
        System.out.println(dog.getName());          // B
    }

    /**
     * 1.1 字面量属于 double 类型，不能直接将 1.1 直接赋值给 float 变量，因为这是向下转型。Java 不能隐式执行向下转型，因为这会使得精度降低。
     * 注意i = i + j不等同于i += j
     *
     * i += j;----> i = (type of i) (i + j)？
     */
    public static void FloatAndDouble(){
//      float a = 1.1;错误
        float v = 1.1f;
        double v1 = 1.1;
//      short a1 = 1;错误
        short a = Short.parseShort("1");
        int i = 1;
        a+= i;
        System.out.println(a);
    }

}

class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}

