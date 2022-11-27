package com.apimisuse.detector.ranking;

import com.apimisuse.detector.ViolationRankingStrategy;
import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.detector.model.Violation;
import com.apimisuse.miner.mining.Model;

import java.util.List;
import java.util.stream.Collectors;

public class NoRankingStrategy implements ViolationRankingStrategy {

    @Override
    public List<Violation> rankViolations(Overlaps overlaps, Model model) {
        return overlaps.getViolations().stream()
                .map(violation -> new Violation(violation, 1.0, "no ranking"))
                .collect(Collectors.toList());
    }
}
