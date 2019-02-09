package org.dy;

import java.util.List;

public class TreeCount {

    public int countTrees(double alpha, List<Tree> forest) {
        if (forest == null || forest.isEmpty()) return 0;
        int ret = 0;
        int visible = 0;
        int lastTree = 0;

        forest.sort(Tree::compareTo);
        for (int i = 0; i < forest.size() && forest.get(0).getAngleToTree(forest.get(i)) <= alpha; i++) {
            visible++;
            lastTree = i;
        }

        if (lastTree == 0) lastTree = 1;
        if (visible > ret) ret = visible;

        for (int i = 1; i < forest.size(); i++) {
            visible -= 1;



            //double delta = forest.get(i).getAngleToTree(forest.get(i - 1));
            for (int curLastTree = lastTree; /*curLastTree < forest.size() &&*/
                    forest.get(i).getAngleToTree(forest.get(curLastTree)) <= alpha
                    ; curLastTree = (curLastTree + 1) /*% forest.size()*/ /*(curLastTree++)%forest.size()*/ ) {
                System.out.println(curLastTree);
                visible++;
                lastTree=curLastTree;
            }

            if (visible > ret) ret = visible;
        }
        return ret;
    }
}

