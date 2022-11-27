package com.apimisuse.detector;

import com.apimisuse.detector.model.Overlap;

import java.util.Collection;

public class AlternativePatternInstancePredicate {
    public boolean test(Overlap violation, Collection<Overlap> instances) {
        for (Overlap instance : instances) {
            if (violation.isInTargetOverlap(instance)) {
                return true;
            }
        }
        return false;
    }
}
