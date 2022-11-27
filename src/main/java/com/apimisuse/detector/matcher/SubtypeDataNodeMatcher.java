package com.apimisuse.detector.matcher;

import com.apimisuse.aug.model.DataNode;
import com.apimisuse.aug.model.Node;
import com.apimisuse.detector.typehierarchy.TypeHierarchy;

public class SubtypeDataNodeMatcher implements NodeMatcher {

    private TypeHierarchy typeHierarchy;

    public SubtypeDataNodeMatcher(TypeHierarchy typeHierarchy) {
        this.typeHierarchy = typeHierarchy;
    }

    @Override
    public boolean test(Node targetNode, Node patternNode) {
        return targetNode instanceof DataNode && patternNode instanceof DataNode
                && typeHierarchy.isA(((DataNode) targetNode).getType(), ((DataNode) patternNode).getType());
    }
}
