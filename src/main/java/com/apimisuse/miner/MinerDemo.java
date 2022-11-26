package com.apimisuse.miner;

import java.util.Collection;
import com.apimisuse.aug.model.APIUsageExample;
import com.apimisuse.egroum.aug.AUGBuilder;
import com.apimisuse.egroum.aug.AUGConfiguration;
import com.apimisuse.miner.mining.AUGMiner;
import com.apimisuse.miner.mining.Miner;
import com.apimisuse.miner.mining.Model;


public class MinerDemo {

    Collection<APIUsageExample> AUGSet;

    public MinerDemo(String sourcePath, String[] classPath){}

    public void mine(String sourcePath, String[] classPath){
        AUGBuilder builder = new AUGBuilder(new AUGConfiguration());
        this.AUGSet = builder.build(sourcePath,classPath);

        long endTrainingLoadTime = System.currentTimeMillis();

        Miner AUGMiner = new Miner();
        long endTrainingTime = System.currentTimeMillis();
    }


}
