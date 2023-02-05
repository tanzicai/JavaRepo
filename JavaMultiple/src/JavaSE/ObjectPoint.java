package JavaSE;

import java.util.HashSet;

public class ObjectPoint {
    public ObjectPoint() {
        super();
    }

    /**
     * hashCode()
     * 返回散列值，而 equals() 是用来判断两个对象是否等价。等价的两个对象散列值一定相同，但是散列值相同的两个对象不一定等价。
     * 覆盖 equals() 方法时应当总是覆盖 hashCode() 方法，保证等价的两个对象散列值也相等。
     * 下面的代码中，新建了两个等价的对象，并将它们添加到 HashSet 中。
     *
     * 我们希望将这两个对象当成一样的，只在集合中添加一个对象，但是因为 EqualExample 没有实现 hasCode() 方法，
     * 因此这两个对象的散列值是不同的，最终导致集合添加了两个等价的对象。
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * 等价关系
     *
     * equals() 与 ==
     * 对于基本类型，== 判断两个值是否相等，基本类型没有 equals() 方法。
     * 对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
     *
     * 检查顺序
     * 检查是否为同一个对象的引用，如果是直接返回 true；
     * 检查是否是同一个类型，如果不是，直接返回 false；
     * 将 Object 对象进行转型；
     * 判断每个关键域是否相等。
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * cloneable
     *
     * clone() 是 Object 的 protected 方法，它不是 public，一个类不显式去重写 clone()，其它类就不能直接去调用该类实例的 clone() 方法。
     *
     * 应该注意的是，clone() 方法并不是 Cloneable 接口的方法，而是 Object 的一个 protected 方法。Cloneable 接口只是规定，如果一个类没有实现 Cloneable 接口又调用了 clone() 方法，就会抛出 CloneNotSupportedException。
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * toString()
     * 默认返回 ToStringExample@4554617c 这种形式，其中 @ 后面的数值为散列码的无符号十六进制表示。
     * @return
     */
    @Override
    public String toString() {
        // return getClass().getName() + "@" + Integer.toHexString(hashCode());
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
//        EqualExample e1 = new EqualExample(1, 1, 1);
//        EqualExample e2 = new EqualExample(1, 1, 1);
//        System.out.println(e1.equals(e2)); // true
//        HashSet<EqualExample> set = new HashSet<>();
//        set.add(e1);
//        set.add(e2);
//        System.out.println(set.size());   // 2



        //
        /**
         *
         * 拷贝测试
         * 拷贝对象和原始对象的引用类型引用同一个对象。
         */
//        ShallowCloneExample e3 = new ShallowCloneExample();
//        ShallowCloneExample e4 = null;
//        try {
//            e4 = e3.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        e3.set(2, 222);
//        System.out.println(e4.get(2)); // 222

        /**
         * 构造方法实现的克隆
         */
        CloneConstructorExample e1 = new CloneConstructorExample();
        CloneConstructorExample e2 = new CloneConstructorExample(e1);
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 2


    }
}

class EqualExample {
    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 理想的散列函数应当具有均匀性，即不相等的对象应当均匀分布到所有可能的散列值上。
     * 这就要求了散列函数要把所有域的值都考虑进来，可以将每个域都当成 R 进制的某一位，然后组成一个 R 进制的整数。
     * R 一般取 31，因为它是一个奇素数，如果是偶数的话，当出现乘法溢出，信息就会丢失，因为与 2 相乘相当于向左移一位
     * 一个数与 31 相乘可以转换成移位和减法: 31*x == (x<<5)-x，编译器会自动进行这个优化。
     */
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + x;
//        result = 31 * result + y;
//        result = 31 * result + z;
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualExample that = (EqualExample) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }
}


class ShallowCloneExample implements Cloneable {
    private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }
}

/**
 *
 */

class DeepCloneExample implements Cloneable {
    private int[] arr;

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample result = (DeepCloneExample) super.clone();
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }
        return result;
    }
}


/**
 * 使用 clone() 方法来拷贝一个对象即复杂又有风险，它会抛出异常，并且还需要类型转换。
 * Effective Java 书上讲到，最好不要去使用 clone()，可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象。
 */
class CloneConstructorExample {
    private int[] arr;

    public CloneConstructorExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public CloneConstructorExample(CloneConstructorExample original) {
        arr = new int[original.arr.length];
        for (int i = 0; i < original.arr.length; i++) {
            arr[i] = original.arr[i];
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }
}
