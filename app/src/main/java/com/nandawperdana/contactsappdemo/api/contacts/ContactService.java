package com.nandawperdana.contactsappdemo.api.contacts;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by NwP.
 */

public interface ContactService {
    @GET("/contacts.json")
    Call<ContactsModel>
    getContacts();

    @GET("/contacts/{id}.json")
    Call<ContactModel>
    getContact(@Path("id") String id);

    @FormUrlEncoded
    @POST("/contacts.json")
    Call<ContactModel>
    postContact(@Field("first_name") String firstName,
                @Field("last_name") String lastName,
                @Field("email") String email,
                @Field("phone_number") String phoneNumber,
                @Field("favorite") boolean favorite);

    @FormUrlEncoded
    @PUT("/contacts/{id}.json")
    Call<ContactModel>
    putContact(@Path("id") String id,
               @Field("first_name") String firstName,
               @Field("last_name") String lastName);

    @DELETE("/contacts/{id}.json")
    Call<BlankModel>
    deleteContact(@Path("id") String id);
}
