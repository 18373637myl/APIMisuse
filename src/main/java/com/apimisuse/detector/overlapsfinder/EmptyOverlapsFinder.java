package com.apimisuse.detector.overlapsfinder;

import com.apimisuse.detector.OverlapsFinder;
import com.apimisuse.aug.model.APIUsageExample;
import com.apimisuse.aug.model.patterns.APIUsagePattern;
import com.apimisuse.detector.model.Overlap;

import java.util.Collections;
import java.util.List;

public class EmptyOverlapsFinder implements OverlapsFinder {
    private OverlapsFinder finder;

    public EmptyOverlapsFinder(OverlapsFinder finder) {
        this.finder = finder;
    }

    @Override
    public List<Overlap> findOverlaps(APIUsageExample target, APIUsagePattern pattern) {
        List<Overlap> overlaps = finder.findOverlaps(target, pattern);
        if (overlaps.isEmpty()) {
            return Collections.singletonList(
                    new Overlap(pattern, target, Collections.emptyMap(), Collections.emptyMap()));
        } else {
            return overlaps;
        }
    }
}
