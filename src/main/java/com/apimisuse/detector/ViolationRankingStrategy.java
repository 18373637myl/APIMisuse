package com.apimisuse.detector;

import com.apimisuse.detector.model.Overlaps;
import com.apimisuse.detector.model.Violation;
import com.apimisuse.miner.mining.Model;

import java.util.List;

public interface ViolationRankingStrategy {
    List<Violation> rankViolations(Overlaps overlaps, Model model);
}
