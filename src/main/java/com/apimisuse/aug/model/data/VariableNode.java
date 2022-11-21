package com.apimisuse.aug.model.data;

import com.apimisuse.aug.model.BaseNode;
import com.apimisuse.aug.model.DataNode;
import com.apimisuse.aug.visitors.NodeVisitor;

public class VariableNode extends BaseNode implements DataNode {
    private final String variableType;
    private final String variableName;

    public VariableNode(String variableType, String variableName) {
        this.variableType = variableType;
        this.variableName = variableName;
    }

    @Override
    public String getName() {
        return variableName;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getType() {
        return variableType;
    }

    @Override
    public <R> R apply(NodeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
