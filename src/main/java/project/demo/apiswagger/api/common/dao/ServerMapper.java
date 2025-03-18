package project.demo.apiswagger.api.common.dao;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface ServerMapper {
    public LocalDateTime selectNow();
}