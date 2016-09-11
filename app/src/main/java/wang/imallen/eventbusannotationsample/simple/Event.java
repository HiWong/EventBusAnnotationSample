package wang.imallen.eventbusannotationsample.simple;

/**
 * Created by allen on 16-8-15.
 */
public class Event {

    private String message;

    public Event(String message){
        this.message=message;
    }

    public String getMessage(){
        return message;
    }

}
