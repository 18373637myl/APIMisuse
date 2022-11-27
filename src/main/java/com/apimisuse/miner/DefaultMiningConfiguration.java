package com.apimisuse.miner;

import com.apimisuse.detector.VeryUnspecificReceiverTypePredicate;
import com.apimisuse.aug.model.controlflow.*;
import com.apimisuse.aug.model.dataflow.DefinitionEdge;
import com.apimisuse.aug.model.dataflow.ParameterEdge;
import com.apimisuse.aug.model.dataflow.ReceiverEdge;
import com.apimisuse.aug.visitors.BaseAUGLabelProvider;
import com.apimisuse.detector.matcher.AllDataNodesSameLabelProvider;
import com.apimisuse.detector.matcher.SelAndRepSameLabelProvider;
import com.apimisuse.miner.mining.Configuration;

import java.util.Arrays;
import java.util.HashSet;

class DefaultMiningConfiguration extends Configuration {
    {
        minPatternSupport = 10;
        occurenceLevel = Level.WITHIN_METHOD;
        isStartNode = super.isStartNode.and(new VeryUnspecificReceiverTypePredicate().negate());
        extendByDataNode = DataNodeExtensionStrategy.IF_INCOMING;
        disableSystemOut = true;
        outputPath = System.getProperty("mudetect.mining.outputpath");
        labelProvider = new SelAndRepSameLabelProvider(new AllDataNodesSameLabelProvider(new BaseAUGLabelProvider()));
        extensionEdgeTypes = new HashSet<>(Arrays.asList(
                ReceiverEdge.class, ParameterEdge.class, DefinitionEdge.class, ThrowEdge.class, ContainsEdge.class
        ));
    }
}
