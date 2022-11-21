package com.apimisuse.aug.model.actions;

import com.apimisuse.aug.model.ActionNode;
import com.apimisuse.aug.model.BaseNode;

public abstract class OperatorNode extends BaseNode implements ActionNode {
    private final String operator;

    OperatorNode(String operator) {
        this.operator = operator;
    }

    OperatorNode(String operator, int sourceLineNumber) {
        super(sourceLineNumber);
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public boolean isCoreAction() {
        return false;
    }
}
