package com.apimisuse.miner;

import java.lang.module.Configuration;
import java.util.Collection;
import com.apimisuse.aug.model.APIUsageExample;
import com.apimisuse.egroum.aug.AUGBuilder;
import com.apimisuse.egroum.aug.AUGConfiguration;


public class Miner {

    Collection<APIUsageExample> AUGSet;

    public Miner(String sourcePath, String[] classPath){}

    public void mine(String sourcePath, String[] classPath){
        AUGBuilder builder = new AUGBuilder(new AUGConfiguration());
        this.AUGSet = builder.build(sourcePath,classPath);
    }
}
