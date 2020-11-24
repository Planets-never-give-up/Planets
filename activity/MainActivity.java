package com.example.sleep.base.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

import com.example.sleep.R;
public class MainActivity extends Activity {
private  MyCountDownTimer mc;
private TextView tv;

protected void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    setContentView( R.layout.activity_main  );
    tv=findViewById( R.id.textView1 );
    mc = new MyCountDownTimer( 4000,1000 );
    mc.start();
    handler.postDelayed(new Runnable(){
        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            Intent intent = new Intent( MainActivity.this,WelcomeActivity.class );
            startActivity( intent );
        }
    },4000);
}
private Handler handler=new Handler();
class MyCountDownTimer extends CountDownTimer{

    /**
     * @param millisInFuture    The number of millis in the future from the call
     * 表示以毫秒为单位 倒计时总数                         to {@link #start()} until the countdown is done and {@link #onFinish()}
     *  例如 millisInFuture=1000 表示1秒                         is called.
     * @param countDownInterval The interval along the way to receive
     *                         {@link #onTick(long)} callbacks.
     */
    public MyCountDownTimer(long millisInFuture , long countDownInterval) {
        super( millisInFuture , countDownInterval );
    }

    /**
     * Callback fired on regular interval.
     *
     * @param millisUntilFinished The amount of time until finished.
     */
    @Override
    public void onTick(long millisUntilFinished) {
        tv.setText( "倒计时("+millisUntilFinished / 1000 +")" );
    }

    /**
     * Callback fired when the time is up.
     */
    @Override
    public void onFinish() {
   tv.setText( "正在跳转" );
    }
}
}
