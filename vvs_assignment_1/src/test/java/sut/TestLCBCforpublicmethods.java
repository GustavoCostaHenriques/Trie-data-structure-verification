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

// This class is used to give line and branch coverage for all the public methods, of the TST class
public class TestLCBCforpublicmethods {

    /**
     * Lines and Branches of size method:
     * 
     * public int size() {
     *       return n; // L1
     * }
     */

    // This test method is used to give line and branch coverage for the size() method
    @Test
    public void testSize() {
        TST<Integer> st = new TST<>();

        // Test for the case where the size is 0 covers L1 (there are no branches)
        assertEquals(0, st.size());
    }

    /**
     * Lines and Branches of contains method:
     * 
     * public boolean contains(String key) {
     *       if (key == null) // L1 - B1
     *          throw new IllegalArgumentException("calls contains() with null argument"); // L2
     *       return get(key) != null; // L3 - B2
     * }
     */

    // This test method is used to give line and branch coverage for the contains() method
    @Test
    public void testContains() {
        TST<Integer> st = new TST<>();

        // Test for the case where the key is not null and doesn't exists covers L1, L3, !B1 and !B2
        assertFalse(st.contains("something"));

        // Test for the case where the key is null covers L1 L2 and B1
        assertThrows(IllegalArgumentException.class, () -> st.contains(null));

        // Test for the case where the key is not null and exists covers L1, L3, !B1 and B2
        st.put("something", 1);
        assertTrue(st.contains("something"));
    }

    /**
     * Lines and Branches of get method:
     * 
     * public T get(String key) {
     *      if (key == null) // L1 - B1
     *          throw new IllegalArgumentException("calls get() with null argument"); // L2
     *      if (key.length() == 0) // L3 - B2
     *          throw new IllegalArgumentException("key must have length >= 1"); // L4
     *      Node<T> x = get(root, key, 0); // L5
     *      if (x == null) // L6 - B3
     *          return null; // L7
     *      return x.val; // L8
     * } 
     */  

    // This test method is used to give line and branch coverage for the get() method
    @Test
    public void testGet() {
        TST<Integer> st = new TST<>();

        // Test for the case where the key is null covers L1, L2 and B1
        assertThrows(IllegalArgumentException.class, () -> st.get(null));

        // Test for the case where the is not null and has length 0 covers L1, L3, L4, !B1 and B2
        assertThrows(IllegalArgumentException.class, () -> st.get(""));

        // Test for the case where the key is not null and doesn't exists covers L1, L3, L5, L6, L7, !B1, !B2 and B3
        assertNull(st.get("something"));

        // Test for the case where the key is not null and exists covers L1, L3, L5, L6, L8, !B1, !B2 and !B3
        st.put("something", 1);
        assertEquals(Integer.valueOf(1), st.get("something"));
    }

    /**
     * Lines and Branches of put method:
     * 
     * public void put(String key, T val) {
     *      if (key == null) // L1 - B1
     *         throw new IllegalArgumentException("calls put() with null key"); // L2
     *      if (!contains(key)) // L3 - B2
     *         n++; // L4
     *      root = put(root, key, val, 0); // L5
     * }
     */

    // This test method is used to give line and branch coverage for the put() method
    @Test
    public void testPut() {

        TST<Integer> st = new TST<>();

        // Test for the case where the key is null covers L1, L2 and B1
        assertThrows(IllegalArgumentException.class, () -> st.put(null, 1));

        // Test for the case where the key is not null and doesn't exists covers L1, L3, L4, !B1 and B2
        int previousN = st.size();
        st.put("something", 1);
        assertEquals(previousN + 1, st.size());

        // Test for the case where the key is not null and exists covers L1, L3, L5, !B1, and !B2
        st.put("something", 1);
        assertEquals(Integer.valueOf(1), st.get("something"));
    }

    /**
     * Lines and Branches of longestPrefixOf method:
     * 
     * public String longestPrefixOf(String query) {
     *      if (query == null) // L1 - B1
     *         throw new IllegalArgumentException("calls longestPrefixOf() with null argument"); // L2
     *      if (query.length() == 0) // L3 - B2
     *         return null; // L4
     *      int length = 0; // L5
     *      Node<T> x = root; // L6
     *      int i = 0; // L7
     *      while (x != null && i < query.length()) { // L8 - B3(x = null && i < query.length()) - B4(x != null && i < query.length()) 
     *         char c = query.charAt(i); // L9
     *         if      (c < x.c) x = x.left; // L10 - L11 - B5
     *         else if (c > x.c) x = x.right; // L12 - L13 - B6
     *         else {
     *            i++; // L14
     *            if (x.val != null) // L15 - B7
     *              length = i; // L16
     *            x = x.mid; // L17
     *         }
     *      }
     *      return query.substring(0, length); // L18
     * }
     */

    // This test method is used to give line and branch coverage for the longestPrefixOf() method
    @Test
    public void testLongestPrefixOf() {
        TST<Integer> st = new TST<>();

        // Test for the case where the query is null covers L1, L2 and B1
        assertThrows(IllegalArgumentException.class, () -> st.longestPrefixOf(null));

        // Test for the case where the query is not null and has length 0 covers L1, L3, L4, !B1 and B2
        assertNull(st.longestPrefixOf(""));

        // Test for the case where the query is not null and doesn't exists covers L1, L3, L5, L6, L7, L8, 
        // L18 !B1, !B2 and B3
        assertEquals("", st.longestPrefixOf("something"));

        // Tests for the case where the query is not null and exists covers L1, L3, L5, L6, L7, L8, L9, L10,
        // L12, L14, L15, L16, L17, L18, !B1, !B2, !B3, B4, !B5, B5, B6, !B6, B7 and !B7
        st.put("something", 1); 
        st.put("what", 2);
        st.put("another", 3);
        assertEquals("", st.longestPrefixOf("some"));
        assertEquals("another", st.longestPrefixOf("anotherone")); 
        assertEquals("what", st.longestPrefixOf("whatelse"));  

    }

    /**
     * Lines and Branches of keys method:
     * 
     * public Iterable<String> keys() {
     *      Queue<String> queue = new LinkedList<>(); // L1
     *      collect(root, new StringBuilder(), queue); // L2
     *      return queue; // L3
     * }
     */

    // This test method is used to give line and branch coverage for the keys() method
    @Test
    public void testKeys() {
        TST<Integer> st = new TST<>();
        Queue<String> queue = new LinkedList<>();

        // Test for the case where the root is empty covers L1, L2 and L3 (there are no branches)
        assertEquals(queue, st.keys());

        // Test for the case where the root is not empty. Note: It gives the same coverage as before!
        queue.add("another");
        st.put("another", 3);
        assertEquals(queue, st.keys());
    }

    /**
     * Lines and Branches of keysWithPrefix method:
     * 
     * public Iterable<String> keysWithPrefix(String prefix) {
     *      if (prefix == null) // L1 - B1
     *          throw new IllegalArgumentException("calls keysWithPrefix() with null argument"); // L2
     *      Queue<String> queue = new LinkedList<>(); // L3
     *      Node<T> x = get(root, prefix, 0); // L4
     *       if (x == null) // L5 - B2
     *          return queue; // L6
     *      if (x.val != null) // L7 - B3
     *         queue.add(prefix); // L8
     *      collect(x.mid, new StringBuilder(prefix), queue); // L9
     *      return queue; // L10
     * }
     */

    // This test method is used to give line and branch coverage for the keysWithPrefix() method
    @Test
    public void testKeysWithPrefix() {
        TST<Integer> st = new TST<>();
        Queue<String> queue = new LinkedList<>();

        // Test for the case where the prefix is null covers L1, L2 and B1
        assertThrows(IllegalArgumentException.class, () -> st.keysWithPrefix(null));

        // Test for the case where the prefix exists but the root is null covers L1, L3, L4, L5, L6, !B1 and B2
        assertEquals(queue, st.keysWithPrefix("test"));

        // Test for the case where the prefix and root exists but the x.val is null covers L1, L3, L4, L5, L7, L9, L10, !B1, 
        // !B2 and !B3
        st.put("testWithNoValue", null);
        assertEquals(queue, st.keysWithPrefix("testWithNoValue"));

        // Test for the case where the prefix, x.val and root exists covers L1, L3, L4, L5, L7, L8, L9, L10, !B1, !B2 and B3
        st.put("testWithValue", 1);
        queue.add("testWithValue");
        assertEquals(queue, st.keysWithPrefix("testWithValue"));
    }

    /**
     * Lines and Branches of keysThatMatch method:
     * 
     * public Iterable<String> keysThatMatch(String pattern) {
     *      Queue<String> queue = new LinkedList<>(); // L1
     *      collect(root, new StringBuilder(), 0, pattern, queue); // L2
     *      return queue; // L3
     * }
     */

    // This test method is used to give line and branch coverage for the keysThatMatch() method
    @Test
    public void testKeysThatMatch() {
        TST<Integer> st = new TST<>();
        Queue<String> queue = new LinkedList<>();

        // Test for the case where the root is empty covers L1, L2 and L3 (there are no branches)
        assertEquals(queue, st.keysThatMatch("rootEmpty"));

        // Test for the case where the root is not empty. Note: It gives the same coverage as before!
        queue.add("rootFilled");
        st.put("rootFilled", 3);
        assertEquals(queue, st.keysThatMatch("rootFilled"));
    }
}