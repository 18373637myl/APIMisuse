package com.apimisuse.detector.ranking;

import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

public interface ViolationWeightFunction {
    double getWeight(Overlap violation, Overlaps overlaps, Model model);

    String getFormula(Overlap violation, Overlaps overlaps, Model model);

    String getId();
}
