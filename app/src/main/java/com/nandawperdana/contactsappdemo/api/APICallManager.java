package com.nandawperdana.contactsappdemo.api;

import com.nandawperdana.contactsappdemo.BuildConfig;
import com.nandawperdana.contactsappdemo.api.contacts.BlankModel;
import com.nandawperdana.contactsappdemo.api.contacts.ContactModel;
import com.nandawperdana.contactsappdemo.api.contacts.ContactService;
import com.nandawperdana.contactsappdemo.api.contacts.ContactsModel;
import com.nandawperdana.contactsappdemo.util.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nandawperdana on 4/22/2016.
 */
public class APICallManager {
    public String mEndPoint = Constants.Path.DEFAULT_URL_API_STAGING;
    public static APICallManager mInstance;
    public static Retrofit sRetrofit;

    private final String mContentType = "application/json";
    private String authorizationKey;

    public ContactManager contactManager;

    /**
     * singleton class instance
     *
     * @return APICallManager
     */
    public static APICallManager getInstance() {
        if (mInstance == null) {
            synchronized (APICallManager.class) {
                if (mInstance == null) {
                    mInstance = new APICallManager();
                }
            }
        }
        return mInstance;
    }

    public APICallManager() {
        if (BuildConfig.BUILD_RELEASE)
            mEndPoint = Constants.Path.DEFAULT_URL_API_PRODUCTION;

        // enable logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        sRetrofit = new Retrofit.Builder()
                .baseUrl(mEndPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        // registering API endpoint manager
        this.contactManager = new ContactManager();
    }

    public static <T> T getService(Class<T> serviceClass) {
        return sRetrofit.create(serviceClass);
    }

    public String getAuthorizationKey() {
        return authorizationKey;
    }

    public void setAuthorizationKey(String authorizationKey) {
        this.authorizationKey = authorizationKey;
    }

    public class ContactManager {
        public Call<ContactsModel> getContacts() {
            ContactService service = getService(ContactService.class);
            return service.getContacts();
        }

        public Call<ContactModel> getContact(String id) {
            ContactService service = getService(ContactService.class);
            return service.getContact(id);
        }

        public Call<ContactModel> postContact(String firstName, String lastName, String email,
                                              String phoneNumber, boolean favorite) {
            ContactService service = getService(ContactService.class);
            return service.postContact(firstName, lastName, email, phoneNumber, favorite);
        }

        public Call<ContactModel> putContact(String id, String firstName, String lastName) {
            ContactService service = getService(ContactService.class);
            return service.putContact(id, firstName, lastName);
        }

        public Call<BlankModel> deleteContact(String id) {
            ContactService service = getService(ContactService.class);
            return service.deleteContact(id);
        }

    }
}
