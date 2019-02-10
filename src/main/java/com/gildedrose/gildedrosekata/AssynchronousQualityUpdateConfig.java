/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gildedrose.gildedrosekata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author saulius
 */
@Configuration
public class AssynchronousQualityUpdateConfig {
    
    @Value("${gilded-rose.update_quality_at_hour}")
    private String update_quality_at_hour;
    @Value("${gilded-rose.update_quality_at_minute}")
    private String update_quality_at_minute;
    
    @Bean
    String cronExpression() {
        return String.format("0 %s %s ? * *", update_quality_at_minute, update_quality_at_hour);
    }
}
