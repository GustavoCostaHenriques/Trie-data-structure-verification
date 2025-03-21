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
 * --------------------------------------------------------------------------------------------------------
 * |                    Partitions                      |     Base Choice    |           Tests            |
 * |----------------------------------------------------|--------------------|----------------------------|
 * |                                                    |                    |      (Empty, Typical)      |
 * | Trie State: {Empty, Contains Key, Contains Prefix} |                    |     (Empty, Smallest)      |
 * |       Key Type: {Smallest, Largest, Typical}       |  (Empty, Typical)  |     (Empty, Largest)       |
 * |                                                    |                    |  (Contains Key, Typical)   |
 * |                                                    |                    | (Contains Prefix, Typical) |
 * --------------------------------------------------------------------------------------------------------
 * 
 * Reason for Base Choice: The Empty and Typical block were chosen as the most important of their respective
 *                         partitions. The Empty block is the most important of the Trie State partition, 
 *                         as it is the first state that happens every time a new Trie is created. The Typical
 *                         block is the most important of the Key Type partition, as it is the most common type
 *                         from an end-user point of view.     
 * 
 * Each test will specify the test of the table above that is performing.
 */
public class TestBCCforput {

    /**
     * Test: (Empty, Typical).
     */
    @Test
    public void testEmptyTypical() {}

    /**
     * Test: (Empty, Smallest).
     */
    @Test
    public void testEmptySmallest() {}

    /**
     * Test: (Empty, Largest).
     */
    @Test
    public void testEmptyLargest() {}

    /**
     * Test: (Contains Key, Typical).
     */
    @Test
    public void testContainsKeyTypical() {}

    /**
     * Test: (Contains Prefix, Typical).
     */
    @Test
    public void testContainsPrefixTypical() {}
}