package com.apimisuse.detector;

import com.apimisuse.aug.model.patterns.APIUsagePattern;
import com.apimisuse.detector.model.Overlap;

import java.util.Optional;

public class MissingElementViolationPredicate implements ViolationPredicate {
    @Override
    public Optional<Boolean> apply(Overlap overlap) {
        return isMissingElement(overlap) ? Optional.of(true) : Optional.empty();
    }

    private boolean isMissingElement(Overlap overlap) {
        APIUsagePattern pattern = overlap.getPattern();
        return overlap.getNodeSize() < pattern.getNodeSize() || overlap.getEdgeSize() < pattern.getEdgeSize();
    }

}
