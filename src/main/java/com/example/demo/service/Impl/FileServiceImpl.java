package com.example.demo.service.Impl;

import com.example.demo.entity.FileEntity;
import com.example.demo.mapper.FileMapper;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 文件service实现类
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    /**
     * 添加文件
     *
     * @param fileName
     * @param newPath
     */
    @Override
    public void addFile(String fileName, String newPath) {
        FileEntity entity = new FileEntity();
        Date date = new Date();
        entity.setFileName(fileName);
        entity.setFilePath(newPath);
        entity.setCreateDate(date);
        fileMapper.addFile(entity);
    }
}
