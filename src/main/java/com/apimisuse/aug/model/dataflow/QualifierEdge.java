package com.apimisuse.aug.model.dataflow;

import com.apimisuse.aug.model.BaseEdge;
import com.apimisuse.aug.model.DataFlowEdge;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.visitors.EdgeVisitor;

public class QualifierEdge extends BaseEdge implements DataFlowEdge {
    public QualifierEdge(Node source, Node target) {
        super(source, target, Type.QUALIFIER);
    }

    @Override
    public <R> R apply(EdgeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
