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
 * This class is used to give All-Du-Paths Coverage for the 
 * longesPrefixOf method, of the TST class.
 * 
 * All the Du Paths that exist are:
 * 
 * 1. Query[0,2,3] ✅
 * 2. Query[0,1] ✅
 * 3. Query[0,2,4,5,6] ✅
 * 4. Query[0,2,4,5,7,8,5,6] ✅
 * 5. Length[0,2,4,5,6] ✅
 * 6. Length[0,2,4,5,7,9,11,12,13,5,6] ✅
 * 7. C[0,2,4,5,7,9,10,5,6] ✅
 * 8. C[0,2,4,5,7,8,5,6] ✅
 * 9. C[0,2,4,5,7,9,11,13,5,6] ✅
 * 10. X[0,2,4,5,7,8,5,6] ✅
 * 11. X[0,2,4,5,6] ✅
 * 12. X[0,2,4,5,7,9,10,5,6] ✅
 * 13. X[0,2,4,5,7,9,11,13,5,6] ✅
 * 14. X[0,2,4,5,7,9,11,12,13,5,6] ✅
 * 15. X[0,2,4,5,7,8,5,7,8,5,6] ✅
 * 16. X[0,2,4,5,7,8,5,6] ✅
 * 17. X[0,2,4,5,7,8,5,7,9,10,5,6] ✅
 * 18. X[0,2,4,5,7,8,5,7,9,11,13,5,6] ✅
 * 19. X[0,2,4,5,7,8,5,7,9,11,12,13,5,6] ✅ 
 * 20. X[0,2,4,5,7,9,11,13,5,7,8,5,6] ✅
 * 21. X[0,2,4,5,7,9,11,13,5,6] ✅
 * 22. X[0,2,4,5,7,9,11,13,5,7,9,10,5,6] ✅
 * 23. X[0,2,4,5,7,9,11,13,5,7,9,11,13,5,6] ✅
 * 24. X[0,2,4,5,7,9,11,13,5,7,9,11,12,13,5,6] ✅
 * 25. I[0,2,4,5,7,8,5,6] ✅
 * 26. I[0,2,4,5,6] ✅
 * 27. I[0,2,4,5,7,9,11,13,5,6] ✅
 * 28. I[0,2,4,5,7,9,11,12,13,5,6] ✅
 * 29. I[0,2,4,5,7,9,11,13,5,7,8,5,6] ✅
 * 30. I[0,2,4,5,7,9,11,13,5,7,9,11,13,5,6] ✅
 * 31. Root[0,2,4,5,6] ✅
 *
 * Each test will specify the path as well as the Du Paths that is covering.
 */ 
public class TestAllDuPathsforlongestPrefixOf {

    /**
     * Du Path: [0,2,4,5,6] - 3,5,11,26,31.
     */
    @Test
    public void testWithNullRoot() {
        TST<Integer> st = new TST<>();

        assertEquals("", st.longestPrefixOf("test"));
    }

    /**
     * Du Path: [0,2,4,5,7,8,5,6] - 4,8,10,16,25.
     */
    @Test
    public void testWitImperfectMatchOneLeft() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        assertEquals("", st.longestPrefixOf("a"));
    }
    
    /**
     * Du Path: [0,2,4,5,7,9,10,5,6] - 7,12.
     */
    @Test
    public void testWitImperfectMatchAlwaysRight() {
        TST<Integer> st = new TST<>();
        st.put("b", 1);
        assertEquals("", st.longestPrefixOf("h"));
    }

    /**
     * Du Path: [0,2,4,5,7,9,11,12,13,5,6] - 6,14,28.
     */
    @Test
    public void testWithPerfectMatch() {
        TST<Integer> st = new TST<>();
        st.put("t", 1);

        assertEquals("t", st.longestPrefixOf("t"));
    }

    /**
     * Du Path: [0,2,4,5,7,9,11,13,5,6] - 9,13,21,27.
     */
    @Test
    public void testWitPerfectMatchWithNull() {
        TST<Integer> st = new TST<>();
        st.put("g", null);
        assertEquals("", st.longestPrefixOf("g"));
    }

    /**
     * Du Path: [0,2,4,5,7,9,11,13,5,7,8,5,6] -20,29.
     */
    @Test
    public void testWithPerfectMatchWithNullThenImPerfectMatchLeft() {
        TST<Integer> st = new TST<>();
        st.put("dd", 1);
        assertEquals("", st.longestPrefixOf("da"));
    }

    /**
     * Du Path: [0,2,4,5,7,9,11,13,5,7,9,11,13,5,6] - 23,30.
     */
    @Test
    public void testWithTwoPerfectMatchWithNull() {
        TST<Integer> st = new TST<>();
        st.put("dd", null);
        assertEquals("", st.longestPrefixOf("dd"));
    }

    /**
     * Du Path: [0,2,3] - 1.
     */
    @Test
    public void testWithEmptyQuery() {
        TST<Integer> st = new TST<>();

        assertNull(st.longestPrefixOf(""));
    }

    /**
     * Du Path: [0, 1] - 2.
     */
    @Test
    public void testWithNullQuery() {
        TST<Integer> st = new TST<>();

        assertThrows(IllegalArgumentException.class, () -> st.longestPrefixOf(null));
    }

    /**
     * Du Path: [0,2,4,5,7,8,5,7,8,5,6] - 15.
     */
    @Test
    public void testWitImperfectMatchAlwaysLeft() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("b", 2);
        assertEquals("", st.longestPrefixOf("a"));
    }

    /**
     * Du Path: [0,2,4,5,7,8,5,7,9,10,5,6] - 17.
     */
    @Test
    public void testWitImperfectMatchLeftThenRight() {
        TST<Integer> st = new TST<>();
        st.put("m", 1);
        st.put("d", 2);
        assertEquals("", st.longestPrefixOf("g"));
    }

    /**
     * Du Path: [0,2,4,5,7,8,5,7,9,11,13,5,6] - 18.
     */
    @Test
    public void testWithImPerfectMatchLeftThenPerfectMatchWithNull() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("a", null);
        assertEquals("", st.longestPrefixOf("a"));
    }

    /**
     * Du Path: [0,2,4,5,7,8,5,7,9,11,12,13,5,6] - 19.
     */
    @Test
    public void testWithImPerfectMatchLeftThenPerfectMatch() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("a", 2);
        assertEquals("a", st.longestPrefixOf("a"));
    }

    /**
     * Du Path: [0,2,4,5,7,9,11,13,5,7,9,10,5,6] - 22.
     */
    @Test
    public void testWithPerfectMatchWithNullThenImperfectMatchRigth() {
        TST<Integer> st = new TST<>();
        st.put("dd", 1);
        assertEquals("", st.longestPrefixOf("dg"));
    }

    /**
     * Du Path: [0,2,4,5,7,9,11,13,5,7,9,11,12,13,5,6] - 24.
     */
    @Test
    public void testWithTwoPerfectMatchFirstNullThenNotNull() {
        TST<Integer> st = new TST<>();
        st.put("dn", 1);
        assertEquals("dn", st.longestPrefixOf("dn"));
    }
}