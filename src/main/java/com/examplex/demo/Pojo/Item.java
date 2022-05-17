package com.examplex.demo.Pojo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 *  Item description
 */

@Data
@Document(collection = "items")
public class Item {
   private String id;
    private String address;
    private String name;
    private int number;

    public Item() {
    }

    public Item(String address, String name, int number) {
        this.address = address;
        this.name = name;
        this.number = number;
    }

}
