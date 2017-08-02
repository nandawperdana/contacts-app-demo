package com.nandawperdana.contactsappdemo.presentation.presenter;

import com.nandawperdana.contactsappdemo.presentation.screen.BaseView;
import com.nandawperdana.contactsappdemo.presentation.screen.main.mvp.MainViewModel;

/**
 * Created by NwP.
 */

public interface MainPresenter extends BasePresenter {
    interface MainView extends BaseView {
        /**
         * This enum is used for determine the current state of this screen
         */
        enum ViewState {
            IDLE, LOADING, SHOW_CONTACTS, LOAD_CONTACTS, ERROR
        }

        /**
         * This method is to show the current state of this screen
         *
         * @param viewState
         */
        void showState(ViewState viewState);

        /**
         * This function return the model that was belong to this screen
         *
         * @return
         */
        MainViewModel doRetrieveModel();
    }

    /**
     * This method is used for present the current state of this screen
     *
     * @param state
     */
    void presentState(MainView.ViewState state);
}
