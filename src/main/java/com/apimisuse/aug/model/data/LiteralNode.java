package com.apimisuse.aug.model.data;

import com.apimisuse.aug.model.BaseNode;
import com.apimisuse.aug.model.DataNode;
import com.apimisuse.aug.visitors.NodeVisitor;

public class LiteralNode extends BaseNode implements DataNode {
    private final String dataType;
    private final String dataValue;

    public LiteralNode(String dataType, String dataValue) {
        this.dataType = dataType;
        this.dataValue = dataValue;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getValue() {
        return dataValue;
    }

    @Override
    public String getType() {
        return dataType;
    }

    @Override
    public <R> R apply(NodeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
