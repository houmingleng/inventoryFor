package com.examplex.demo.maper;

import com.examplex.demo.Pojo.Shipment;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
/**
 * the part we delclear own methods with
 */
@Configuration
@EnableMongoRepositories
public interface ShipmentMapper extends MongoRepository <Shipment, String > {
}
