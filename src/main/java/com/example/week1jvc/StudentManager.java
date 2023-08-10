package com.example.week1jvc;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

@Getter
@Setter
public class StudentManager {
    private IFileManager fileManager;
    private List<Student> students = new ArrayList<>();


    public StudentManager(IFileManagerFactory fileManagerFactory) {
        this.fileManager = fileManagerFactory.createFileManager();
    }

    public void readDataFromFile(String filePath) throws IOException {
        Stream<String> studentData = fileManager.readFile(filePath);
        studentData.forEach(this::processStudentData);
    }

    public void processStudentData(String studentStr) {
        if (!studentStr.isEmpty()) {
            try {
                String[] infoList = studentStr.strip().split(",");
                if (infoList.length != 7) {
                    throw new RuntimeException("Đinh dạng thông tin của 1 học sinh không đúng !");
                }
                String fullname = infoList[0].strip();
                float mathScore = MyUtils.parseFloat(infoList[1].strip());
                float englishScore = MyUtils.parseFloat(infoList[2].strip());
                float literatureScore = MyUtils.parseFloat(infoList[3].strip());
                Date dob = MyUtils.parseDate(infoList[4].strip(), "dd/MM/yyyy"); //cần bỏ khoảng trắng bằng trim()
                String className = infoList[5].strip();
//                int studentType = Integer.parseInt(infoList[6].strip());
                int studentType = MyUtils.parseInt(infoList[6].strip());

                Student student = Student.builder().fullName(fullname)
                        .className(className)
                        .mathScore(mathScore)
                        .englishScore(englishScore)
                        .literatureScore(literatureScore)
                        .dob(dob)
                        .className(className)
                        .studentType(studentType)
                        .build();

                student.validateInformation();

                student.calculateAge();
                ;
                student.calculateAverageScore();
                students.add(student);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void showAllStudentInfo(List<Student> students) {
        students.forEach(student -> {
            String info = String.format("Tên: %s, Toán: %.2f, Văn: %.2f, Anh: %.2f, ĐTB: %.2f, Ngày sinh: %s, Tuổi: %d, Lớp: %s, Học sinh chuyên: %d",
                    student.getFullName(),
                    student.getMathScore(),
                    student.getLiteratureScore(),
                    student.getEnglishScore(),
                    student.getAverageScore(),
                    MyUtils.parseDatetoString(student.getDob(), "dd-MM-YYYY"),
                    student.getAge(),
                    student.getClassName(),
                    student.getStudentType()
            );
            System.out.println(info);
        });
    }

    public void sortStudent() {
        Collections.sort(students);
    }

//    public List<Student> findDuplicateStudent(){
//        List<Student> duplicate = new ArrayList<>();
//        students.forEach(student -> {
//            List<Student> filter = students.stream().filter(student1 -> student1.equals(student)).collect(Collectors.toList());
//            if(!filter.isEmpty()){
//                duplicate.addAll(filter);
//            }
//        });
//        return duplicate;
//    }

    public List<Student> findDuplicateStudent() {
        List<Student> duplicate = new ArrayList<>();
        Set<Student> visited = new HashSet<>(); // Dùng để kiểm tra học sinh đã được xét trùng hay chưa

        for (Student student : students) {
            if (!visited.contains(student)) {
                List<Student> filter = students.stream()
                        .filter(s -> !visited.contains(s) && student.equals(s))
                        .toList();
                if (filter.size() > 1) {
                    duplicate.addAll(filter);
                }
                visited.addAll(filter); // Đánh dấu các học sinh đã được xét trùng
            }
        }
        return duplicate;
    }

    public List<Student> getStudent() {
        return students;
    }

    public void sortStudentsMathAndLiterature() {
        // Sắp xếp danh sách học sinh
        Collections.sort(students);

        // Kiểm tra và sắp xếp lại danh sách học sinh lớp chuyên toán và lớp chuyên văn
        List<Student> mathStudents = students.stream()
                .filter(student -> student.getStudentType() == 2)
                .sorted(Comparator.comparing(Student::getMathScore).reversed())
                .toList();

        List<Student> LiteratureStudents = students.stream()
                .filter(student -> student.getStudentType() == 3)
                .sorted(Comparator.comparing(Student::getLiteratureScore).reversed())
                .toList();

        students.clear();
        students.addAll(mathStudents);
        students.addAll(LiteratureStudents);
    }

}
