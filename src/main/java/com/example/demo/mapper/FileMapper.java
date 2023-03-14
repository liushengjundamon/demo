package com.example.demo.mapper;

import com.example.demo.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileMapper {
    /**
     * 添加文件
     *
     * @param entity
     */
    void addFile(@Param("entity") FileEntity entity);
}
