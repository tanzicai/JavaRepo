package JavaSE;

public class KeyWordsPoint {

    /**
     * 静态变量
     * 静态变量: 又称为类变量，也就是说这个变量属于类的，类所有的实例都共享静态变量，可以直接通过类名来访问它；静态变量在内存中只存在一份。
     * 实例变量: 每创建一个实例就会产生一个实例变量，它与该实例同生共死。
     */
    private int x;         // 实例变量
    private static int y;  // 静态变量


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        /**
         * final1. 数据声明数据为常量，可以是编译时常量，也可以是在运行时被初始化后不能被改变的常量。
         * 对于基本类型，final 使数值不变；
         * 对于引用类型，final 使引用不变，也就不能引用其它对象，但是被引用的对象本身是可以修改的。
         *
         */

        final int x = 10;
//        x=11;不能改变
        final KeyWordsPoint keyWordsPoint = new KeyWordsPoint();
//        keyWordsPoint = new KeyWordsPoint();不能指向其他对象
        keyWordsPoint.setName("abc");//可以改变对象的信息


        KeyWordsPoint a1 = new KeyWordsPoint();//123
        KeyWordsPoint a2 = new KeyWordsPoint();//123

        //直接使用
        StaticInnerClass staticInnerClass = new StaticInnerClass();

    }

    /**
     * 方法声明方法不能被子类重写。
     * private 方法隐式地被指定为 final，
     * 如果在子类中定义的方法和基类中的一个 private 方法签名相同，此时子类的方法不是重写基类方法，而是在子类中定义了一个新的方法。
     *
     */
    private void testFinal(){
        System.out.println("我是父类private");
    }
    public final void TestfinalMethod(){
        System.out.println("我是父类final");
    }

    /**
     * 2. 静态方法
     *
     * 静态方法在类加载的时候就存在了，它不依赖于任何实例。所以静态方法必须有实现，也就是说它不能是抽象方法(abstract)。
     *
     * 只能访问所属类的静态字段和静态方法，方法中不能有 this 和 super 关键字。
     */
    public static void func1(){
    }


    /**
     * 3. 静态语句块
     *
     * 静态语句块在类初始化时运行一次。
     */
    static {
        System.out.println("123");
    }

    /**
     * 4. 静态内部类
     *
     * 非静态内部类依赖于外部类的实例，而静态内部类不需要。静态内部类不能访问外部类的非静态的变量和方法。
     */
    static class StaticInnerClass {
    }


    /**
     * 5. 静态导包
     *
     * 在使用静态变量和方法时不用再指明 ClassName，从而简化代码，但可读性大大降低。
     */
//    import static com.xxx.ClassName.*

    /**
     * 6. 初始化顺序
     *
     * 静态变量和静态语句块优先于实例变量和普通语句块，静态变量和静态语句块的初始化顺序取决于它们在代码中的顺序。
     *
     * 存在继承的情况下，初始化顺序为:
     *
     * 父类(静态变量、静态语句块)
     * 子类(静态变量、静态语句块)
     * 父类(实例变量、普通语句块)
     * 父类(构造函数)
     * 子类(实例变量、普通语句块)
     * 子类(构造函数)
     */
}
class TestFinalClass extends KeyWordsPoint{

//    @Override不是重写，而是子类自己的函数
    private void testFinal(){
        System.out.println("我是父类final");
    }
    /**
     * 不能存在和父类final同名函数
     */

//    public void TestfinalMethod(){
//        System.out.println("我是父类final");
//    }

}
