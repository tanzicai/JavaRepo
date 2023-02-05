package genericity;

public class genericityInterface {
    public static void main(String[] args) {
        Info<String> i = null;        // 声明接口对象
        i = new InfoImpl<String>("汤姆") ;  // 通过子类实例化对象
        System.out.println("内容：" + i.getVar()) ;

        TestGenericityNormalClass testGenericityNormalClass = new TestGenericityNormalClass();
        try{
            String t = testGenericityNormalClass.getT(String.class);
        }catch (InstantiationException a){
            a.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }finally {
            System.out.println("exit");
        }
    }
}


interface Info<T>{        // 在接口上定义泛型
    public T getVar() ; // 定义抽象方法，抽象方法的返回值就是泛型类型
}

class InfoImpl<T> implements Info<T>{   // 定义泛型接口的子类
    private T var ;             // 定义属性
    public InfoImpl(T var){     // 通过构造方法设置属性内容
        this.setVar(var) ;
    }
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
}

class TestGenericityNormalClass{
    /**
     *
     * @param t
     * @return
     * @param <T>
     * @throws InstantiationException
     * @throws IllegalAccessException
     *
     * 说明一下，定义泛型方法时，必须在返回值前边加一个<T>，来声明这是一个泛型方法，持有一个泛型T，然后才可以用泛型T作为方法的返回值。
     * Class<T>的作用就是指明泛型的具体类型，而Class<T>类型的变量c，可以用来创建泛型类的对象。
     * 为什么要用变量c来创建对象呢？既然是泛型方法，就代表着我们不知道具体的类型是什么，也不知道构造方法如何，因此没有办法去new一个对象，但可以利用变量c的newInstance方法去创建对象，也就是利用反射创建对象。
     *
     */
    public <T> T getT(Class<T> t) throws InstantiationException, IllegalAccessException {
        T t1 = t.newInstance();
        return t1;
    }
}


/**
 * 在使用泛型的时候，我们可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类。
 *
 * <?> 无限制通配符
 * <? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类
 * <? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类
 * // 使用原则《Effictive Java》
 * // 为了获得最大限度的灵活性，要在表示 生产者或者消费者 的输入参数上使用通配符，使用的规则就是：生产者有上限、消费者有下限
 * 1. 如果参数化类型表示一个 T 的生产者，使用 < ? extends T>;
 * 2. 如果它表示一个 T 的消费者，就使用 < ? super T>；
 * 3. 如果既是生产又是消费，那使用通配符就没什么意义了，因为你需要的是精确的参数类型。
 * @param <T>
 */
class Info2<T extends Number>{    // 此处泛型只能是数字类型
    private T var ;        // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }
}
class demo1{
    public static void main(String args[]){
        Info2<Integer> i1 = new Info2<Integer>() ; // 声明Integer的泛型对象
    }

    public static void fun(Info<? super String> temp){    // 只能接收String或Object类型的泛型，String类的父类只有Object类
        System.out.print(temp + ", ") ;
    }

}
/**
 * 多个限制使用&符号
 */
class Staff{
    private int stand;

    public int getStand() {
        return stand;
    }

    public void setStand(int stand) {
        this.stand = stand;
    }
    public boolean isStanding(){
        if (stand==0)return false;
        else return true;
    }
}
class Passenger extends Staff{
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
//public class Client {
//    //工资低于2500元的上斑族并且站立的乘客车票打8折
//    public static <T extends Staff & Passenger> void discount(T t){
//        if(t.getSalary()<2500 && t.isStanding()){
//            System.out.println("恭喜你！您的车票打八折！");
//        }
//    }
//    public static void main(String[] args) {
//        discount(new Me());
//    }
//}
