package com.apimisuse.aug.model.dataflow;

import com.apimisuse.aug.model.BaseEdge;
import com.apimisuse.aug.model.DataFlowEdge;
import com.apimisuse.aug.model.Node;

public abstract class BaseDataFlowEdge extends BaseEdge implements DataFlowEdge {
    public BaseDataFlowEdge(Node source, Node target, Type type) {
        super(source, target, type);
    }
}
