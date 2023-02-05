package JavaSE;

public class StringPoint {
    public static void main(String[] args) {
//        StringAndStringBuffer_StringBuilder();
        StringWithSwitch();
    }



    public static void StringAndStringBuffer_StringBuilder(){

        /**
         * 如果一个 String 对象已经被创建过了，那么就会从 String Pool 中取得引用。只有 String 是不可变的，才可能使用 String Pool。
         * 如果使用new关键词创建，则不会使用常量池的String
         */

        String a = "123";
        String b = "123";
        String c  = new String(a);
        System.out.println(a == b);
        System.out.println(a == c);


        /**
         * String 不可变，因此是线程安全的
         * StringBuilder 不是线程安全的
         * StringBuffer 是线程安全的，内部使用 synchronized 进行同步
         */


        /**
         * 使用 String.intern() 可以保证相同内容的字符串变量引用同一的内存对象。
         * 但是调用intern的String依旧不是常量池的，只是会返回常量池的引用
         * 如果是采用 "bbb" 这种使用双引号的形式创建字符串实例，会自动地将新建的对象放入 String Pool 中。
         */

        String aaa1 = "aaa";
        String aaa = new String("aaa");
        System.out.println(aaa == aaa1);
        String intern = aaa.intern();

        System.out.println(intern == aaa);
        String StringPoolIndex = aaa;

    }

    public static void StringWithSwitch(){
        /**
         * 从 Java 7 开始，可以在 switch 条件判断语句中使用 String 对象。
         *
         * switch 不支持 long，是因为 switch 的设计初衷是对那些只有少数的几个值进行等值判断，如果值过于复杂，那么还是用 if 比较合适。
         */

        String a = "a";
        switch (a) {
            case "a":
                System.out.println("aaa");
                break;
            case "b":
                System.out.println("bbb");
                break;
        }

    }
}
