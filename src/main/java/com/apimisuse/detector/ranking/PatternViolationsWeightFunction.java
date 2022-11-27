package com.apimisuse.detector.ranking;

import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

public class PatternViolationsWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        return 1.0 / overlaps.getViolationsOfSamePattern(violation).size();
    }

    @Override
    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        return String.format("pattern violations = 1 / %d", overlaps.getViolationsOfSamePattern(violation).size());
    }

    @Override
    public String getId() {
        return "PV";
    }
}
