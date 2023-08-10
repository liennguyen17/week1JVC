package com.example.week1jvc;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) throws IOException {
        //        String pathFile = "E:\\Documents\\LearnBe\\student.txt";
        //        String pathFile = "E:\\Documents\\LearnBe\\student.xlsx";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đường dẫn đến file: ");
        String pathFile = scanner.nextLine();

        //Kiểm tra đuôi file để xác định đọc từ file .txt hay .xlxs
        if (pathFile.endsWith(".txt")) {
            //Đọc từ file .txt
            IFileManagerFactory fileManagerFactory = new TextFileManagerFactory();
            StudentManager studentManager = new StudentManager(fileManagerFactory);
            studentManager.readDataFromFile(pathFile);

            displayMenu(studentManager);
        } else if (pathFile.endsWith(".xlsx")) {
            //Đọc từ file .xlsx
            IFileManagerFactory fileManagerFactory = new ExcelFileManagerFactory();
            StudentManager studentManager = new StudentManager(fileManagerFactory);
            studentManager.readDataFromFile(pathFile);

            displayMenu(studentManager);
        } else {
            System.out.println("Định dạng file không hợp lệ. Hãy nhập đúng đường dẫn file .txt hoặc .xlsx!");
        }

        scanner.close();


    }


    public static void displayMenu(StudentManager studentManager) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu: ");
            System.out.println("1. In ra danh sách thông tin tất cả các học sinh!");
            System.out.println("2. In ra danh sách thông tin các học sinh theo chữ cái tăng dần(A->Z) và điểm trung bình giảm dần!");
            System.out.println("3. In ra danh sách thông tin các học sinh cùng lớp và cùng điểm số toán!");
            System.out.println("4. Sắp xếp học sinh chuyên toán theo điểm toán giảm dần, học sinh chuyên văn theo điểm văn giảm dần!");
            System.out.println("0. Thoát chương trình!");
            System.out.println("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("    1-Danh sách thông tin tất cả các học sinh:");
                    studentManager.showAllStudentInfo(studentManager.getStudents());
                    break;
                case 2:
                    System.out.println("    2-Danh sách thông tin các học sinh theo chữ cái tăng dần(A->Z) và điểm trung bình giảm dần:");
                    studentManager.sortStudent();
                    studentManager.sortStudent();
                    studentManager.showAllStudentInfo(studentManager.getStudent());
                    break;
                case 3:
                    System.out.println("    3-Danh sách thông tin các học sinh cùng lớp và cùng điểm số toán:");
                    List<Student> duplicatesStudents = studentManager.findDuplicateStudent();
                    studentManager.showAllStudentInfo(duplicatesStudents);
                    break;
                case 4:
                    System.out.println("    4-Học sinh chuyên toán theo điểm toán giảm dần, học sinh chuyên văn theo điểm văn giảm dần:");
                    studentManager.sortStudentsMathAndLiterature();
                    studentManager.showAllStudentInfo(studentManager.getStudents());
                    break;
                case 0:
                    System.out.println("        Chương trình đã thoát.");
                    break;
                default:
                    System.out.println("        Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (choice != 0);
        scanner.close();
    }


    // thực hiện luôn chương trình

//        String pathFile = "E:\\Documents\\LearnBe\\student.txt";
////        String pathFile = "E:\\Documents\\LearnBe\\student.xlsx";
//
////        IFileManagerFactory fileManagerFactory = new ExcelFileManagerFactory();
//        IFileManagerFactory fileManagerFactory = new TextFileManagerFactory();
//        StudentManager studentManager = new StudentManager(fileManagerFactory);
//
//        studentManager.readDataFromFile(pathFile);
//
//        studentManager.showAllStudentInfo(studentManager.getStudents());
//
//        System.out.println("Sort---");
//        studentManager.sortStudent();
//        studentManager.showAllStudentInfo(studentManager.getStudent());
//
//        System.out.println("Find student----");
//        List<Student> dupStudents = studentManager.findDuplicateStudent();
//        studentManager.showAllStudentInfo(dupStudents);
//
//        System.out.println("Sắp xếp học sinh chuyên toán và chuyên văn:");
//        studentManager.sortStudentsMathAndLiterature();
//        studentManager.showAllStudentInfo(studentManager.getStudent());

    //tạo menu


    //    public static void processStudentData(StudentManager studentManager, String filePath) throws IOException {
//        IFileManagerFactory fileManagerFactory;
//        if(filePath.endsWith(".txt")){
//            fileManagerFactory = new TextFileManagerFactory();
//        }else if(filePath.endsWith(".xls") || filePath.endsWith(".xlsx")){
//            fileManagerFactory = new ExcelFileManagerFactory();
//        }else {
//            System.out.println("File không hỗ trợ, vui lòng chọn lại!");
//            return;
//        }
//
//        studentManager.setFileManager(fileManagerFactory.createFileManager());
//        studentManager.readDataFromFile(filePath);
//    }


}
