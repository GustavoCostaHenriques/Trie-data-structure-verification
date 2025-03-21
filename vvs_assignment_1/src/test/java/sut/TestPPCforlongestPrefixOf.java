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
 * This class is used to give Prime Path Coverage for the 
 * longesPrefixOf method, of the TST class.
 * 
 * All the Prime Paths that exist are:
 * 
 * 1. [0,2,4,5,7,9,11,12,13] ✅
 * 2. [0,2,4,5,7,9,11,13] ✅ ✅ ✅ ✅
 * 3. [5,7,9,11,12,13,5] ✅ ✅ ✅ ✅
 * 4. [7,9,11,12,13,5,6] ✅ ✅ ✅ ✅
 * 5. [7,9,11,12,13,5,7] ❌
 * 6. [0,2,4,5,7,9,10] ✅ ✅ ✅ ✅
 * 7. [8,5,7,9,11,12,13] ✅
 * 8. [11,12,13,5,7,9,11] ❌
 * 9. [12,13,5,7,9,11,12] ❌
 * 10. [13,5,7,9,11,12,13] ✅
 * 11. [11,12,13,5,7,9,10] ❌
 * 12. [9,11,12,13,5,7,8] ❌
 * 13. [9,11,12,13,5,7,9] ❌
 * 14. [10,5,7,9,11,12,13] ✅
 * 15. [7,9,11,13,5,6] ✅ ✅ ✅
 * 16. [5,7,9,11,13,5] ✅ ✅ ✅ ✅ ✅ ✅
 * 17. [7,9,11,13,5,7] ✅ ✅ ✅ ✅
 * 18. [8,5,7,9,11,13] ✅
 * 19. [0,2,4,5,7,8] ✅ ✅ ✅ ✅
 * 20. [11,13,5,7,9,11] ✅ ✅
 * 21. [11,13,5,7,9,10] ✅
 * 22. [13,5,7,9,11,13] ✅
 * 23. [9,11,13,5,7,9] ✅ ✅ ✅
 * 24. [9,11,13,5,7,8] ✅
 * 25. [10,5,7,9,11,13] ✅
 * 26. [7,9,10,5,7] ✅ ✅ ✅ ✅
 * 27. [7,9,10,5,6] ✅ ✅ ✅
 * 28. [8,5,7,9,10] ✅
 * 29. [0,2,4,5,6] ✅
 * 30. [5,7,9,10,5] ✅ ✅ ✅ ✅ ✅ ✅
 * 31. [9,10,5,7,8] ✅
 * 32. [9,10,5,7,9] ✅ ✅ ✅
 * 33. [10,5,7,9,10] ✅
 * 34. [7,8,5,7] ✅ ✅ ✅ ✅
 * 35. [7,8,5,6] ✅ ✅ ✅
 * 36. [8,5,7,8] ✅ ✅
 * 37. [5,7,8,5] ✅ ✅ ✅ ✅ ✅ ✅
 * 38. [0,2,3] ✅
 * 39. [0,1] ✅
 * 
 * Note: The path [12,13,5,7] is infeasible!
 * Reason: If we start at 12 it means that we found a letter that matched
 *         and has no null value, wich means that it is the last letter of 
 *         that specific value. So that x only has a left or rigth value.
 *         With that, we conclude that x is going to turn into null (because
 *         of state 13), meaning that it will not enter the while loop again. 
 *         So it is impossible in this situation to go to the state 7, i.e the
 *         path [12,13,5,7] is infeasible.
 * 
 * 
 * Each test will specify the path as well as all the Prime Paths that is covering.
 */ 
public class TestPPCforlongestPrefixOf {

    /**
     * Test Path: [0,1]
     * Prime Paths: 39.
     */
    @Test
    public void testWithNullQuery() {
        TST<Integer> st = new TST<>();

        assertThrows(IllegalArgumentException.class, () -> st.longestPrefixOf(null));
    }

    /**
     * Test Path: [0,2,3]
     * Prime Paths: 38.
     */
    @Test
    public void testWithEmptyQuery() {
        TST<Integer> st = new TST<>();

        assertNull(st.longestPrefixOf(""));
    }

    /**
     * Test Path: [0,2,4,5,6]
     * Prime Paths: 29.
     */
    @Test
    public void testWithNullRoot() {
        TST<Integer> st = new TST<>();

        assertEquals("", st.longestPrefixOf("test"));
    }

    /**
     * Test Path: [0,2,4,5,7,9,11,12,13,5,6]
     * Prime Paths: 1,3,4.
     */
    @Test
    public void testWithPerfectMatch() {
        TST<Integer> st = new TST<>();
        st.put("t", 1);

        assertEquals("t", st.longestPrefixOf("t"));
    }

    /**
     * Test Path: [0,2,4,5,7,8,5,7,8,5,6]
     * Prime Paths: 19,34,35,36,37.
     */
    @Test
    public void testWitImperfectMatchAlwaysLeft() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("b", 2);
        assertEquals("", st.longestPrefixOf("a"));
    }

    /**
     * Test Path: [0,2,4,5,7,9,10,5,7,9,10,5,6]
     * Prime Paths: 6,26,27,30,32,33.
     */
    @Test
    public void testWitImperfectMatchAlwaysRight() {
        TST<Integer> st = new TST<>();
        st.put("b", 1);
        st.put("d", 2);
        assertEquals("", st.longestPrefixOf("h"));
    }

    /**
     * Test Path: [0,2,4,5,7,8,5,7,9,10,5,6]
     * Prime Paths: 19,27,28,30,34,37.
     */
    @Test
    public void testWitImperfectMatchLeftThenRight() {
        TST<Integer> st = new TST<>();
        st.put("m", 1);
        st.put("d", 2);
        assertEquals("", st.longestPrefixOf("g"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,9,10,5,7,8,5,6]
     * Prime Paths: 6,26,30,31,35,37.
     */
    @Test
    public void testWitImperfectMatchRightThenLeft() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("m", 2);
        assertEquals("", st.longestPrefixOf("g"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,9,10,5,7,9,11,13,5,6]
     * Prime Paths: 6,15,16,25,26,30,32.
     */
    @Test
    public void testWitImperfectMatchRightThenMatchWithNull() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("g", null);
        assertEquals("", st.longestPrefixOf("g"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,9,11,13,5,7,9,10,5,6]
     * Prime Paths: 2,16,17,21,23,27,30.
     */
    @Test
    public void testWithPerfectMatchWithNullThenImperfectMatchRigth() {
        TST<Integer> st = new TST<>();
        st.put("dd", 1);
        assertEquals("", st.longestPrefixOf("dg"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,9,11,13,5,7,9,11,13,5,6]
     * Prime Paths: 2,15,16,17,20,22,23.
     */
    @Test
    public void testWithTwoPerfectMatchWithNull() {
        TST<Integer> st = new TST<>();
        st.put("dd", null);
        assertEquals("", st.longestPrefixOf("dd"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,8,5,7,9,11,13,5,6]
     * Prime Paths: 15,16,18,19,34,37.
     */
    @Test
    public void testWithImPerfectMatchLeftThenPerfectMatchWithNull() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("a", null);
        assertEquals("", st.longestPrefixOf("a"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,9,11,13,5,7,8,5,6]
     * Prime Paths: 2,16,17,24,35,37.
     */
    @Test
    public void testWithPerfectMatchWithNullThenImPerfectMatchLeft() {
        TST<Integer> st = new TST<>();
        st.put("dd", 1);
        assertEquals("", st.longestPrefixOf("da"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,9,10,5,7,9,11,12,13,5,6]
     * Prime Paths: 3,4,6,14,26,30,32.
     */
    @Test
    public void testWithImPerfectMatchRigthThenPerfectMatch() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("g", 2);
        assertEquals("g", st.longestPrefixOf("g"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,9,11,13,5,7,9,11,12,13,5,6]
     * Prime Paths: 2,3,4,10,16,17,20,23.
     */
    @Test
    public void testWithTwoPerfectMatchFirstNullThenNotNull() {
        TST<Integer> st = new TST<>();
        st.put("dn", 1);
        assertEquals("dn", st.longestPrefixOf("dn"));
    }
    
    /**
     * Test Path: [0,2,4,5,7,8,5,7,9,11,12,13,5,6]
     * Prime Paths: 3,4,7,19,34,37.
     */
    @Test
    public void testWithImPerfectMatchLeftThenPerfectMatch() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);
        st.put("a", 2);
        assertEquals("a", st.longestPrefixOf("a"));
    }
}