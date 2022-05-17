package com.examplex.demo.controller;

import com.examplex.demo.Pojo.Item;
import com.examplex.demo.maper.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:9876")
@RestController
@Component
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    ItemMapper itemMapper;


    /**
     *
     * add item into the database
     * Item got from front
     */
    @PostMapping("/items")
    public ResponseEntity<Item> addItem(@RequestBody Item item){
            try {
                Item _item = itemMapper.save(new Item(item.getAddress(),item.getName(),item.getNumber()));
                return new ResponseEntity<>(_item,HttpStatus.CREATED);
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
    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        try {
            List<Item> items = new ArrayList<>();

            itemMapper.findAll().forEach(items::add);
            if(items.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }


            return new ResponseEntity<>(items,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //update

    /**
     * update the target item, the item contains an id
     * @param item the target item user want to change
     * @return return status
     */
    @PutMapping("/items")
    public ResponseEntity updateItem( @RequestBody Item item){
//        System.out.println("  1  "+item.getId().toString());
//        Item save = mongoTemplate.save(item);
//        System.out.println("2 == "+save.getId());
        if(itemMapper.existsById(item.getId().toString()) && item.getNumber()>=0){
        itemMapper.save(item);
        return  new ResponseEntity(HttpStatus.OK);
    }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    //Delete

    /**
     * delete target item from database
     * @param id the id trans from front web
     * @return Http status
     */
    @DeleteMapping("/items/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable String id) {
        System.out.println(id);
        try {
            Query query = new Query(Criteria.where("id").is(id));
            mongoTemplate.remove(query, Item.class);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
