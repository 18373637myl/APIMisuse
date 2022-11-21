package com.apimisuse.aug.persistence;

import com.google.common.base.Charsets;
import com.apimisuse.aug.model.APIUsageGraph;
import com.apimisuse.aug.model.dot.AUGDotExporter;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AUGWriter implements AutoCloseable {
    private final ZipOutputStream zip;
    private final AUGDotExporter exporter;

    public AUGWriter(OutputStream out, AUGDotExporter exporter) {
        zip = new ZipOutputStream(out);
        this.exporter = exporter;
    }

    public void write(APIUsageGraph graph, String graphName) throws IOException {
        zip.putNextEntry(new ZipEntry(graphName + ".dot"));
        zip.write(exporter.toDotGraph(graph).getBytes(Charsets.UTF_8));
        zip.closeEntry();
    }

    @Override
    public void close() throws IOException {
        zip.close();
    }
}
