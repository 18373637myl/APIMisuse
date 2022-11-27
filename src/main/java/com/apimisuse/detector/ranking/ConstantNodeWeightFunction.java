package com.apimisuse.detector.ranking;

import com.apimisuse.aug.model.Node;

public class ConstantNodeWeightFunction implements NodeWeightFunction {
    @Override
    public double getWeight(Node node) {
        return 1;
    }
}
