package com.example.planets;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class countdownActivity extends AppCompatActivity {
    private  MyCountDownTimer mc;
    private TextView tv;
    private Button tgbt;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate( saveInstanceState );
        setContentView( R.layout.activity_countdown );
        tv = findViewById( R.id.textView1 );
        tgbt = findViewById( R.id.tgbtn );
        tgbt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(  );
                intent.setClass( countdownActivity.this,MainActivity.class );
                startActivity( intent );
            }
        } );
        mc = new MyCountDownTimer( 4000 , 1000 );
        mc.start();
       tv.postDelayed( new Runnable() {
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
                Intent intent = new Intent();
                intent.setClass(countdownActivity.this , MainActivity.class );
                startActivity( intent );
            }
            private void startActivity(Intent intent) {

            }
        } , 4000 );
    }
    private Handler handler= new Handler() {
        /**
         * Publish a <tt>LogRecord</tt>.
         * <p>
         * The logging request was made initially to a <tt>Logger</tt> object,
         * which initialized the <tt>LogRecord</tt> and forwarded it here.
         * <p>
         * The <tt>Handler</tt>  is responsible for formatting the message, when and
         * if necessary.  The formatting should include localization.
         *
         * @param record description of the log event. A null record is
         *               silently ignored and is not published
         */
        @Override
        public void publish(LogRecord record) {
            
        }

        /**
         * Flush any buffered output.
         */
        @Override
        public void flush() {

        }

        /**
         * Close the <tt>Handler</tt> and free all associated resources.
         * <p>
         * The close method will perform a <tt>flush</tt> and then close the
         * <tt>Handler</tt>.   After close has been called this <tt>Handler</tt>
         * should no longer be used.  Method calls may either be silently
         * ignored or may throw runtime exceptions.
         *
         * @throws SecurityException if a security manager exists and if
         *                           the caller does not have <tt>LoggingPermission("control")</tt>.
         */
        @Override
        public void close() throws SecurityException {

        }
    };
    class MyCountDownTimer extends CountDownTimer {

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
