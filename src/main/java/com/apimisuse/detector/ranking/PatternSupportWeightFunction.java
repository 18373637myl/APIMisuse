package com.apimisuse.detector.ranking;

import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

public class PatternSupportWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        return violation.getPattern().getSupport() / (double) model.getMaxPatternSupport();
    }

    @Override
    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        return String.format("pattern support = %d / %d", violation.getPattern().getSupport(), model.getMaxPatternSupport());
    }

    @Override
    public String getId() {
        return "PS";
    }
}
