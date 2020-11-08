package com.yc.springcloud812.service;

import com.yc.springcloud812.security.bean.Book;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//此类表示当 正常服务访问不到时，熔断的处理类
@Component //必须被spring托管
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        //这里提供请求方法出问题时回退处理机制
        return new IProductClientService() {
            @Override
            public Book getProduct(int id) {
                Book book=new Book();
                book.setBookId(id);
                book.setBookName("服务器繁忙，请稍后再试");
                return book;
            }

            @Override
            public List<Book> listProduct() {
                return null;
            }
        };
    }
}
