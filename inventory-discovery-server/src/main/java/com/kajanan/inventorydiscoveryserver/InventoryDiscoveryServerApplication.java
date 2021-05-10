package com.kajanan.inventorydiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InventoryDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryDiscoveryServerApplication.class, args);
	}

}
