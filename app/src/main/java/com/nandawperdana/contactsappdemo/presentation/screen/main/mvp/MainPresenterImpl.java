package com.nandawperdana.contactsappdemo.presentation.screen.main.mvp;

import com.nandawperdana.contactsappdemo.AndroidApplication;
import com.nandawperdana.contactsappdemo.R;
import com.nandawperdana.contactsappdemo.api.APICallListener;
import com.nandawperdana.contactsappdemo.api.contacts.ContactsModel;
import com.nandawperdana.contactsappdemo.domain.interactor.ContactInteractor;
import com.nandawperdana.contactsappdemo.presentation.presenter.MainPresenter;
import com.nandawperdana.contactsappdemo.util.Enums;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by NwP.
 */
public class MainPresenterImpl implements MainPresenter, APICallListener {
    MainView mView;
    ContactInteractor mContactInteractor;

    public MainPresenterImpl(MainView mView) {
        this.mView = mView;
        this.mContactInteractor = new ContactInteractor(this);
    }

    @Override
    public void presentState(MainView.ViewState state) {
        switch (state) {
            case IDLE:
                mView.showState(MainView.ViewState.IDLE);
                break;
            case LOADING:
                mView.showState(MainView.ViewState.LOADING);
                break;
            case SHOW_CONTACTS:
                mView.showState(MainView.ViewState.SHOW_CONTACTS);
                break;
            case LOAD_CONTACTS:
                if (AndroidApplication.getInstance().isConnected()) {
                    mContactInteractor.callAPIGetContacts();
                } else {
                    mView.doRetrieveModel().setResponseMessage(mView.doRetrieveModel()
                            .getContext().getString(R.string.message_no_internet));
                }
                mView.showState(MainView.ViewState.LOAD_CONTACTS);
                break;
            case ERROR:
                mView.showState(MainView.ViewState.ERROR);
                break;
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onAPICallSucceed(Enums.APIRoute route, RealmObject responseModel) {
        switch (route) {
            case GET_CONTACTS:
                mView.doRetrieveModel().mContactsDomain.setContactsModel((ContactsModel) responseModel);
                presentState(MainView.ViewState.SHOW_CONTACTS);
                break;
        }
    }

    @Override
    public void onAPICallSucceed(Enums.APIRoute route, List<RealmObject> responseModels) {

    }

    @Override
    public void onAPICallFailed(Enums.APIRoute route, Throwable throwable) {
        mView.doRetrieveModel().setResponseMessage(throwable.getMessage());
        presentState(MainView.ViewState.IDLE);
        presentState(MainView.ViewState.ERROR);
    }
}
