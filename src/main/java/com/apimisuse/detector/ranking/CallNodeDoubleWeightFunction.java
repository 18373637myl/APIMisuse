package com.apimisuse.detector.ranking;

import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.model.actions.MethodCallNode;

public class CallNodeDoubleWeightFunction implements NodeWeightFunction {
    @Override
    public double getWeight(Node node) {
        return node instanceof MethodCallNode ? 2 : 1;
    }
}
