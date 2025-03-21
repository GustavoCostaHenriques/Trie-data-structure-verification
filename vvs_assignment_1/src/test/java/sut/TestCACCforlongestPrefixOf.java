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
 * 
 * Predicates:
 * P1: query == null
 * P2: query.length() == 0
 * P3: x != null && i < query.length()
 * P4: c < x.c
 * P5: c > x.c
 * P6: x.val != null
 * 
 * Clauses:
 * a: query == null
 * b: query.length() == 0
 * c: x != null
 * d: i < query.length()
 * e: c < x.c
 * f: c > x.c
 * g: x.val != null
 * 
 * Determination Predicates:
 * d(a) = true
 * d(b) = true
 * d(c) = d
 * d(d) = c
 * d(e) = true
 * d(f) = true
 * d(g) = true
 */

/** 
 * This class is used to give Correlated Active Clause
 * Coverage for the longesPrefixOf method, of the TST class.
 * 
 * Reason for CACC: Since we have a while loop inside the method, it is important to
 *                  cover diferent clauses and not just predicates. With this we conclude
 *                  that PC or GACC would not be reasonable. Furthermore, instead of CC, 
 *                  CACC was chosen in order to test each clause under circumstances where 
 *                  the clause determines the predicate. This ensures that each clause is 
 *                  tested in various scenarios where it contributes to the decision-making 
 *                  process of the method, offering a more thorough and meaningful evaluation 
 *                  of the method’s behavior across multiple execution paths. 
 * 
 * TR(CAAC): {a⋀p1, ¬a⋀¬p1, b⋀p2, ¬b⋀¬p2, c⋀d⋀p3, ¬c⋀d⋀¬p3, ¬d⋀c⋀¬p3, e⋀p4, 
 *            ¬e⋀¬p4, f⋀p5, ¬f⋀¬p5, g⋀p6, ¬g⋀¬p6}
 * 
 * 
 * Each test will specify the path as well as what it statisfies in TR(CACC).
 */ 
public class TestCACCforlongestPrefixOf {

    /**
     * Test Path: [0, 1].
     * Satisfies: a⋀p1.
     */
    @Test
    public void testWithNullQuery() {
        TST<Integer> st = new TST<>();

        assertThrows(IllegalArgumentException.class, () -> st.longestPrefixOf(null));
    }

    /**
     * Test Path: [0,2,3].
     * Satisfies: ¬a⋀¬p1, b⋀p2.
     */
    @Test
    public void testWithEmptyQuery() {
        TST<Integer> st = new TST<>();

        assertNull(st.longestPrefixOf(""));
    }

    /**
     * Test Path: [0,2,4,5,7,9,11,12,13,5,6].
     * Satisfies: ¬a⋀¬p1, ¬b⋀¬p2, c⋀d⋀p3, ¬c⋀d⋀¬p3, ¬e⋀¬p4, ¬f⋀¬p5, g⋀p6.
     */
    @Test
    public void testWithPerfectMatch() {
        TST<Integer> st = new TST<>();
        st.put("t", 1);

        assertEquals("t", st.longestPrefixOf("tt"));
    }

    /**
     * Test Path: [0,2,4,5,7,8,5,6].
     * Satisfies: ¬a⋀¬p1, ¬b⋀¬p2, c⋀d⋀p3, ¬c⋀d⋀¬p3, e⋀p4.
     */
    @Test
    public void testWithImperfectMatchAlwaysLeft() {
        TST<Integer> st = new TST<>();
        st.put("d", 1);

        assertEquals("", st.longestPrefixOf("a"));
    }

    /**
     * Test Path: [0,2,4,5,7,9,10,5,6]
     * Prime Paths: ¬a⋀¬p1, ¬b⋀¬p2, c⋀d⋀p3, ¬c⋀d⋀¬p3, ¬e⋀¬p4, f⋀p5.
     */
    @Test
    public void testWitImperfectMatchAlwaysRight() {
        TST<Integer> st = new TST<>();
        st.put("b", 1);
        assertEquals("", st.longestPrefixOf("h"));
    }

    /**
     * Test Path: [0,2,4,5,7,9,11,13,5,6]
     * Prime Paths: ¬a⋀¬p1, ¬b⋀¬p2, c⋀d⋀p3, ¬c⋀d⋀¬p3, ¬e⋀¬p4, ¬f⋀¬p5, ¬g⋀¬p6.
     */
    @Test
    public void testWithPerfectMatchWithNull() {
        TST<Integer> st = new TST<>();
        st.put("b", null);
        assertEquals("", st.longestPrefixOf("bb"));
    }

    /**
     * Test Path: [0,2,4,5,7,9,11,12,13,5,6]
     * Prime Paths: ¬a⋀¬p1, ¬b⋀¬p2, c⋀d⋀p3, ¬d⋀c⋀¬p3, ¬e⋀¬p4, ¬f⋀¬p5, g⋀p6.
     */
    @Test
    public void testWithPerfectMatchAndQueryTooSmall() {
        TST<Integer> st = new TST<>();
        st.put("bb", 1);
        assertEquals("", st.longestPrefixOf("b"));
    }
}