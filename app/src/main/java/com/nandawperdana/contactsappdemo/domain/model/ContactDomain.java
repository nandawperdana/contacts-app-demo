package com.nandawperdana.contactsappdemo.domain.model;

import com.nandawperdana.contactsappdemo.api.contacts.ContactModel;

/**
 * Created by NwP.
 */

public class ContactDomain {
    ContactModel contactModel;

    public ContactDomain() {
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }
}
