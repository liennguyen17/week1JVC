import com.example.week1jvc.MyUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class TestMyUtils {
    @Test
    public void testParseFloat(){
        String input = "12.9999";
        Float result = MyUtils.parseFloat(input);
        assertEquals(12.99f, result);
    }

    @Test
    public void testParseDate() throws ParseException {
        String input = "01/11/2023";
        Date expetectDate = new Date(LocalDate.of(2023, Month.NOVEMBER,1).toEpochDay());//trả về số ngày từ ngày 1/1/1970 đến ngày được cung cấp

        Date parseDate = MyUtils.parseDate(input, "dd/MM/yyyy");
        assertEquals(expetectDate, parseDate);
    }

    @Test
    public void testParseDate1() throws ParseException {
        String input = "01/11/2023";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date expectedDate = sdf.parse(input);

        Date parsedDate = MyUtils.parseDate(input, "dd/MM/yyyy");
        assertEquals(expectedDate, parsedDate);
    }


    @Test
    public void testGetName(){
        String name = "Nguyen Van An";
        Character alphabet = MyUtils.getLastNameCharacter(name);
        assertEquals('A', alphabet);
    }

    @Test
    public void testName(){
        String name = "Nguyen Thi Mai";
        Character alphabet = MyUtils.getFirstCharacterOfName(name);
        assertEquals('i', alphabet);
    }
}
