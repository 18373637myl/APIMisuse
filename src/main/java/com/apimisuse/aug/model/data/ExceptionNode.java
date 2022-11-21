package com.apimisuse.aug.model.data;

import com.apimisuse.aug.visitors.NodeVisitor;

public class ExceptionNode extends VariableNode {
    public ExceptionNode(String exceptionType, String variableName) {
        super(exceptionType, variableName);
    }

    @Override
    public <R> R apply(NodeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
