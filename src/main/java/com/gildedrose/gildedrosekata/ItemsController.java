/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.gildedrosekata;

import com.gildedrose.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saulius
 */
@RestController
public class ItemsController {

    @Autowired
    private ItemsRepository repository;

    @RequestMapping("/items")
    public List<Item> items() {
        return repository.findAll();
    }
}
