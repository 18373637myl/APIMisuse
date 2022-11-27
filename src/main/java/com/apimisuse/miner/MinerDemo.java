package com.apimisuse.miner;

import java.util.Collection;
import com.apimisuse.aug.model.APIUsageExample;
import com.apimisuse.egroum.aug.AUGBuilder;
import com.apimisuse.egroum.aug.AUGConfiguration;
import com.apimisuse.miner.mining.*;

import com.apimisuse.miner.DefaultMiningConfiguration;

public class MinerDemo {

    Collection<APIUsageExample> AUGSet;

    public MinerDemo(){}

    public void mine(String sourcePath, String classPath){
        AUGBuilder builder = new AUGBuilder(new AUGConfiguration());
        String[] sourcePaths = sourcePath.split(":");
        String[] classPaths = classPath.split(":");
        this.AUGSet = builder.build(sourcePaths,classPaths);

        long endTrainingLoadTime = System.currentTimeMillis();

        DefaultAUGMiner AUGMiner = new DefaultAUGMiner(new DefaultMiningConfiguration());
        Model model = AUGMiner.mine(this.AUGSet);
        System.out.println(model.getPatterns().size());
        long endTrainingTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        MinerDemo minerDemo = new MinerDemo();
        minerDemo.mine("./", "./");
    }


}
