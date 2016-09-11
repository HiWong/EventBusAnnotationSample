package wang.imallen.eventbusannotationsample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;
import wang.imallen.eventbusannotationsample.bean.UserInfo;
import wang.imallen.eventbusannotationsample.simple.Event;
import wang.imallen.eventbusannotationsample.threadmode.FirstEvent;
import wang.imallen.eventbusannotationsample.threadmode.FourthEvent;
import wang.imallen.eventbusannotationsample.threadmode.SecondEvent;
import wang.imallen.eventbusannotationsample.threadmode.ThirdEvent;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        },5000);
    }

    @OnClick(R.id.postBtn)
    public void startToPost(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new Event("Perfect is not pretty"));
            }
        }).start();
        this.finish();
    }

    @OnClick(R.id.postFirstEventBtn)
    public void postFirstEvent(View view){
        EventBus.getDefault().post(new FirstEvent("FirstEvent"));
    }

    @OnClick(R.id.postSecondEventBtn)
    public void postSecondEvent(View view){
        EventBus.getDefault().post(new SecondEvent("SecondEvent"));
    }

    @OnClick(R.id.postThirdEventBtn)
    public void postThirdEvent(View view){
        EventBus.getDefault().post(new ThirdEvent("ThirdEvent"));
    }

    @OnClick(R.id.postFourthEventBtn)
    public void postFourthEvent(View view){
        EventBus.getDefault().post(new FourthEvent("FourthEvent"));
    }

    @OnClick(R.id.postStickyEventBtn)
    public void postStickEvent(View view){
        EventBus.getDefault().postSticky(new UserInfo("Bruce Lee",55));
    }

}
