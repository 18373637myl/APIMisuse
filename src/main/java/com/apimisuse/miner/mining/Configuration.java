package com.apimisuse.miner.mining;

import com.apimisuse.miner.mining.InstanceMethodCallPredicate;
import com.apimisuse.aug.model.Node;
import com.apimisuse.aug.model.controlflow.*;
import com.apimisuse.aug.model.dataflow.DefinitionEdge;
import com.apimisuse.aug.model.dataflow.ParameterEdge;
import com.apimisuse.aug.model.dataflow.ReceiverEdge;
import com.apimisuse.aug.visitors.AUGLabelProvider;
import com.apimisuse.aug.visitors.BaseAUGLabelProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Configuration {
    public int minPatternSize = 1, maxPatternSize = Integer.MAX_VALUE;
    public int minPatternSupport = 10, maxPatternSupport = 1000;

    /**
     * Predicate that decides whether mining is started from a give node.
     */
    public Predicate<Node> isStartNode = new InstanceMethodCallPredicate().and(Node::isCoreAction);

    public enum DataNodeExtensionStrategy { ALWAYS, IF_INCOMING, IF_INCOMING_AND_OUTGOING }
    /**
     * Whether or not the miner should extend a pattern with a data node.
     */
    public DataNodeExtensionStrategy extendByDataNode = DataNodeExtensionStrategy.IF_INCOMING;

    /**
     * Whether or not the miner should output log information to System.out.
     */
    public boolean disableSystemOut = false;
    
    /**
     * Whether or not the miner should allow the same call to appear multiple times successively, i.e., they are connected, in a pattern.
     * Repeated calls on disconnected nodes, e.g., on different branches, are still allowed.
     */
    public boolean disallowRepeatedCalls = true;

    /**
     * Path to write mined patterns to. <code>null</code> to disable output.
     */
    public String outputPath = "output/patterns";

    public AUGLabelProvider labelProvider = new BaseAUGLabelProvider();
    
    public enum Level {WITHIN_METHOD, CROSS_METHOD, CROSS_PROJECT}
    /**
     * The level of occurrence of instances of a pattern
     */
    public Level occurenceLevel = Level.WITHIN_METHOD;

    /**
     * Types of edges to extend along. Any edge of a type not in this set may only be added to a pattern if both end
     * nodes are included in the pattern already.
     */
    public Set<Class<?>> extensionEdgeTypes = new HashSet<>(Arrays.asList(
            ThrowEdge.class, ExceptionHandlingEdge.class, FinallyEdge.class,
            SynchronizationEdge.class,
            ReceiverEdge.class, ParameterEdge.class, DefinitionEdge.class, ContainsEdge.class
    ));
}
