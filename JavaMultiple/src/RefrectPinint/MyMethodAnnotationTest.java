package RefrectPinint;

import java.lang.reflect.Method;

public class MyMethodAnnotationTest {

    private String name;
    public MyMethodAnnotationTest() {

    }

    @MyMethodAnnotation(title = "MyMethodAnnotationTest",description = "the constructor with one arg")
    public MyMethodAnnotationTest(String name) {
        this.name = name;
    }
    @MyMethodAnnotation(title = "getName",description = "get the name value")
    public String getName() {
        return name;
    }
    @MyMethodAnnotation(title = "setName",description = "set the name value")
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        try{


        }catch (Exception e){

        }
    }

}
