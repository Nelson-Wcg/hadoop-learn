package com.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * 将本地文件复制到hdfs
 */
public class FileCopyWithProgress {
    public static void main(String[] args) throws Exception {
        String localSrc = "/Users/mac/out";
        System.out.println(1);
        String dst = "hdfs://localhost:9000/out.txt";
        System.out.println(2);
        InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
        System.out.println(3);

        Configuration conf = new Configuration();
        System.out.println(4);
        FileSystem fs = FileSystem.get(URI.create(dst), conf);
        System.out.println(5);
        OutputStream out = fs.create(new Path(dst), new Progressable() {
            public void progress() {
                System.out.print(".");
            }
        });
        IOUtils.copyBytes(in, out, 4096, true);
    }
}
