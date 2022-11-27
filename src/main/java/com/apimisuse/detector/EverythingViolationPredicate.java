package com.apimisuse.detector;

import com.apimisuse.detector.model.Overlap;

import java.util.Optional;

public class EverythingViolationPredicate implements ViolationPredicate {
    @Override
    public Optional<Boolean> apply(Overlap overlap) {
        return Optional.of(true);
    }
}
