/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.gildedrosekata;

import com.gildedrose.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author saulius
 */
public interface ItemsRepository extends MongoRepository<Item, String>{
}
