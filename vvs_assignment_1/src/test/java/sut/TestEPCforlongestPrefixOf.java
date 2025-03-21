package sut;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Software Verification and Validation
 * 
 * Master of Science in Computer Engineering
 * University of Lisbon
 * Faculty of Sciences
 * Department of Informatics
 * 
 * @author Gustavo Henriques
 */

/**
 * Graph Construction for longestPrefixOf:
 * 
 * Edges:
 * 0 1
 * 0 2
 * 2 3
 * 2 4
 * 4 5
 * 5 6
 * 5 7
 * 7 8 
 * 7 9
 * 8 5
 * 9 10
 * 9 11
 * 10 5
 * 11 12
 * 11 13
 * 12 13
 * 13 5
 * 
 * Initial Nodes:
 * 0
 * 
 * Final Nodes:
 * 1 3 6
 *
  * defs:
 * query 0
 * length 4 12
 * x 4 8 13
 * i 4 11
 * root 0
 * 
 * uses:
 * query 0,1 0,2 2,3 2,4 5,6 5,7 6 7 
 * length 6
 * x 5,6 5,7 7,8 7,9 8 9,10 9,11 10 11,12 11,13 13
 * i 5,6 5,7 7 11 12
 * root 4 
 */

/** 
 * This class is used to give Edge-Pair Coverage for the 
 * longesPrefixOf method, of the TST class.
 * 
 * All the Edge-Pairs that exist are:
 * 
 * 1. [0,1] ✅
 * 2. [0,2,3] ✅
 * 3. [0,2,4] ✅ ✅ ✅ ✅
 * 4. [2,4,5] ✅ ✅ ✅ ✅
 * 5. [4,5,6] ✅
 * 6. [4,5,7] ✅ ✅ ✅
 * 7. [5,7,8] ✅
 * 8. [5,7,9] ✅ ✅ ✅
 * 9. [7,8,5] ✅
 * 10. [7,9,10] ✅
 * 11. [7,9,11] ✅ ✅
 * 12. [8,5,6] ✅
 * 13. [8,5,7] ✅
 * 14. [9,10,5] ✅
 * 15. [9,11,12] ✅
 * 16. [9,11,13] ✅
 * 17. [10,5,6] ✅
 * 18. [10,5,7] ✅
 * 19. [11,12,13] ✅
 * 20. [11,13,5] ✅
 * 21. [12,13,5] ✅
 * 22. [13,5,6] ✅
 * 23. [13,5,7] ✅
 * 
 * Each test will specify the path as well as all the Edge-Pairs that is covering.
 */ 
public class TestEPCforlongestPrefixOf {

    /**
     * Test Path: [0,1]
     * Edge-Pairs: 1.
     */
    @Test
    public void testWithNullQuery() {
        TST<Integer> st = new TST<>();

        assertThrows(IllegalArgumentException.class, () -> st.longestPrefixOf(null));
    }

    /**
     * Test Path: [0,2,3]
     * Edge-Pairs: 2.
     */
    @Test
    public void testWithEmptyQuery() {
        TST<Integer> st = new TST<>();

        assertNull(st.longestPrefixOf(""));
    }

    /**
     * Test Path: [0,2,4,5,6]
     * Edge-Pairs: 3,4,5.
     */
    @Test
    public void testWithNullRoot() {
        TST<Integer> st = new TST<>();

        assertEquals("", st.longestPrefixOf("test"));
    }

    /**
     * Test Path: [0,2,4,5,7,9,11,12,13,5,6]
     * Edge-Pairs: 3,4,6,8,11,15,19,21,22.
     */
    @Test
    public void testWithPerfectMatch() {
        TST<Integer> st = new TST<>();
        st.put("t", 1);

        assertEquals("t", st.longestPrefixOf("t"));
    }

    /**
     * Test Path: [0,2,4,5,7,9,10,5,7,9,10,5,6]
     * Edge-Pairs: 3,4,6,8,10,14,17,18.
     */
    @Test
    public void testWitImperfectMatchAlwaysRight() {
        TST<Integer> st = new TST<>();
        st.put("b", 1);
        st.put("d", 2);
        assertEquals("", st.longestPrefixOf("h"));
    }

    /**
     * Test Path: [0,2,4,5,7,8,5,7,9,11,13,5,7,8,5,6]
     * Edge-Pairs: 3,4,6,7,8,9,11,12,13,16,20,23.
     */
    @Test
    public void testWitTowImperfectMatchAlwaysLeftAndOneMatchWithNullValue() {
        TST<Integer> st = new TST<>();
        st.put("m", 1);
        st.put("hn", 2);

        assertEquals("", st.longestPrefixOf("hh"));
    }
}