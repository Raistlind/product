package cn.krynn.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by RaistlinD
 * 2018/7/11 下午9:59
 */
@RestController
@Slf4j
public class ClientController {

    //@Autowired
    //private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //第一种方式，直接使用RestTemplate，url写死
        //RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        //第二种方式，用LoadBalancerClient通过应用名称获取url，然后再使用RestTemplate
        //RestTemplate restTemplate = new RestTemplate();
        //ServiceInstance serviceInstance = loadBalancerClient.choose("ORDER");
        //String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        //String response = restTemplate.getForObject(url, String.class);

        //第三种方式，用@LoadBalanced，可在restTemplate里使用应用名字
        String response = restTemplate.getForObject("http://ORDER/msg", String.class);

        log.info("response={}", response);
        return response;
    }
}
