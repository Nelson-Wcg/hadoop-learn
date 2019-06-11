package com.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * 通过FileSystem API读取文件
 */
public class FileSystemCat {
    public static void main(String[] args) throws IOException {
        String path = "hdfs://localhost:9000/max/part-r-00000";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(path), conf);
        InputStream in = null;
        try {


            in = fs.open(new Path(path));
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }

    }

}
