package com.MyFirstProjecy.Blog.Application.services.Impl;

import com.MyFirstProjecy.Blog.Application.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) {
        
        return null;
    }
}
