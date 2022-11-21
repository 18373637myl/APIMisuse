package com.apimisuse.aug.model.dot;

import com.apimisuse.aug.model.APIUsageGraph;

import java.util.Map;

public interface AUGAttributeProvider<G extends APIUsageGraph> {
    Map<String, String> getAUGAttributes(G aug);
}
