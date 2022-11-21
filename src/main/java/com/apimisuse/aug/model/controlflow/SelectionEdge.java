package com.apimisuse.aug.model.controlflow;

import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.visitors.EdgeVisitor;

public class SelectionEdge extends ConditionEdge {
    public SelectionEdge(Node source, Node target) {
        super(source, target, ConditionType.SELECTION);
    }

    @Override
    public <R> R apply(EdgeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
