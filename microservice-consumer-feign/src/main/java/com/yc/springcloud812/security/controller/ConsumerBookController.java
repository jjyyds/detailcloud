package com.yc.springcloud812.security.controller;

import com.yc.springcloud812.security.bean.Book;
import com.yc.springcloud812.service.IProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerBookController {

    @Resource
    private IProductClientService iProductClientService;

    @Resource
    private LoadBalancerClient loadBalancerClient;//因为ribbon是客户端的负载均衡，所以它可以在客户端记录访问的日志


    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") Integer id){
        return this.iProductClientService.getProduct(id);
    }

    
    @GetMapping("/findAll")
    public List<Book> findAll( ){
        return this.iProductClientService.listProduct();
    }
}
