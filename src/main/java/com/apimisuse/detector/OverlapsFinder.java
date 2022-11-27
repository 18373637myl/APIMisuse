package com.apimisuse.detector;

import com.apimisuse.aug.model.APIUsageExample;
import com.apimisuse.aug.model.patterns.APIUsagePattern;
import com.apimisuse.detector.model.Overlap;

import java.util.List;

public interface OverlapsFinder {
    List<Overlap> findOverlaps(APIUsageExample target, APIUsagePattern pattern);
}
