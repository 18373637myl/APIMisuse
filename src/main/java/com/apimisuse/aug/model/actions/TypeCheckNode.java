package com.apimisuse.aug.model.actions;

import com.apimisuse.aug.visitors.NodeVisitor;

public class TypeCheckNode extends OperatorNode {
    private final String targetTypeName;

    public TypeCheckNode(String targetTypeName) {
        super("<instanceof>");
        this.targetTypeName = targetTypeName;
    }

    public TypeCheckNode(String targetTypeName, int sourceLineNumber) {
        super("<instanceof>", sourceLineNumber);
        this.targetTypeName = targetTypeName;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    @Override
    public boolean isCoreAction() {
        return false;
    }

    @Override
    public <R> R apply(NodeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
