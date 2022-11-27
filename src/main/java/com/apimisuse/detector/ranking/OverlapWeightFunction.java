package com.apimisuse.detector.ranking;

import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

public class OverlapWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        int violationSize = violation.getSize();
        int patternSize = violation.getPattern().getSize();
        return violationSize / (float) patternSize;
    }

    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        int violationSize = violation.getSize();
        int patternSize = violation.getPattern().getSize();
        return String.format("overlap = %d / %d", violationSize, patternSize);
    }

    @Override
    public String getId() {
        return "O";
    }
}
