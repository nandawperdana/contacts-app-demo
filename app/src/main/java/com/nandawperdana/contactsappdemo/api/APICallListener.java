package com.nandawperdana.contactsappdemo.api;

import com.nandawperdana.contactsappdemo.util.Enums;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by nandawperdana on 4/22/2016.
 */
public interface APICallListener {
    void onAPICallSucceed(Enums.APIRoute route, RealmObject responseModel);

    void onAPICallSucceed(Enums.APIRoute route, List<RealmObject> responseModels);

    void onAPICallFailed(Enums.APIRoute route, Throwable throwable);
}
