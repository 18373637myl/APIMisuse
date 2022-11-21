package com.apimisuse.aug.model.dataflow;

import com.apimisuse.aug.model.BaseEdge;
import com.apimisuse.aug.model.DataFlowEdge;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.visitors.EdgeVisitor;

public class DefinitionEdge extends BaseEdge implements DataFlowEdge {
    public DefinitionEdge(Node source, Node target) {
        super(source, target, Type.DEFINITION);
    }

    @Override
    public <R> R apply(EdgeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
