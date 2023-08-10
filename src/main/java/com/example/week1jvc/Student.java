package com.example.week1jvc;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@Builder
@ToString
public class Student implements Comparable<Student> {
    private String fullName;
    private float mathScore = 0;
    private float englishScore = 0;
    private float literatureScore = 0;
    private String className;
    private Date dob;

    private int studentType;
    private float averageScore = 0;
    private int age;

    public void calculateAverageScore() {
        this.averageScore = Math.round((englishScore + literatureScore + mathScore) / 3);
    }

    public void calculateAge() {
        age = new Date().getYear() - dob.getYear();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student compareStudent = (Student) obj;
        return Float.compare(compareStudent.getMathScore(), this.mathScore) == 0
                && compareStudent.getClassName().equalsIgnoreCase(this.className)
                && !compareStudent.getFullName().equalsIgnoreCase(this.fullName);
    }


    //so sanh cung lop va cung diem trung binh
//    @Override
//    public boolean equals(Object obj) {
//        Student compareStudent = (Student) obj;
//        return compareStudent.getAverageScore() == this.averageScore
//                && compareStudent.getClassName().equalsIgnoreCase(this.className)
//                && !compareStudent.getFullName().equalsIgnoreCase(this.fullName);
//    }


    //so sanh cung lop va cung diem toan
//    @Override
//    public boolean equals(Object obj) {
//        Student compareStudent = (Student) obj;
//        return compareStudent.getMathScore() == this.mathScore
//                && compareStudent.getClassName().equalsIgnoreCase(this.className)
//                && !compareStudent.getFullName().equalsIgnoreCase(this.fullName);
//    }


//    @Override
//    public int compareTo(Student o) {
//        int score1 = MyUtils.getLastNameCharacter(this.fullName).compareTo(MyUtils.getLastNameCharacter(o.getFullName()));
//        int score2 = this.averageScore > o.getAverageScore() ? -1 : 1;//1 -= asc, -1 = desc
//        return score1 + score2;
//    }

    @Override
    public int compareTo(Student o) {
        int score1 = MyUtils.getFirstCharacterOfName(this.fullName).compareTo(MyUtils.getFirstCharacterOfName(o.getFullName()));
        int score2 = this.averageScore > o.getAverageScore() ? -1 : 1;//1 -= asc, -1 = desc
        return score1 + score2;
    }

    public void validateInformation() {
        this.checkScore(mathScore);
        this.checkScore(englishScore);
        this.checkScore(literatureScore);
        this.checkUserName(fullName);
        this.checkMathScore(mathScore, studentType);
        this.checkLiteratureScore(literatureScore, studentType);
    }

    private void checkScore(float score) {
        if (score < 0 || score > 10)
            throw new RuntimeException("Điểm nhập vào không hợp lệ");
    }

    public void checkMathScore(float mathScore, int studentType) {
        if (studentType == 2 && mathScore <= 7) {
            throw new RuntimeException("Điểm toán của học sinh chuyên toán phải lớn hơn 7!");
        }
    }

    public void checkLiteratureScore(float literatureScore, int studentType) {
        if (studentType == 3 && literatureScore <= 7) {
            throw new RuntimeException("Điểm văn của học sinh chuyên văn phải lớn hơn 7!");
        }
    }

    private void checkUserName(String userName) {
//        String regex = "^[^<>{}\\\\\\\"|;:.,~!?@#$%^=&*\\\\\\\\)(]*$";  //da bo ngoặc kép
//        String regex = "^[a-zA-Z]+$";

        String regex = "^[\\\\p{L}\\\\s]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userName);
        if (matcher.matches())
            throw new RuntimeException("Tên học sinh không được chứa kí tự đặc biệt !");
    }
}
