package org.example.news_aggregator.mapper;

import org.example.news_aggregator.document.Contact;
import org.example.news_aggregator.dto.request.ContactRequest;
import org.example.news_aggregator.dto.response.ContactResponse;


public class ContactMapper {
    public static Contact toEntity(ContactRequest request) {
        Contact contact = new Contact();
        contact.setFn(request.getFn());
        contact.setLn(request.getLn());
        contact.setEmail(request.getEmail());
        contact.setMob(request.getMob());

        return contact;
    }

    public static ContactResponse toResponse(Contact contact) {
        ContactResponse response = new ContactResponse();
        response.setId(contact.getId());
        response.setFn(contact.getFn());
        response.setLn(contact.getLn());
        response.setEmail(contact.getEmail());
        response.setMob(contact.getMob());
        return response;
    }

    public static void updateEntity(Contact contact, ContactRequest request) {
        contact.setFn(request.getFn());
        contact.setLn(request.getLn());
        contact.setEmail(request.getEmail());
        contact.setMob(request.getMob());
    }
}
