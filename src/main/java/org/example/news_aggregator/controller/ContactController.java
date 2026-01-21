package org.example.news_aggregator.controller;
import org.example.news_aggregator.dto.request.ContactRequest;
import org.example.news_aggregator.dto.response.ContactResponse;
import org.example.news_aggregator.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactResponse> addContact(@RequestBody ContactRequest contact) {
        return ResponseEntity.ok(contactService.addContact(contact));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAllContacts(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getContactById(@PathVariable String id){
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<ContactResponse> updateContact(
            @PathVariable String id,
            @RequestBody ContactRequest request) {
        return ResponseEntity.ok(contactService.updateContact(id, request));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ContactResponse> deleteContact(@PathVariable String id) {
        return ResponseEntity.ok(contactService.deleteContact(id));
    }

}
