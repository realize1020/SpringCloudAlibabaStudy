//package com.exapmple.gateway.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.base.Charsets;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferWrapper;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class AuthGlobalFilter  implements GlobalFilter,Ordered {
//
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token = exchange.getRequest().getQueryParams().getFirst("token");
//        if(StringUtils.isBlank(token)){
//            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            //return exchange.getResponse().setComplete();
//            // 构建统一的错误响应体
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("code", HttpStatus.UNAUTHORIZED.value());
//            errorResponse.put("message", "Unauthorized access, token is missing or invalid.");
//
//            // 设置ContentType并写入响应体
//            response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//            try {
//                //byte[] bytes = objectMapper.writeValueAsBytes(errorResponse);
//                String errMesage = objectMapper.writeValueAsString(errorResponse);
//                byte[] bytes = errMesage.getBytes(Charsets.UTF_8);
//                DataBuffer wrap = response.bufferFactory().wrap(bytes);
//                Mono<DataBuffer> just = Mono.just(wrap);
//                return response.writeWith(just);
//            } catch (Exception e) {
//                // 处理序列化异常
//                return Mono.error(e);
//            }
//        }
//        //调用chain.filter继续向下游执行
//        return chain.filter(exchange);
//    }
//
////数值越小，优先级越高
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
