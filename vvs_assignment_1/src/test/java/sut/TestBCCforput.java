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
 * This class is used to give Base Choice Coverage 
 * for the put method, of the TST class.
 * 
 * Base Choice Coverage (BCC):
 * 
 * -------------------------------------------------------------------------------------------------------------------
 * |                    Partitions                      |     Base Choice              |           Tests             |
 * |----------------------------------------------------|------------------------------|-----------------------------|
 * |                                                    |                              | (Contains Prefix, Typical)  |
 * | Trie State: {Empty, Contains Key, Contains Prefix} |                              | (Contains Prefix, Smallest) |
 * |       Key Type: {Smallest, Largest, Typical}       |  (Contains Prefix, Typical)  | (Contains Prefix, Largest)  |
 * |                                                    |                              |  (Contains Key, Typical)    |
 * |                                                    |                              |      (Empty, Typical)       |
 * -------------------------------------------------------------------------------------------------------------------
 * 
 * Reason for Base Choice: The Conaits Prefix and Typical block were chosen as the most important of their respective
 *                         partitions. The Contains Prefix block is the most important of the Trie State partition, 
 *                         as it is the state that happens the majority of times when inserting some key in the Trie.
 *                         The Typical block is the most important of the Key Type partition, as it is the most common 
 *                         type from an end-user point of view.     
 * 
 * Each test will specify the test of the table above that is performing.
 */
public class TestBCCforput {
    /**
     * Construction of an empty Trie.
     */
    private TST<Integer> TrieEmpty = new TST<>();

    /**
     * Construction of a Trie with some keys.
     */
    private TST<Integer> TrieFilled = new TST<>();
    {
        TrieFilled.put("simple", 1);
        TrieFilled.put("sm", 2);
        TrieFilled.put("biggest value of all", 3);
        TrieFilled.put("four", 4);
        TrieFilled.put("five", 5);
        TrieFilled.put("six", 6);
        TrieFilled.put("seven", 7);
        TrieFilled.put("eigth", 8);
        TrieFilled.put("nine", 9);
        TrieFilled.put("ten", 10);
    }

    /**
     * Test: (Contains Prefix, Typical).
     */
    @Test
    public void testContainsPrefixTypical() {
        /* Test the insertion of a key that is the prefix of an existing typical key.
         * The key "sim" is a prefix of the key "simples".
         * The expected behavior is that the key "sim" is inserted in the Trie,
         * and the value associated with it is 1, which is the value of the key "simples". 
         */
        TrieFilled.put("sim", 1);
        assertEquals(1, (int) TrieFilled.get("sim"));
    }

    /**
     * Test: (Contains Prefix, Smallest).
     */
    @Test
    public void testContainsPrefixSmallest() {
        /* Test the insertion of a key that is the prefix of the existing smallest key.
         * The key "sm" is a prefix of the key "sm".
         * The expected behavior is that the key "s" is inserted in the Trie,
         * and the value associated with it is 2, which is the value of the key "sm". 
         */
        TrieFilled.put("s", 2);
        assertEquals(2, (int) TrieFilled.get("s"));
    }

    /**
     * Test: (Contains Prefix, Largest).
     */
    @Test
    public void testContainsPrefixLargest() {
        /* Test the insertion of a key that is the prefix of the existing largest key.
         * The key "biggest" is a prefix of the key "biggest value of all".
         * The expected behavior is that the key "biggest" is inserted in the Trie,
         * and the value associated with it is 3, which is the value of the key "biggest value of all". 
         */
        TrieFilled.put("biggest", 3);
        assertEquals(3, (int) TrieFilled.get("biggest"));

    }

    /**
     * Test: (Contains Key, Typical).
     */
    @Test
    public void testContainsKeyTypical() {
        /* Test the insertion of a key that is already in the Trie with a different value.
         * The key "four" is already in the Trie.
         * The expected behavior is that the key "four" changes its value to the new value.
         */
        TrieFilled.put("four", 10);
        assertEquals(10, (int) TrieFilled.get("four"));
    }

    /**
     * Test: (Empty, Typical).
     */
    @Test
    public void testEmptyTypical() {
        /* Test the insertion of a key in an empty Trie.
         * The key "four" is not in the Trie.
         * The expected behavior is that the key "four" is inserted in the Trie,
         * and the value associated with it is 4. 
         */
        TrieEmpty.put("four", 4);
        assertEquals(4, (int) TrieEmpty.get("four"));
    }
}