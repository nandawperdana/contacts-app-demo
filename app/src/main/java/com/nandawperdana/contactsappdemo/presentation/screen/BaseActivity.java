package com.nandawperdana.contactsappdemo.presentation.screen;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.nandawperdana.contactsappdemo.AndroidApplication;
import com.nandawperdana.contactsappdemo.R;
import com.nandawperdana.contactsappdemo.util.ConnectivityReceiver;

public class BaseActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidApplication.getInstance().setConnected(isOnline());
    }

    @Override
    protected void onResume() {
        super.onResume();
        AndroidApplication.getInstance().setConnectivityListener(BaseActivity.this);
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void showError(final String message) {
        final Context con = BaseActivity.this;
        if (con != null) {
            new Handler().post(new Runnable() {
                public void run() {
                    new MaterialDialog.Builder(con)
                            .content(message)
                            .title("Terjadi kesalahan...")
                            .positiveText("Oke")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                                    materialDialog.dismiss();
                                    finish();
                                }
                            })
                            .autoDismiss(false)
                            .contentColor(getResources().getColor(R.color.black_25)) // notice no 'res' postfix for literal color
                            .backgroundColorRes(R.color.white)
                            .show();
                }
            });
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        AndroidApplication.getInstance().setConnected(isConnected);
        if (!isConnected) {
            showError(getResources().getString(R.string.message_no_internet));
        }
    }
}
