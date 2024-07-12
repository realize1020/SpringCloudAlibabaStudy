package com.example.shoporder.controller;
import com.example.common.entity.Product;
import com.example.shoporder.entity.Order;
import com.example.shoporder.service.OrderService;

import com.example.shoporder.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/*
 *@Author wang
 *@Date 2022/7/11 23 :08
 *@description
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {


    private final RestTemplate restTemplate;


    private final OrderService orderService;

    //使用nacos
    private final DiscoveryClient discoveryClient;
    
    private final ProductService productService;

    //准备买一件商品(使用RestTemplate直接地址调用）
    @GetMapping("/order/prod/{id}")
    public /*Order*/Product order(@PathVariable("id") Integer id){
        System.err.println(">>客户下单，这时候要调用商品微服务查询商品信息");

        //通过restTemplate调用商品微服务
        Product product=restTemplate.getForObject("http://localhost:8081/product/"+id,Product.class);
        System.out.println(product.toString());
        return product;
    }



    //准备买一件商品(使用nacos先找到Product服务）
    @GetMapping("/order2/prod/{id}")
    public /*Order*/Product order2(@PathVariable("id") Integer id){
        System.err.println(">>客户下单，这时候要调用商品微服务查询商品信息");

        //从nacos中获取服务地址
        ServiceInstance serviceInstance = discoveryClient.getInstances("shop-product").get(0);

        String url=serviceInstance.getHost()+":"+serviceInstance.getPort();

        log.info(">>从nacos中获取到的微服务地址为："+url);
        System.err.println("http://"+url+"/product/"+id);

        //通过restTemplate调用商品微服务
        Product product=restTemplate.getForObject("http://"+url+"/product/"+id,Product.class);

        return product;
    }




    //准备买一件商品(使用nacos自定义均衡负载策略）
    @GetMapping("/order3/prod/{id}")
    public Product order3(@PathVariable("id") Integer id){
        System.err.println(">>客户下单，这时候要调用商品微服务查询商品信息");

        //从nacos中获取服务地址
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("shop-product");

        //自定义规则实现随机挑选服务
        int index = new Random().nextInt(serviceInstanceList.size());

        ServiceInstance serviceInstance = serviceInstanceList.get(index);

        String url=serviceInstance.getHost()+":"+serviceInstance.getPort();

        log.info(">>从nacos中获取到的微服务地址为："+url);
        System.err.println("http://"+url+"/product/"+id);

        //通过restTemplate调用商品微服务
        Product product=restTemplate.getForObject("http://"+url+"/product/"+id,Product.class);

        return product;
    }





    //准备买一件商品(使用nacos调用商品服务，Ribbon均衡负载组件）
    @GetMapping("/order4/prod/{id}")
    public Product order4(@PathVariable("id") Integer id){
        System.err.println(">>客户下单，这时候要调用商品微服务查询商品信息");

        String url="shop-product";

        log.info(">>从nacos中获取到的微服务地址为："+url);
        System.err.println("http://"+url+"/product/"+id);

        //通过restTemplate调用商品微服务
        Product product=restTemplate.getForObject("http://"+url+"/product/"+id,Product.class);

        return product;
    }






    //使用nacos调用商品服务，使用Feign，（Feign中自动集成了Ribbon均衡负载组件）
    @GetMapping(value = "/order5/prod/{id}",produces = "application/json;charset=utf-8")
    public Product order5(@PathVariable("id") Integer id){
        System.err.println(">>客户下单，这时候要调用商品微服务查询商品信息");
        
        //通过feign调用商品微服务
        Product product = productService.findByPid(id);
        if(product.getId()==-1){
            log.error("下单失败！");
            product.setName("下单失败");
        }

        return product;
    }
}
