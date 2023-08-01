package com.MyFirstProjecy.Blog.Application.services.Impl;

import com.MyFirstProjecy.Blog.Application.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String randomId = UUID.randomUUID().toString();
        String name = file.getOriginalFilename();
        String fileName = randomId.concat(name.substring(name.lastIndexOf(".")));
        String filePath = path + File.pathSeparator + fileName;

        File f = new File(path);
        if(!f.exists()){
           f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName;
    }

    @Override
    public InputStream getImage(String path, String fileName) throws FileNotFoundException {
        String fullPath = path+File.pathSeparator+fileName;
        InputStream is =new FileInputStream(fullPath);
        return is;
    }
}
