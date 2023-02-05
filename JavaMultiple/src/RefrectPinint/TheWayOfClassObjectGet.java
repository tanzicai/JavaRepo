package RefrectPinint;

import jdk.jfr.internal.Logger;
import org.junit.Test;


public class TheWayOfClassObjectGet {

    @Test
    public void classTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        /**
         * 获取Class对象的三种方式\
         * 1. 根据对象
         * 2. 根据全限定类名
         * 3. 根据类名
         */
        User user = new User("张三",1);
        Class<? extends User> aClass = user.getClass();
        Class<?> aClass1 = Class.forName("RefrectPinint.User");
        Class<User> userClass = User.class;

        /**
         *  常用的方法：
         *  1. 获取全限定类名
         *  2. 获取类名
         *  3. 创建实例
         */
        String name = aClass1.getName();
        String simpleName = aClass1.getSimpleName();
        Object o = aClass1.newInstance();
        PrintEasy.print(name,simpleName,o.toString());
        /**
         * 反射获取方法
         */


    }
}


class User{

    private String name;
    private Integer sex;

    public User() {
        this.name = "name";
        this.sex = 1;
    }

    /**
     *
     * @param name user's name
     * @param sex user's sex,1 is man and 0 is woman
     */

    public User(String name, Integer sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
class PrintEasy{

    public static void print(String...a){
        for (String s: a) {
            System.out.println(s);
        }
    }
}