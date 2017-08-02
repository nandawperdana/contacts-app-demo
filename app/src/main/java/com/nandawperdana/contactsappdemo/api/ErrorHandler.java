package com.nandawperdana.contactsappdemo.api;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by NwP.
 */
public class ErrorHandler {

    public static RootResponseModel parseError(Response<?> response) {
        Converter<ResponseBody, RootResponseModel> converter =
                APICallManager.sRetrofit
                        .responseBodyConverter(RootResponseModel.class, new Annotation[0]);

        RootResponseModel error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new RootResponseModel();
        }

        return error;
    }

}