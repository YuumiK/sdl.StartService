package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Service3 extends IntentService {
    private final static String TAG = Service3.class.getSimpleName();
    public final static String EXTRA_MYARG = "MYARG";
    public final static String ACTION_ANSWER = "action";
    public final static String EXTRA_ANSWER = "extra";


    public Service3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Thread.sleep(5000); // 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
        Intent new_intent = new Intent();
        new_intent.setAction(ACTION_ANSWER);
        new_intent.putExtra(EXTRA_ANSWER,1);
        sendBroadcast(new_intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }

}
