package org.dy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TreeCountTest {

    private TreeCount counter;

    @Before
    public void setUp() throws Exception {
        counter = new TreeCount();
    }

    @Test
    public void testEmptyForest() throws Exception {
        ArrayList<Tree> emptyForest = new ArrayList<Tree>();
        assertEquals(0, counter.countTrees(100.0, emptyForest));
    }

    @Test
    public void testBasicCase() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(1, 1));
        forest.add(new Tree(1, 2));
        forest.add(new Tree(1, 3));

        double alpha = 90;
        assertEquals(3, counter.countTrees(alpha, forest));
    }

    @Test
    public void testComplexCase() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(10, 30));
        forest.add(new Tree(50, 2));
        forest.add(new Tree(50, 1));
        forest.add(new Tree(50, 0));
        forest.add(new Tree(50, -1));
        forest.add(new Tree(50, -2));
        forest.add(new Tree(-50, 20));
        forest.add(new Tree(-50, -20));

        double alpha = 30;
        assertEquals(5, counter.countTrees(alpha, forest));
    }

    @Test
    public void testLinearForestY() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(0, 30));
        forest.add(new Tree(0, 2));
        forest.add(new Tree(0, 1));
        forest.add(new Tree(0, 0));
        forest.add(new Tree(0, -1));
        forest.add(new Tree(0, -2));
        forest.add(new Tree(0, 20));
        forest.add(new Tree(0, -20));

        double alpha = 5;
        assertEquals(4, counter.countTrees(alpha, forest));
    }

    @Test
    public void testLinearForestX() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(30, 0));
        forest.add(new Tree(2, 0));
        forest.add(new Tree(1, 0));
        forest.add(new Tree(-1, 0));
        forest.add(new Tree(-7, 0));
        forest.add(new Tree(-70, 0));
        forest.add(new Tree(-700000, 0));

        double alpha = .5;
        assertEquals(4, counter.countTrees(alpha, forest));
    }
}
