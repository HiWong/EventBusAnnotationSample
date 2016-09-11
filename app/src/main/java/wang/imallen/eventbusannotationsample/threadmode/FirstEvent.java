package wang.imallen.eventbusannotationsample.threadmode;

import wang.imallen.eventbusannotationsample.simple.Event;

/**
 * Created by allen on 16-8-9.
 */
public class FirstEvent extends Event {

    public FirstEvent(String msg){
        super(msg);
    }
}
