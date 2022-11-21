package com.apimisuse.aug.model.actions;

import com.apimisuse.aug.model.ActionNode;
import com.apimisuse.aug.model.BaseNode;
import com.apimisuse.aug.visitors.NodeVisitor;

public class ThrowNode extends BaseNode implements ActionNode {
    public ThrowNode() {}

    public ThrowNode(int sourceLineNumber) {
        super(sourceLineNumber);
    }

    @Override
    public boolean isCoreAction() {
        return true;
    }

    @Override
    public <R> R apply(NodeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
