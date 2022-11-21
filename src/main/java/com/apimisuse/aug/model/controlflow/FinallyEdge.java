package com.apimisuse.aug.model.controlflow;

import com.apimisuse.aug.model.BaseEdge;
import com.apimisuse.aug.model.ControlFlowEdge;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.visitors.EdgeVisitor;

public class FinallyEdge extends BaseEdge implements ControlFlowEdge {
    public FinallyEdge(Node source, Node target) {
        super(source, target, Type.FINALLY);
    }

    @Override
    public <R> R apply(EdgeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
