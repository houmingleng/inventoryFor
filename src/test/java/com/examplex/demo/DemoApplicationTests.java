package com.examplex.demo;

import com.examplex.demo.Pojo.Item;
import com.examplex.demo.controller.ItemController;
import com.examplex.demo.maper.ItemMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
@SpringBootApplication
@Service
class DemoApplicationTests  implements CommandLineRunner {

    @Autowired
    ItemMapper itemMapper;
    @Autowired
    ItemController itemController;
    @Resource
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationTests.class, args);
    }

    @Test
    public void test() {
//        Item item = new Item();
//        ObjectId objectId = new ObjectId("62823a16ad5d3b2d1bd66d0f");
////        item.setId(objectId );
//        item.setName("222");
//        item.setNumber(222);
//        item.setAddress("222");
//        Query query = new Query(Criteria.where("id").is(item.getId()));
//        Update update = new Update();
//        mongoTemplate.save(item);
        listAll();
//        findByname("watch");
    }

    @Override
    public void run(String... args) throws Exception {
//        deleteAll();
//       item.setId("6280d72668a7e4267f8d74c7");
//   addSampleData(item);
        listAll();


////        Optional<Item> item1 = itemMapper.findOne(item,Item.class);
////        System.out.println(item1.isPresent());
////    delete(item);
//        update(item);
//        listAll();
//        findByRegex();
    }
    public void listAll() {
        System.out.println("Listing sample data");
        itemMapper.findAll().forEach(System.out::println);
    }
//    public void findByname(String name){
//        ItemController itemController = new ItemController();
//        System.out.println(itemController.findByName(name));
//    }
//    public void delete(Item item){
//        itemController.deleteItem(item);
//
//    }
//        public void update(Item item){
//        itemController.updateItem(item);
//        }
}
