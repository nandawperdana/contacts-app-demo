package com.nandawperdana.contactsappdemo.presentation.screen;

/**
 * Created by NwP.
 */
public interface BaseView {
    /**
     * This is a general method used for showing some kind of progress during a background task. For example, this
     * method should show a progress bar and/or disable buttons before some background work starts.
     *
     * @param flag True to show, false to hide progress
     */
    void showProgress(boolean flag);

    /**
     * This method is used for showing toast messages on the UI.
     *
     * @param message
     */
    void showToast(String message);

    /**
     * This method is used for showing error messages on the UI via dialog.
     *
     */
    void showError();
}
