package org.example.news_aggregator.service.impl;

import org.example.news_aggregator.document.Contact;
import org.example.news_aggregator.dto.request.ContactRequest;
import org.example.news_aggregator.dto.response.ContactResponse;
import org.example.news_aggregator.mapper.ContactMapper;
import org.example.news_aggregator.repository.ContactRepository;
import org.example.news_aggregator.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Override
    public ContactResponse addContact(ContactRequest request) {
        return ContactMapper.toResponse(repository.save(ContactMapper.toEntity(request)));
    }

    @Override
    public ContactResponse getContactById(String id) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        return ContactMapper.toResponse(contact);
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        return repository.findAll()
                .stream()
                .map(ContactMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ContactResponse updateContact(String id, ContactRequest request) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        ContactMapper.updateEntity(contact,request);
        return ContactMapper.toResponse(repository.save(contact));
    }

    @Override
    public ContactResponse deleteContact(String id) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        repository.deleteById(id);
        return ContactMapper.toResponse(contact);
    }
}
