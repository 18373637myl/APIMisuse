package com.apimisuse.miner.mining;

import com.apimisuse.aug.model.Edge;
import com.apimisuse.aug.model.actions.MethodCallNode;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.model.patterns.APIUsagePattern;

import java.util.Set;
import java.util.stream.Collectors;

import static com.apimisuse.aug.model.Edge.Type.SYNCHRONIZE;
import static com.apimisuse.aug.model.Edge.Type.THROW;

public class MinPatternActionsModel implements Model {

    private final Set<APIUsagePattern> patterns;

    public MinPatternActionsModel(Model model, int minNumberOfCalls) {
        patterns = model.getPatterns().stream()
                .filter((pattern) -> hasEnoughCalls(pattern, minNumberOfCalls))
                .collect(Collectors.toSet());
    }

    private boolean hasEnoughCalls(APIUsagePattern pattern, int minNumberOfCalls) {
        long numberOfCalls = pattern.vertexSet().stream().filter(MinPatternActionsModel::isMethodCall).count();
        long numberOfThrows = pattern.edgeSet().stream().filter(this::isRelevant).count();
        return numberOfCalls + numberOfThrows >= minNumberOfCalls;
    }

    private boolean isRelevant(Edge edge) {
        return edge.getType() == THROW || edge.getType() == SYNCHRONIZE;
    }

    private static boolean isMethodCall(Node node) {
        return node instanceof MethodCallNode;
    }

    @Override
    public Set<APIUsagePattern> getPatterns() {
        return patterns;
    }
}
