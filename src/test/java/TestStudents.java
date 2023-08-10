import com.example.week1jvc.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter
@Setter
@Builder
@ToString
public class TestStudents {
    @Test
    public void testCompareStudent(){
        Student student1 = Student.builder()
                .fullName("minh")
                .className("B")
                .literatureScore(10)
                .englishScore(10)
                .mathScore(10)
                .dob(new Date())
                .age(10)
                .averageScore(10)
                .build();
        Student student2 = Student.builder()
                .fullName("namh")
                .className("A")
                .literatureScore(10)
                .englishScore(10)
                .mathScore(10)
                .dob(new Date())
                .age(10)
                .averageScore(10)
                .build();

        assertEquals(student1.equals(student2), true);

    }
}
