import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Tests {

    @Test
    public void TestZero()
    {
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    void TestMinus(){
        assertEquals(-1, Integer.decode("-1"));
    }

    @Test
    void TestPlus(){
        assertEquals(1, Integer.decode("+1"));
    }

    @Test
    void TestZeroes(){
        assertEquals(0, Integer.decode("00000"));
    }

    @Test
    void TestHex1(){
        assertEquals(11, Integer.decode("0xB"));
    }

    @Test
    void TestHex2(){
        assertEquals(-11, Integer.decode("-0xB"));
    }

    @Test
    void TestHex3(){
        assertEquals(-17, Integer.decode("-#11"));
    }

    @Test
    void TestStartsWithZero(){
        Assertions.assertNotEquals(12, Integer.decode("012"));
    }

    @Test
    void TestOcta(){
        Assertions.assertEquals(10, Integer.decode("012"));
    }

    @Test
    void TestSame(){
        Assertions.assertSame(10, Integer.decode("012"));
    }

    @Test
    void TestTrue(){
        Assertions.assertNotEquals(Integer.decode("012"), Integer.decode("12"));
    }
}
