package com.apimisuse.detector;

import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.model.actions.MethodCallNode;
import com.apimisuse.detector.model.Violation;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AlternativeViolationPredicate {
    /**
     * Creates a stateful predicate that returns <code>false</code> for all violations that share a method or
     * constructor call (<i>same</i> target node!) with any violation previously passed to this predicate, and
     * <code>true</code> otherwise.
     */
    public static Predicate<Violation> firstAlternativeViolation() {
        Set<Node> coveredNodes = new HashSet<>();
        return violation -> {
            Set<Node> mappedTargetNodes = violation.getOverlap().getMappedTargetNodes().stream()
                    .filter(node -> node instanceof MethodCallNode)
                    .collect(Collectors.toSet());
            if (mappedTargetNodes.stream().anyMatch(coveredNodes::contains)) {
                return false;
            } else {
                coveredNodes.addAll(mappedTargetNodes);
                return true;
            }
        };
    }
}
