/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.gildedrosekata;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author saulius
 */
@Component
public class AssynchronousQualityUpdate {
    
    @Scheduled(cron = "#{cronExpression}")
    public void updateQualityAsync() {
        System.out.println("----------------");
    }
    
}
