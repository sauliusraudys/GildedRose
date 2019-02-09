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
    
    @Value("${gilded-rose.quality_update_time}")
    private String cron_expression;
    
    @Bean
    String cronExpression() {
        // TODO: validate expression for "once a day meaning"
        return cron_expression;
    }
}
