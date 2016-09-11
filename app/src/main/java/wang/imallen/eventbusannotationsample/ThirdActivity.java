package wang.imallen.eventbusannotationsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import wang.imallen.eventbusannotationsample.bean.UserInfo;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG=ThirdActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true,threadMode= ThreadMode.MAIN)
    public void onStickyEvent(UserInfo info){
        Log.d(TAG,"userinfo is as below:"+info);
    }

    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
