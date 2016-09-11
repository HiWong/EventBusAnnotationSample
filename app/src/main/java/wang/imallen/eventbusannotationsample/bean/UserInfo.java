package wang.imallen.eventbusannotationsample.bean;

/**
 * Created by allen on 16-9-10.
 */
public class UserInfo {

    public UserInfo(String name,int age){
        this.name=name;
        this.age=age;
    }

    private String name;
    private int age;

    public String toString(){
        return "name:"+name+",age:"+age;
    }
}
