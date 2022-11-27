package com.apimisuse.miner.mining;

import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.model.actions.ConstructorCallNode;
import com.apimisuse.aug.model.actions.MethodCallNode;

import java.util.function.Predicate;

public class InstanceMethodCallPredicate implements Predicate<Node> {
    @Override
    public boolean test(Node node) {
        return node instanceof MethodCallNode && !(node instanceof ConstructorCallNode);
    }
}
