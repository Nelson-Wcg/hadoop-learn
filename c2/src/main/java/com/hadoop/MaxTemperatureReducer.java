package com.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int maxTrmperature = Integer.MIN_VALUE;
        for (IntWritable value : values) {
            maxTrmperature = Math.max(maxTrmperature, value.get());
        }
        context.write(key, new IntWritable(maxTrmperature));

    }
}
