package com.apimisuse.miner.mining;

import com.apimisuse.aug.model.APIUsageExample;

import java.util.Collection;

public interface AUGMiner {
    Model mine(Collection<APIUsageExample> examples);
}
