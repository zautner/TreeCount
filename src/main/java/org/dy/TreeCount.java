package org.dy;

import java.util.List;
import java.util.logging.Logger;

public class TreeCount {

    static final Logger logger = Logger.getLogger(TreeCount.class.getCanonicalName());

    public int countTrees(double alpha, List<Tree> forest) {
        // Two clear edge cases - below
        if (forest == null || forest.isEmpty() || alpha <= 0) {
            logger.warning("Inconsistent data!..");
            return 0;
        }
        if (alpha >= 360.0) {
            logger.warning("The whole forest gets visible for this wide angle!");
            return forest.size();
        }
        
        // Regular flow - below
        // Init
        forest.sort(Tree::compareTo);
        Tree zeroTree = forest.get(0);
        int curTree = 0;
        for (curTree = 0; curTree < forest.size() && zeroTree.getAngleToTree(forest.get(curTree)) < alpha; curTree++){
            logger.fine(String.format("iteration #%d we're still in ther angle", curTree));
        }
        // A simple case
        if (curTree == forest.size()) return curTree; // we've alredy tested the whole forest, no more situation to test
       // Iterate over the forest, checking one by one
        int curCount = curTree;
        int ret = curCount;
        for (int i = 1; i < forest.size(); i++) {
            zeroTree = forest.get(i);
            if (curCount > 0) curCount -= 1; //we no longer count the rightmost tree 
            if (curTree == i) {
                // catching up the end of our testing angle
                curTree = (curTree + 1) % forest.size();
                curCount = 1; //we cannot see less than 1 tree as we iterate OVER the trees
            }
            for (int j = curTree; zeroTree.getAngleToTree(forest.get(curTree = j)) < alpha; j = (j + 1) % forest.size()) {
                logger.info(String.format("running is %d; last visible is %d", j, curTree));
                curCount++;
            }
            if (curCount > ret) {
                ret = curCount;
            }
        }
        return ret;
    }

}
