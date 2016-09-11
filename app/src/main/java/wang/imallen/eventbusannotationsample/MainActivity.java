package wang.imallen.eventbusannotationsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.OnClick;
import wang.imallen.eventbusannotationsample.simple.Event;
import wang.imallen.eventbusannotationsample.threadmode.FirstEvent;
import wang.imallen.eventbusannotationsample.threadmode.FourthEvent;
import wang.imallen.eventbusannotationsample.threadmode.SecondEvent;
import wang.imallen.eventbusannotationsample.threadmode.ThirdEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getSimpleName();

    private TextView showInfoTv;

    private void initView(){
        showInfoTv=(TextView)findViewById(R.id.showInfoTv);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initView();
        Log.d(TAG,"start of addIndex");
        EventBus eventBus=EventBus.builder().addIndex(new MyEventBusIndex()).build();
        Log.d(TAG,"end of addIndex");
        eventBus.register(this);
    }

    @Subscribe(threadMode= ThreadMode.MAIN)
    public void onEvent(Event event){
        String msg=event.getMessage();
        Log.d(TAG,"onEvent:"+msg);
        showInfoTv.setText(msg);
    }

    @Subscribe(threadMode =ThreadMode.POSTING)
    public void onEventPosting(SecondEvent event){
        String msg=event.getMessage();
        Log.d(TAG,"onEventPosting:"+event.getMessage());
    }

    @Subscribe(threadMode=ThreadMode.BACKGROUND)
    public void onEventBackground(ThirdEvent event){
        String msg=event.getMessage();
        Log.d(TAG,"onEventBackground:"+msg);
    }

    @Subscribe(threadMode=ThreadMode.ASYNC)
    public void onEventAsync(FourthEvent event){
        String msg=event.getMessage();
        Log.d(TAG,"onEventAsync:"+msg);
    }

    @OnClick(R.id.btn_open)
    public void openSecondActivity(View view){
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);
    }

}
