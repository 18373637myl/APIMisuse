package com.apimisuse.aug.model.controlflow;

import com.apimisuse.aug.model.BaseEdge;
import com.apimisuse.aug.model.ControlFlowEdge;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.visitors.EdgeVisitor;

public class SynchronizationEdge extends BaseEdge implements ControlFlowEdge {
    public SynchronizationEdge(Node source, Node target) {
        super(source, target, Type.SYNCHRONIZE);
    }

    @Override
    public <R> R apply(EdgeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
