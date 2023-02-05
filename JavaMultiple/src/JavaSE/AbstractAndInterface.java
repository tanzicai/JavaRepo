package JavaSE;


/**
 * 从设计层面上看，抽象类提供了一种 IS-A 关系，那么就必须满足里式替换原则，即子类对象必须能够替换掉所有父类对象。
 * 而接口更像是一种 LIKE-A 关系，它只是提供一种方法实现契约，并不要求接口和实现接口的类具有 IS-A 关系。从使用上来看，一个类可以实现多个接口，但是不能继承多个抽象类。
 * 接口的字段只能是 static 和 final 类型的，而抽象类的字段没有这种限制。接口的成员只能是 public 的，而抽象类的成员可以有多种访问权限。
 */
public class AbstractAndInterface {
    public static void main(String[] args) {
        AbstractPoint();
//        InterfacePoint();
    }

    public static void AbstractPoint(){
        AbstractClassExample ac2 = new AbstractExtendClassExample();
        System.out.println("--------------");
        ac2.func1();
        ac2.func2();
        AbstractExtendClassExample ac3 = (AbstractExtendClassExample)ac2;
        System.out.println("--------------");
        ac3.func1();
        ac3.func2();


    }

    public static void InterfacePoint(){
        // InterfaceExample ie1 = new InterfaceExample(); // 'InterfaceExample' is abstract; cannot be instantiated
        InterfaceExample ie2 = new InterfaceImplementExample();
        ie2.func1();
        System.out.println(InterfaceExample.x);

    }

    /**
     * super访问父类的构造函数: 可以使用 super() 函数访问父类的构造函数，从而委托父类完成一些初始化的工作。
     * 访问父类的成员: 如果子类重写了父类的中某个方法的实现，可以通过使用 super 关键字来引用父类的方法实现。
     * */
    public  static void SuperPoint(){
        AbstractClassExample ac2 = new AbstractExtendClassExample();
        System.out.println("--------------");
        ac2.func1();
        ac2.func2();
        AbstractExtendClassExample ac3 = (AbstractExtendClassExample)ac2;
        System.out.println("--------------");
        ac3.func1();
        ac3.func2();
    }


}

/**
 * 抽象类和抽象方法都使用 abstract 关键字进行声明。抽象类一般会包含抽象方法，抽象方法一定位于抽象类中。
 *
 * 抽象类和普通类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类。
 */

abstract class AbstractClassExample {

    protected int x;
    private int y;

    public abstract void func1();

    public void func2() {
        System.out.println("抽象类func2");
    }
}
class AbstractExtendClassExample extends AbstractClassExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }
    @Override
    public void func2() {
        super.func2();
        System.out.println("实现类func2");
    }
}


/**
 * 接口是抽象类的延伸，在 Java 8 之前，它可以看成是一个完全抽象的类，也就是说它不能有任何的方法实现。
 *
 * 从 Java 8 开始，接口也可以拥有默认的方法实现，这是因为不支持默认方法的接口的维护成本太高了。
 * 在 Java 8 之前，如果一个接口想要添加新的方法，那么要修改所有实现了该接口的类。
 * 接口的成员(字段 + 方法)默认都是 public 的，
 * 并且不允许定义为 private 或者 protected。接口的字段默认都是 static 和 final 的。
 */

interface InterfaceExample {
    void func1();

    default void func2(){
        System.out.println("func2");
    }

    int x = 123;
    // int y;               // Variable 'y' might not have been initialized
    public int z = 0;       // Modifier 'public' is redundant for interface fields
    // private int k = 0;   // Modifier 'private' not allowed here
    // protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here
}
class InterfaceImplementExample implements InterfaceExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }
}
