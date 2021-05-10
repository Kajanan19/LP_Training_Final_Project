package com.kajanan.inventoryrawmaterialorderservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoadBalancerConfig {

  public static final String LOADBALANCED = "loadbalanced";
  public static final String STANDARD = "standard";

  @LoadBalanced
  @Bean
  @Qualifier(LOADBALANCED)
  public RestTemplate loadBalancedRestTemplate() {
    return new RestTemplate();
  }

  // @Bean
  // @Qualifier(STANDARD)
  // public RestTemplate restTemplate() {
  //   return new RestTemplate();
  // }

}
