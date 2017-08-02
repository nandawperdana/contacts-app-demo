package com.nandawperdana.contactsappdemo.presentation.screen.main.mvp;

import android.content.Context;

import com.nandawperdana.contactsappdemo.domain.model.ContactsDomain;

/**
 * Created by NwP.
 */

public class MainViewModel {
    private Context context;
    private String responseMessage;

    public ContactsDomain mContactsDomain;

    public MainViewModel(Context context) {
        this.context = context;
        this.mContactsDomain = new ContactsDomain();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
