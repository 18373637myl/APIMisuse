package com.apimisuse.detector.ranking;

import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

/**
 * As proposed for PR-Miner by Li and Zhou (2005) and for GrouMiner by Nguyen et al. (2009).
 */
public class RarenessWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        double patternSupport = violation.getPattern().getSupport();
        double violationSupport = overlaps.getNumberOfEqualViolations(violation);
        return 1.0 - violationSupport / patternSupport;
    }

    @Override
    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        int patternSupport = violation.getPattern().getSupport();
        int violationSupport = overlaps.getNumberOfEqualViolations(violation);
        return String.format("1 - (%d / %d)", violationSupport, patternSupport);
    }

    @Override
    public String getId() {
        return "Rareness";
    }
}
