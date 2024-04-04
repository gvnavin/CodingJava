package dataholder;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataHolderTest {
    @Test
    public void testAllValues() {
        byte aByteValue = 127;
        short aShortValue = 32767;
        int anIntValue = 2147483647;
        long aLongValue = 9223372036854775807L;
        float aFloatValue = 3.14f;
        double aDoubleValue = Math.PI;
        boolean aBooleanValue = true;
        char aCharValue = 'A';
        String aStringValue = "Test String";
        int[] intArrayValue = {1, 2, 3};
        String[] stringArrayValue = {"apple", "banana", "cherry"};
        List<Integer> integerListValue = Collections.singletonList(5);

        DataHolder dataHolder = new DataHolder(aByteValue, aShortValue, anIntValue, aLongValue, aFloatValue, aDoubleValue, aBooleanValue, aCharValue, aStringValue, intArrayValue.clone(), stringArrayValue.clone(), integerListValue);

        // Asserting primitive types
        assertEquals(aByteValue, dataHolder.getByte());
        assertEquals(aShortValue, dataHolder.getShort());
        assertEquals(anIntValue, dataHolder.getInt());
        assertEquals(aLongValue, dataHolder.getLong());
        assertEquals(aFloatValue, dataHolder.getFloat(), 0.001); // Delta for float comparison
        assertEquals(aDoubleValue, dataHolder.getDouble(), 0.001); // Delta for double comparison
        assertTrue(dataHolder.isBoolean());
        assertEquals(aCharValue, dataHolder.getChar());

        // Asserting String
        assertEquals(aStringValue, dataHolder.getString());

        // Asserting arrays (using assertion methods for arrays)
        assertArrayEquals(intArrayValue, dataHolder.getIntArray());
        assertArrayEquals(stringArrayValue, dataHolder.getStringArray());

        // Asserting List (using assertions for collections)
        assertEquals(integerListValue, dataHolder.getIntegerList());
    }

}