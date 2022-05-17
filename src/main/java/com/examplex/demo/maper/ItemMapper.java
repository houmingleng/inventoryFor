package com.examplex.demo.maper;

import com.examplex.demo.Pojo.Item;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;


import java.util.List;

/**
 * the part we delclear own methods with
 */
@Configuration
@EnableMongoRepositories
public interface ItemMapper extends MongoRepository<Item , String > {

   List<Item> findByName(String name);
}
