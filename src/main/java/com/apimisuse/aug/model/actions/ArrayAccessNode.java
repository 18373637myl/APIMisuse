package com.apimisuse.aug.model.actions;

import com.apimisuse.aug.visitors.NodeVisitor;

public class ArrayAccessNode extends MethodCallNode {
    public ArrayAccessNode(String arrayTypeName) {
        super(arrayTypeName, "arrayget()");
    }

    public ArrayAccessNode(String arrayTypeName, int sourceLineNumber) {
        super(arrayTypeName, "arrayget()", sourceLineNumber);
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
