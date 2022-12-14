package com.apimisuse.miner.mining;

import com.apimisuse.aug.model.APIUsageGraph;
import com.apimisuse.aug.model.DataNode;
import com.apimisuse.aug.model.Edge;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.model.dataflow.ParameterEdge;
import com.apimisuse.aug.model.dataflow.ReceiverEdge;
import com.apimisuse.aug.visitors.AUGLabelProvider;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DenseAUGPredicate implements Predicate<APIUsageGraph> {
    private static final int MAX_BRANCHES = 100;
    private static final int MAX_REFERENCES = 9;

    private final AUGLabelProvider labelProvider;

    public DenseAUGPredicate(AUGLabelProvider labelProvider) {
        this.labelProvider = labelProvider;
    }

    @Override
    public boolean test(APIUsageGraph graph) {
        for (Node node : graph.vertexSet()) {
            if (node instanceof DataNode) {
                if (getNumberOfOutEdges(graph, node) < 10)
                    continue;
                if (getNumberOfOutEdges(graph, node) > MAX_BRANCHES)
                    return true;
                if (getMaxNumberOfEqualOutEdges(graph, node) > MAX_REFERENCES)
                    return true;
            }
        }
        return false;
    }

    private long getNumberOfOutEdges(APIUsageGraph graph, Node node) {
        return graph.outgoingEdgesOf(node).stream().filter(Edge::isDirect).count();
    }

    private long getMaxNumberOfEqualOutEdges(APIUsageGraph graph, Node node) {
        return graph.outgoingEdgesOf(node).stream().filter(this::isDirectReceiverOrParameterEdge)
                .collect(Collectors.groupingBy(edge -> edgeAndTargetId(graph, edge), Collectors.counting()))
                .values().stream().mapToLong(l -> l).max().orElse(0);
    }

    private boolean isDirectReceiverOrParameterEdge(Edge succ) {
        return succ.isDirect() && (succ instanceof ReceiverEdge || succ instanceof ParameterEdge);
    }

    private String edgeAndTargetId(APIUsageGraph graph, Edge edge) {
        return labelProvider.getLabel(edge) + "->" + labelProvider.getLabel(graph.getEdgeTarget(edge));
    }
}
