package com.example.week1jvc;

//Factory cụ thể cho đọc file Excel
public class ExcelFileManagerFactory implements IFileManagerFactory {
    @Override
    public IFileManager createFileManager() {
        return new ExcelFileReader();
    }
}
