package com.apimisuse.aug.model.dataflow;

import com.apimisuse.aug.model.BaseEdge;
import com.apimisuse.aug.model.DataFlowEdge;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.visitors.EdgeVisitor;

public class ParameterEdge extends BaseEdge implements DataFlowEdge {
    public ParameterEdge(Node source, Node target) {
        super(source, target, Type.PARAMETER);
    }

    @Override
    public <R> R apply(EdgeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
