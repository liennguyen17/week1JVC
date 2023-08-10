import com.example.week1jvc.TextFileReader;
import com.example.week1jvc.Student;
import com.example.week1jvc.StudentManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class TestStudentManager {
    public TestStudentManager() throws IOException {
    }

//    @Test
//    public void testInputData(){
//        String data = "Minh, 10.0, 2.2, 2.456, 19/03/2003, 10A2";
//        StudentManager studentManager = new StudentManager();
//        studentManager.readDataFromFile(data);
//        studentManager.showAllStudentInfo(studentManager.getStudents());
//    }

//    @Test
//    public void testReadFile() throws IOException {
//        String pathFile = "E:\\Documents\\LearnBe\\student.txt";
//        TextFileReader fileManager = new TextFileReader();
//        Stream<String> stream = fileManager.readFile(pathFile);
//        StudentManager studentManager = new StudentManager();
//
//        stream.forEach(studentManager::readDataFromFile);
//
//        studentManager.showAllStudentInfo(studentManager.getStudents());
//
//        System.out.println("Sort---------------");
//        studentManager.sortStudent();
//        studentManager.showAllStudentInfo(studentManager.getStudents());
//
//        System.out.println("findDuplicateStudent---------------");
//        List<Student> dupStudents  = studentManager.findDuplicateStudent();
//        studentManager.showAllStudentInfo(dupStudents);
//    }


}
