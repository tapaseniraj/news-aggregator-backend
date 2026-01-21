package org.example.news_aggregator.service;

import org.example.news_aggregator.dto.request.ContactRequest;
import org.example.news_aggregator.dto.request.ProductRequest;
import org.example.news_aggregator.dto.response.ContactResponse;
import org.example.news_aggregator.dto.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContactService {

    ContactResponse addContact(ContactRequest request);

    ContactResponse getContactById(String id);

    List<ContactResponse> getAllContacts();

    ContactResponse updateContact(String id, ContactRequest request);

    ContactResponse deleteContact(String id);
}
