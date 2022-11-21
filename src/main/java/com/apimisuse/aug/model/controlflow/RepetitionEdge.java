package com.apimisuse.aug.model.controlflow;

import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.visitors.EdgeVisitor;

public class RepetitionEdge extends ConditionEdge {
    public RepetitionEdge(Node source, Node target) {
        super(source, target, ConditionType.REPETITION);
    }

    @Override
    public <R> R apply(EdgeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
