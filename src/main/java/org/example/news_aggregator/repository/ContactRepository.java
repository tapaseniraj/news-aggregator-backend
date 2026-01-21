package org.example.news_aggregator.repository;

import org.example.news_aggregator.document.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
