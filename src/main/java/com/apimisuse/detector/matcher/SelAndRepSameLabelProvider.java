package com.apimisuse.detector.matcher;

import com.apimisuse.aug.model.controlflow.RepetitionEdge;
import com.apimisuse.aug.model.controlflow.SelectionEdge;
import com.apimisuse.aug.visitors.AUGElementVisitor;
import com.apimisuse.aug.visitors.AUGLabelProvider;
import com.apimisuse.aug.visitors.DelegateAUGVisitor;

public class SelAndRepSameLabelProvider extends DelegateAUGVisitor<String> implements AUGLabelProvider {
    private static final String SEL_AND_REP_LABEL = "ctrl";

    public SelAndRepSameLabelProvider(AUGElementVisitor<String> fallbackLabelProvider) {
        super(fallbackLabelProvider);
    }

    @Override
    public String visit(SelectionEdge edge) {
        return SEL_AND_REP_LABEL;
    }

    @Override
    public String visit(RepetitionEdge edge) {
        return SEL_AND_REP_LABEL;
    }
}
