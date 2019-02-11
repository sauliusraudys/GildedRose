/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose;

import com.gildedrose.gildedrosekata.ItemsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author saulius
 */
@Component
public class AssynchronousQualityUpdate {
    
    @Autowired
    private ItemsRepository repository;
    
    @Transactional
    @Scheduled(cron = "#{cronExpression}")
    public void updateQualityAsync() {
        List<Item> itemsList = repository.findAll();
        
        repository.deleteAll();
        
        Item[] items = new Item[itemsList.size()];
        itemsList.toArray(items);
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        for(Item i : app.items) {
            repository.save(i);
        }        
    }
    
}
