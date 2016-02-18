package com.metafour.microserviceconsumerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
@EnableDiscoveryClient
public class App {

	@Autowired
    @LoadBalanced
    protected RestTemplate restTemplate; 
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return restTemplate.getForObject("http://microservice-demo/", String.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
