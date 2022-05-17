package com.examplex.demo.controller;

import com.examplex.demo.Pojo.Item;
import com.examplex.demo.Pojo.Shipment;
import com.examplex.demo.maper.ItemMapper;

import com.examplex.demo.maper.ShipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:9876")
@RestController
@Component
@RequestMapping("/api")
public class ShipmentController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    ShipmentMapper shipmentMapper;
    /**
     *
     * assign shipment into the database
     * Item got from front
     */
    @PostMapping("/shipment")
    public ResponseEntity<Shipment> addShipment(@RequestBody Shipment shipment ){
        try {
        //String address, String product_name, int number
            if(shipment.getNumber()>0){
                shipmentMapper.save(new Shipment(shipment.getAddress(), shipment.getName(), shipment.getNumber()));
                return new ResponseEntity<>(shipment,HttpStatus.CREATED);
            }
            else
            return new ResponseEntity<>(shipment,HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            System.out.println("no result");
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    /**
     * get all the item from database and return to the front
     * @return a List of all the items in the database
     */

    // get all item
    @GetMapping("/shipment")
    public ResponseEntity<List<Shipment>> getAllShipment(){
        try {
            List<Shipment> shipments = new ArrayList<>();

            shipmentMapper.findAll().forEach(shipments::add);
            if(shipments.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(shipments,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
