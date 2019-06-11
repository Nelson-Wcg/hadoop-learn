package com.hadoop;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * 从Hadoop Url 读取文件
 */
public class URLCat {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) {
        InputStream in = null;

        try {
            in = new URL("hdfs://localhost:9000/max/part-r-00000").openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
