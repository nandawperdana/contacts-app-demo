package com.nandawperdana.contactsappdemo;

import android.app.Application;

import com.nandawperdana.contactsappdemo.util.ConnectivityReceiver;

/**
 * Created by NwP.
 */

public class AndroidApplication extends Application {
    private static AndroidApplication mInstance;

    private boolean connected = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AndroidApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
