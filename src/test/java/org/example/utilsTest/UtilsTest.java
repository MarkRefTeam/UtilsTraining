package org.example.utilsTest;

import org.example.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UtilsTest {

    @Test
    void testCapitalizeNormal() {
        String result = Utils.capitalize("mark");
        assertEquals("Mark", result);
    }

    @Test
    void testCapitalizeAlreadyCapitalized() {
        String result = Utils.capitalize("Márk");
        assertEquals("Márk", result);
    }

    @Test
    void testCapitalizeEmptyString() {
        String result = Utils.capitalize("");
        assertEquals("",result);
    }

    @Test
    void testCapitalizedNullPoint() {
        String result = Utils.capitalize(null);
        assertNull(result);
    }
}
