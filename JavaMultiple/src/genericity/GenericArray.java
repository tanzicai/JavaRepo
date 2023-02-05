package genericity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericArray {

    public static void main(String[] args) {
        /**
         * 首先，我们泛型数组相关的申明：
         */
        //new ArrayList<String>[10];非法
        //new ArrayList<?>[10]非法
        /**
         * Unchecked cast: 'java.util.ArrayList<?>[]' to 'java.util.List<java.lang.String>[]'
         */
        List<String>[] list13 = (List<String>[]) new ArrayList<?>[10];
        /**
         * 正常创建
         * */
         ArrayList<?>[] arrayLists = new ArrayList<?>[10];

         /** Unchecked assignment: 'java.util.ArrayList[]' to 'java.util.List<java.lang.String>[]'
         */

        List<String>[] list6 = new ArrayList[10];


    }
}

class GenericsDemo30{
    public static void main(String args[]){
        Integer i[] = fun1(1,2,3,4,5,6) ;   // 返回泛型数组
        fun2(i) ;
        Integer h2[] = fun1() ;   // 返回泛型数组
        fun2(h2) ;
    }
    public static <T> T[] fun1(T...arg){  // 接收可变参数
        return arg ;            // 返回泛型数组
    }
    public static <T> void fun2(T param[]){   // 输出
        System.out.print("接收泛型数组：") ;
        for(T t:param){
            System.out.print(t + "、") ;
        }
    }
    //

}
//class  ArrayWithTypeToken<T>{
//    public ArrayWithTypeToken(Class<T> type, int size) {
//        array = (T[]) Array.newInstance(type, size);
//    }
//}

/**
 * 泛型的类型擦除原则是：
 * 消除类型参数声明，即删除<>及其包围的部分。
 * 根据类型参数的上下界推断并替换所有的类型参数为原生态类型：
 * 如果类型参数是无限制通配符或没有上下界限定则替换为Object，如果存在上下界限定则根据子类替换原则取类型参数的最左边限定类型（即父类）。
 * 为了保证类型安全，必要时插入强制类型转换代码。自动产生“桥接方法”以保证擦除类型后的代码仍然具有泛型的“多态性”。
 */

class Pair<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class DateInter extends Pair<Date> {

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    @Override
    public Date getValue() {
        return super.getValue();
    }

    public static void main(String[] args) {
        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date());
//        dateInter.setValue(new Object()); //编译错误

    }
}