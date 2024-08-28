package com.example.shopuser.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderDirectMQConfig {
    @Bean
    public Queue OrderDirectQueue(){
        return new Queue("OrderDirectQueue",true);
    }

    @Bean
    DirectExchange OrderDirectExchange(){
        return new DirectExchange("OrderDirectExchange",true,false);
    }

    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(OrderDirectQueue()).to(OrderDirectExchange()).with("OrderDirectRounting");
    }


}
