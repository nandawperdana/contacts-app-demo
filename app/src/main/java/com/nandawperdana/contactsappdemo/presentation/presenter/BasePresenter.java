package com.nandawperdana.contactsappdemo.presentation.presenter;

/**
 * Created by NwP.
 */
public interface BasePresenter {
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (ActivityData or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (ActivityData or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (ActivityData or Fragment) onStop() method.
     */
    void stop();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (ActivityData or Fragment) onDestroy() method.
     */
    void destroy();
}
