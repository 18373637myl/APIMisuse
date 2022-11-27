package com.apimisuse.detector.matcher;

import com.apimisuse.aug.model.Node;

import java.util.function.BiPredicate;

public interface NodeMatcher extends BiPredicate<Node, Node> {
    /**
     * @param targetNode the target node to match
     * @param patternNode the pattern node to match against
     * @return whether the target node matches the pattern node (need not be symmetric!)
     */
    @Override
    boolean test(Node targetNode, Node patternNode);
}
