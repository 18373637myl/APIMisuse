package com.apimisuse.detector.ranking;

import com.apimisuse.aug.model.patterns.APIUsagePattern;
import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

public class PatternSameSizeSupportWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        APIUsagePattern pattern = violation.getPattern();
        return pattern.getSupport() / (double) model.getMaxPatternSupport(pattern.getNodeSize());
    }

    @Override
    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        APIUsagePattern pattern = violation.getPattern();
        return String.format("pattern support = %d / %d", pattern.getSupport(), model.getMaxPatternSupport(pattern.getNodeSize()));
    }

    @Override
    public String getId() {
        return "PS-ss";
    }
}
