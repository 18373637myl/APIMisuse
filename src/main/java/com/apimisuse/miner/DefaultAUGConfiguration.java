package com.apimisuse.miner;


import com.apimisuse.egroum.aug.AUGConfiguration;

public class DefaultAUGConfiguration extends AUGConfiguration {
    {
        minStatements = 0;
        groum = false;

        collapseIsomorphicSubgraphs = true;

        collapseTemporaryDataNodes = false;
        collapseTemporaryDataNodesIncomingToControlNodes = true;

        encodeUnaryOperators = false;
        encodeConditionalOperators = false;

        buildTransitiveDataEdges = false;

        removeImplementationCode = 2;
    }
}
