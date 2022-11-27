package com.apimisuse.detector.ranking;

import com.apimisuse.aug.model.APIUsageGraph;
import com.apimisuse.detector.model.Overlap;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.miner.mining.Model;

public class PatternSizeWeightFunction implements ViolationWeightFunction {
    @Override
    public double getWeight(Overlap violation, Overlaps overlaps, Model model) {
        return Math.log10(getPatternWeight(violation)) / Math.log10(getMaxPatternWeight(model));
    }

    private int getPatternWeight(Overlap violation) {
        return violation.getPattern().getNodeSize();
    }

    private int getMaxPatternWeight(Model model) {
        return model.getPatterns().stream().mapToInt(APIUsageGraph::getNodeSize).max().orElse(Integer.MAX_VALUE);
    }

    @Override
    public String getFormula(Overlap violation, Overlaps overlaps, Model model) {
        return String.format("pattern-size rank = log10(%d) / log10(%d)",
                getPatternWeight(violation),
                getMaxPatternWeight(model));
    }

    @Override
    public String getId() {
        return "PSize";
    }
}
