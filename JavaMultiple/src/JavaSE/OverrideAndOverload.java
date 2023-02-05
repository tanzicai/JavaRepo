package JavaSE;

import sun.security.x509.FreshestCRLExtension;

public class OverrideAndOverload {
    public static void main(String[] args) {

    }



}

class superTest{
   public superTest superMethod(){
       System.out.println("测试");
       return new superTest();
   }
}
class extendsTest extends superTest{
    /**
     * 1. 重写(Override)存在于继承体系中，指子类实现了一个与父类在方法声明上完全相同的一个方法。为了满足里式替换原则，
     * 重写有以下两个限制:子类方法的访问权限必须大于等于父类方法；
     * 子类方法的返回类型必须是父类方法返回类型或为其子类型。
     * 使用 @Override 注解，可以让编译器帮忙检查是否满足上面的两个限制条件。
     */
    @Override
    public extendsTest superMethod() {
        super.superMethod();
        return new extendsTest();
    }

    /**
     * 重载(Overload)存在于同一个类中，指一个方法与已经存在的方法名称上相同，
     * 但是参数类型、个数、顺序至少有一个不同。应该注意的是，返回值不同，其它都相同不算是重载。
     * */
    public extendsTest superMethod(String args){
        System.out.println("重载");
        return new extendsTest();
    }
}
