package com.apimisuse.detector;

import com.apimisuse.aug.model.APIUsageGraph;
import com.apimisuse.aug.model.DataNode;
import com.apimisuse.aug.model.Edge;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.model.actions.AssignmentNode;
import com.apimisuse.aug.model.dataflow.ParameterEdge;
import com.apimisuse.aug.model.patterns.APIUsagePattern;
import com.apimisuse.detector.model.Overlap;

import java.util.Optional;
import java.util.Set;

public class MissingAssignmentNoViolationPredicate implements ViolationPredicate {
    @Override
    public Optional<Boolean> apply(Overlap overlap) {
        if (missesOnlyAssignmentsAndExclusiveAssignmentParameters(overlap))
            return Optional.of(false);
        else
            return Optional.empty();
    }

    private boolean missesOnlyAssignmentsAndExclusiveAssignmentParameters(Overlap overlap) {
        Set<Node> missingNodes = overlap.getMissingNodes();
        APIUsagePattern graph = overlap.getPattern();
        return missingNodes.stream().allMatch(node -> node instanceof AssignmentNode || isExclusiveParameterOf(node, missingNodes, graph))
                && allConnectToOneOf(overlap.getMissingEdges(), missingNodes);
    }

    private boolean isExclusiveParameterOf(Node node, Set<Node> missingNodes, APIUsageGraph graph) {
        return node instanceof DataNode && graph.edgesOf(node).stream().allMatch(edge -> isParameterEdgeToOneOf(edge, node, missingNodes, graph));
    }

    private boolean isParameterEdgeToOneOf(Edge edge, Node node, Set<Node> missingNodes, APIUsageGraph graph) {
        return graph.getEdgeSource(edge) == node && edge instanceof ParameterEdge && missingNodes.contains(graph.getEdgeTarget(edge));
    }

    private boolean allConnectToOneOf(Set<Edge> missingEdges, Set<Node> missingNodes) {
        return missingEdges.stream()
                .allMatch(edge -> missingNodes.contains(edge.getTarget()) || missingNodes.contains(edge.getSource()));
    }
}
