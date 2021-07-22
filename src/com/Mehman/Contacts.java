package com.Mehman;

import java.util.HashMap;
import java.util.Map;

public class Contacts {

    private Map<String, Contact> storage = new HashMap<>();

    public void addContact(Contact contact) {
        storage.put(contact.getPhone(), contact);
    }

    public boolean contains(String phone) {
        return storage.containsKey(phone);
    }

    public Contact get(String phone) {
        return storage.get(phone);
    }
}