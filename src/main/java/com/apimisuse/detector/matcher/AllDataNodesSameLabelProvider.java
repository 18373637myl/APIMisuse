package com.apimisuse.detector.matcher;

import com.apimisuse.aug.model.data.ConstantNode;
import com.apimisuse.aug.model.data.ExceptionNode;
import com.apimisuse.aug.model.data.LiteralNode;
import com.apimisuse.aug.model.data.VariableNode;
import com.apimisuse.aug.visitors.AUGLabelProvider;
import com.apimisuse.aug.visitors.DelegateAUGVisitor;

public class AllDataNodesSameLabelProvider extends DelegateAUGVisitor<String> implements AUGLabelProvider {
    private static final String DATA_NODE_LABEL = "<Object>";

    public AllDataNodesSameLabelProvider(AUGLabelProvider fallbackLabelProvider) {
        super(fallbackLabelProvider);
    }

    @Override
    public String visit(LiteralNode node) {
        return DATA_NODE_LABEL;
    }

    @Override
    public String visit(ConstantNode node) {
        return DATA_NODE_LABEL;
    }

    @Override
    public String visit(VariableNode node) {
        return DATA_NODE_LABEL;
    }

    @Override
    public String visit(ExceptionNode node) {
        return DATA_NODE_LABEL;
    }
}
