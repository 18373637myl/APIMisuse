package com.apimisuse.detector.matcher;

import com.apimisuse.aug.model.Edge;
import com.apimisuse.aug.visitors.AUGLabelProvider;

import java.util.function.BiPredicate;

public class EquallyLabelledEdgeMatcher implements BiPredicate<Edge, Edge> {
    private final AUGLabelProvider labelProvider;

    public EquallyLabelledEdgeMatcher(AUGLabelProvider labelProvider) {
        this.labelProvider = labelProvider;
    }

    @Override
    public boolean test(Edge edge, Edge edge2) {
        return labelProvider.getLabel(edge).equals(labelProvider.getLabel(edge2));
    }
}
