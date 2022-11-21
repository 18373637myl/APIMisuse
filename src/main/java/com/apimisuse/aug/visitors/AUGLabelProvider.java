package com.apimisuse.aug.visitors;

import com.apimisuse.aug.model.Edge;
import com.apimisuse.aug.model.Node;

public interface AUGLabelProvider extends AUGElementVisitor<String> {
    default String getLabel(Node node) {
        return node.apply(this);
    }

    default String getLabel(Edge edge) {
        return edge.apply(this);
    }
}
