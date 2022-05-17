package com.examplex.demo.Pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * shipment description pojo
 */

@Data
@Document(collection = "shipment")
public class Shipment {
    private String id;
    private String address;

    private String name;
    private int number;

    public Shipment() {
    }


    public Shipment(String address, String product_name, int number) {
        this.address = address;
        this.name = product_name;
        this.number = number;
    }


}
