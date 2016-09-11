package wang.imallen.eventbusannotationsample.threadmode;


import wang.imallen.eventbusannotationsample.simple.Event;

/**
 * Created by allen on 16-8-9.
 */
public class SecondEvent extends Event {
    public SecondEvent(String msg){
        super(msg);
    }
}
