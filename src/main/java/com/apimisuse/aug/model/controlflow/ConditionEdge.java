package com.apimisuse.aug.model.controlflow;

import com.apimisuse.aug.model.BaseEdge;
import com.apimisuse.aug.model.ControlFlowEdge;
import com.apimisuse.aug.model.Node;

import static com.apimisuse.aug.model.Edge.Type.CONDITION;

public abstract class ConditionEdge extends BaseEdge implements ControlFlowEdge {
    private final ConditionType conditionType;

    public enum ConditionType {
        SELECTION("sel"), REPETITION("rep");

        private final String label;

        ConditionType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    protected ConditionEdge(Node source, Node target, ConditionType conditionType) {
        super(source, target, CONDITION);
        this.conditionType = conditionType;
    }

    /**
     * Use the edge's class type instead.
     */
    @Deprecated
    public ConditionType getConditionType() {
        return conditionType;
    }
}
