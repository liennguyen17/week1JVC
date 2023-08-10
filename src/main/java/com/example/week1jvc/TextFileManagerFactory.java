package com.example.week1jvc;

//Factory cụ thể cho đọc file Text
public class TextFileManagerFactory implements IFileManagerFactory {
    @Override
    public IFileManager createFileManager() {
        return new TextFileReader();
    }
}
