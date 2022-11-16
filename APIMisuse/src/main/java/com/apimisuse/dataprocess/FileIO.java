package com.apimisuse.dataprocess;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Objects;

public class FileIO {

    public static ArrayList<File> getPaths(File dir) {
        ArrayList<File> files = new ArrayList<>();
        if (dir.isDirectory())
            for (File sub : Objects.requireNonNull(dir.listFiles()))
                files.addAll(getPaths(sub));
        else if (dir.getName().endsWith(".java"))
            files.add(dir);
        return files;
    }

    public static ArrayList<String> getMethods(File file){
        
    }
}