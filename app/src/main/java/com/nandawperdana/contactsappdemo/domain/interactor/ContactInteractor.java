package com.nandawperdana.contactsappdemo.domain.interactor;

import com.nandawperdana.contactsappdemo.api.APICallListener;
import com.nandawperdana.contactsappdemo.api.APICallManager;
import com.nandawperdana.contactsappdemo.api.contacts.BlankModel;
import com.nandawperdana.contactsappdemo.api.contacts.ContactModel;
import com.nandawperdana.contactsappdemo.api.contacts.ContactsModel;
import com.nandawperdana.contactsappdemo.util.Enums;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NwP.
 */

public class ContactInteractor {
    APICallListener listener;

    public ContactInteractor(APICallListener listener) {
        this.listener = listener;
    }

    public void callAPIGetContacts() {
        final Enums.APIRoute route = Enums.APIRoute.GET_CONTACTS;
        Call<ContactsModel> call = APICallManager.getInstance().
                contactManager.getContacts();
        call.enqueue(new Callback<ContactsModel>() {
            @Override
            public void onResponse(Call<ContactsModel> call, Response<ContactsModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ContactsModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetContact(String id) {
        final Enums.APIRoute route = Enums.APIRoute.GET_CONTACT;
        Call<ContactModel> call = APICallManager.getInstance().
                contactManager.getContact(id);
        call.enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ContactModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIPostContact(String firstName, String lastName, String email,
                                   String phoneNumber, boolean favorite) {
        final Enums.APIRoute route = Enums.APIRoute.POST_CONTACT;
        Call<ContactModel> call = APICallManager.getInstance().
                contactManager.postContact(firstName, lastName, email, phoneNumber, favorite);
        call.enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ContactModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIPutContact(String id, String firstName, String lastName) {
        final Enums.APIRoute route = Enums.APIRoute.PUT_CONTACT;
        Call<ContactModel> call = APICallManager.getInstance().
                contactManager.putContact(id, firstName, lastName);
        call.enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ContactModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }


    public void callAPIDeleteContact(String id) {
        final Enums.APIRoute route = Enums.APIRoute.DELETE_CONTACT;
        Call<BlankModel> call = APICallManager.getInstance().
                contactManager.deleteContact(id);
        call.enqueue(new Callback<BlankModel>() {
            @Override
            public void onResponse(Call<BlankModel> call, Response<BlankModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<BlankModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }
}
