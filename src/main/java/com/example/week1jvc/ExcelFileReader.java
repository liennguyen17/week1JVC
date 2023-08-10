package com.example.week1jvc;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExcelFileReader implements IFileManager {
    @Override
    public Stream<String> readFile(String pathFile) throws IOException {
        List<String> data = new ArrayList<>();
//        boolean skipFirstRow = true;

        try (FileInputStream fileInputStream = new FileInputStream(pathFile);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                StringBuilder rowData = new StringBuilder();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.append(cell.getStringCellValue().trim());
                            break;
                        default:
//                            String cellValue = cell.toString().trim();
//                            if (cellValue.isEmpty()) {
//                                rowData.append("0"); // Nếu giá trị là rỗng, gán giá trị mặc định là 0
//                            } else if (cellValue.matches("[0-9]+(\\.[0-9]+)?")) {
//                                // Nếu giá trị là số hợp lệ, giữ nguyên giá trị
//                                rowData.append(cellValue);
//                            } else {
//                                // Nếu giá trị không hợp lệ, giữ nguyên giá trị chuỗi
//                                rowData.append(cellValue);
//                            }

                            rowData.append(cell.toString().trim());
                            break;
                    }
                    rowData.append(",");
                }
                rowData.deleteCharAt(rowData.length() - 1); // xoa dau phay cuoi cung
                data.add(rowData.toString());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return data.stream();
    }
}
