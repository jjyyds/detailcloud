package com.yc.springcloud812.security.dao;

import com.yc.springcloud812.security.bean.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends MisBaseMapper<Book>{
}