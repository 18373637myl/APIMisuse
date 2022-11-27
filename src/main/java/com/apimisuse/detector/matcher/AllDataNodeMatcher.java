package com.apimisuse.detector.matcher;

import com.apimisuse.aug.model.DataNode;
import com.apimisuse.aug.model.Node;

public class AllDataNodeMatcher implements NodeMatcher {
    @Override
    public boolean test(Node targetNode, Node patternNode) {
        return targetNode instanceof DataNode && patternNode instanceof DataNode;
    }
}
