package org.example.news_aggregator.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "contact")
public class Contact {
    @Id
    private String id;

    private String fn;
    private String ln;
    private String email;
    private String mob;
    private String address;
}
