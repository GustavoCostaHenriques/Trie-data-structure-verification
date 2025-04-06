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
 * Graph Construction for private put:
 * 
 * ## Edges
 *  0 1
 *  1 2
 *  1 3
 *  2 3
 *  3 4
 *  3 5
 *  5 6
 *  4 7
 *  4 8
 *  7 6
 *  8 9
 *  8 10
 *  9 6
 *  10 6
 *
 *  ## Initial nodes
 *  0
 *
 *  ## Final nodes
 *  6
 *
 *  ## parameter coupling
 *  last-def(x.left)  = {5}
 *  first-use(x) = {(1,2),(1,3)}
 *  last-def(x.right)  = {7}
 *  first-use(x) = {(1,2),(1,3)}
 *  last-def(x.mid)  = {9}
 *  first-use(x) = {(1,2),(1,3)}
 *  last-def(d)  = {0}
 *  first-use(d) = {1}
 *
 *  ## return coupling
 *  last-def(x) = {5,7,9,10}
 *  first-use(x) = {6}
 */

/** 
 * This class is used to give All-Coupling-Use-Pats Coverage
 * for the private put method, of the TST class.
 * 
 * Note: As this is a recursive method, let's imagine that we have
 *       two equal graphs where the nodes in one go in an ascending 
 *       numeric order (0,1,2,3,etc.) as it is represented above.
 *       And the second one has nodes in an ascending alphabetical 
 *       order (a,b,c,etc.) where a is the same as 0, b is the
 *       same as 1 and so on.
 * 
 * All the Coupling Use Paths that exist are:
 * 
 * => Parameter Coupling
 * 1. last-def(x.left)=>first-use(x) [5,a,(b,c)] ✅
 * 2. last-def(x.left)=>first-use(x) [5,a,(b,d)]
 * 3. last-def(x.right)=>first-use(x) [7,a,(b,c)]
 * 4. last-def(x.right)=>first-use(x) [7,a,(b,d)]
 * 5. last-def(x.mid)=>first-use(x) [9,a,(b,c)]
 * 6. last-def(x.mid)=>first-use(x) [9,a,(b,d)]
 * 7. last-def(d)=>first-use(d) [0,1,2,3,5,a,b]
 * 8. last-def(d)=>first-use(d) [0,1,3,5,a,b] ✅
 * 9. last-def(d)=>first-use(d) [0,1,2,3,4,7,a,b]
 * 10. last-def(d)=>first-use(d) [0,1,3,4,7,a,b]
 * 11. last-def(d)=>first-use(d) [0,1,2,3,4,8,9,a,b]
 * 12. last-def(d)=>first-use(d) [0,1,3,4,8,9,a,b]
 * 13. last-def(d)=>first-use(d) [9,a,b]
 *
 * => Return Coupling
 * 14. last-def(x.left)=>first-use(x.left) [e,g,5,6] ❌
 * 15. last-def(x.left)=>first-use(x.right) [e,g,7,6] ❌
 * 16. last-def(x.left)=>first-use(x.mid) [e,g,9,6] ❌
 * 17. last-def(x.right)=>first-use(x.left) [h,g,5,6] ❌
 * 18. last-def(x.right)=>first-use(x.right) [h,g,7,6] ❌
 * 19. last-def(x.right)=>first-use(x.mid) [h,g,9,6] ❌
 * 20. last-def(x.mid)=>first-use(x.left) [j,g,5,6] ❌
 * 21. last-def(x.mid)=>first-use(x.right) [j,g,7,6] ❌
 * 22. last-def(x.mid)=>first-use(x.mid) [j,g,9,6] ❌
 * 23. last-def(x.val)=>first-use(x.left) [k,g,5,6] ✅
 * 24. last-def(x.val)=>first-use(x.right) [k,g,7,6]
 * 25. last-def(x.val)=>first-use(x.mid) [k,g,9,6]
 * 
 * Note: The definition of the All-Coupling-Use-Paths is the following:
 *          
 *          => "cover at least one coupling du-path from 
 *                every last-def to first-use of x"
 *      
 *       Where the last-def is the last definition of the variable and
 *       the first-use is the first use of said variable in the other 
 *       function that was called/returned. With this we conclude that 
 *       the only Coupling Use Paths that need to be covered are:
 * 
 *          => (1|2),(3|4),(5|6),(7|8|9|10|11|12),13,14,15,16,17,18,
 *             19,20,21,22,23,24,25.
 * 
 *      Altough, the paths from 14-22 are infeasible, since the only branch
 *      that is not recursive is the one that defines the x.val variable. 
 *      Meaning that all the other branchs instead of returning x will still 
 *      make a recursive call, i.e, they will not go to node g.
 * 
 * Each test will specify the path as well as the Coupling Use Paths that is covering.
 */ 
public class TestAllCouplingUsePathsforprivateput {
    /**
     * Construction of a Trie with one key.
     */
    private TST<Integer> TrieFilled = new TST<>();
    {
        TrieFilled.put("m", 1);
    }

    /**
     * Test Path: [0,1,3,5,a,b,c,d,f,i,k,g,5,6] - 1,8,25.
     */
    @Test
    public void testWithLeftValue() {
        TST<Integer> st = new TST<>();
        Node<T> X = st.put("a", 2);

        assertEquals(X, st.put("a",2));
    }   

    @Test
    public void testWithRightValue() {}

    @Test
    public void testWithMidValue() {}
}