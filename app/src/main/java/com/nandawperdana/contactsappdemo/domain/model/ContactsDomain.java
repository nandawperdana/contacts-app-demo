package com.nandawperdana.contactsappdemo.domain.model;

import com.nandawperdana.contactsappdemo.api.contacts.ContactsModel;

/**
 * Created by NwP.
 */

public class ContactsDomain {
    ContactsModel contactsModel;

    public ContactsDomain() {
    }

    public ContactsModel getContactsModel() {
        return contactsModel;
    }

    public void setContactsModel(ContactsModel contactsModel) {
        this.contactsModel = contactsModel;
    }
}
