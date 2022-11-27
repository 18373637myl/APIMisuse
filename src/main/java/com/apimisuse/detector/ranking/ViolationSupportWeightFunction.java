package com.apimisuse.detector.ranking;

import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

public class ViolationSupportWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        return 1.0 / overlaps.getNumberOfEqualViolations(violation);
    }

    @Override
    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        return String.format("violation support = 1 / %d", overlaps.getNumberOfEqualViolations(violation));
    }

    @Override
    public String getId() {
        return "VS";
    }
}
