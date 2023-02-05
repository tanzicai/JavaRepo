package JavaSE;

public class BasicPoint {

    //    缓存池
    public static void main(String[] args) {

        TestValueOfMethod();
    }

    public static void TestValueOfMethod(){
        /**
         * new Integer(123) 每次都会新建一个对象
         * Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用。
         * valueOf() 方法的实现比较简单，就是先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
         * 在 Java 8 中，Integer 缓存池的大小默认为 -128~127。
         *
         * 编译器会在缓冲池范围内的基本类型自动装箱过程调用 valueOf() 方法，因此多个 Integer 实例使用自动装箱来创建并且值相同，那么就会引用相同的对象。
         * */
        Integer integer = new Integer(123);
        Integer integer1 = new Integer(123);
        System.out.println("a: " + integer);
        System.out.println("b: " + integer1);
        System.out.println("a==b? :");
        System.out.println(integer == integer1);

        System.out.println("==================");
        Integer integer2 = Integer.valueOf(123);
        Integer integer3 = Integer.valueOf(123);
        System.out.println("a: " + integer2);
        System.out.println("b: " + integer3);
        System.out.println("a==b? :");
        System.out.println(integer2 == integer3);

        System.out.println("==================");
        Integer a = 123;
        Integer b = 123;
        System.out.println(a == b);

        /**
         * 基本类型对应的缓冲池如下:
         * boolean values true and false
         * all byte values
         * short values between -128 and 127
         * int values between -128 and 127
         * char in the range \u0000 to \u007F(127)
         * 如果在缓冲池外的话就不会产生这种现象
         * Integer m = 323;
         * Integer n = 323;
         * System.out.println(m == n); // false
         * */
    }
}
