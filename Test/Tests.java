import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

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
    void TestHex(){
        assertEquals(11, Integer.decode("0xB"));
    }

    @Test
    void TestNegativeHex(){
        assertEquals(-11, Integer.decode("-0xB"));
    }

    @Test
    void TestNegativeHashtagHex(){
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
    void TestSystems(){
        Assertions.assertNotEquals(Integer.decode("012"), Integer.decode("12"));
    }

    @Test
    void TestCatchMinValue(){
        assertEquals(Optional.of(Integer.MIN_VALUE), Optional.of(Integer.decode("-2147483648")));
    }

    @Test
    void TestCatchMaxValue(){
        assertEquals(Optional.of(Integer.MAX_VALUE), Optional.of(Integer.decode("2147483647")));
    }
}
