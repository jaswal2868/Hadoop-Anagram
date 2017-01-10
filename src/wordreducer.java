//package wordcount;

import java.io.IOException;
import java.util.Iterator;

//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class wordreducer extends MapReduceBase implements Reducer<Text,Text,Text,Text> {

	@Override
	public void configure(JobConf arg0) {
		
	}

	@Override
	public void close() throws IOException {
		
	}

	@Override
	public void reduce(Text key, Iterator<Text> value, OutputCollector<Text,Text> output, Reporter r)
			throws IOException {
		String s;
		s=key.toString();
		s=permutation(s);
		
		
		output.collect(key,new Text(s));
	}




	public static String permutation(String str) { 
        String s=permutation("", str);
        return s;
    }

    private static String permutation(String prefix, String str) {
    	int n = str.length();
    	String s="";
        if (n == 0) 
        	return prefix+",";
        else {
            for (int i = 0; i < n; i++)
                s=s+permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            
        }
		return s;
    }

}