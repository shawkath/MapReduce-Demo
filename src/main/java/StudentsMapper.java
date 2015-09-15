import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StudentsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


	public void map(LongWritable key, Text value, Context context) throws IOException,
			InterruptedException {
		String line = value.toString();
		// Key for the data
		String[] students = line.split(",");
		System.out.println(students[0]);
		String marks = line.substring(line.indexOf(",") + 1);
		List<String> mark = Arrays.asList(marks.split("\\s*, \\s*"));
		ArrayList<Integer> resultList = getIntegerArray(mark); 
		int maxMark = Collections.max(resultList);
		context.write(new Text(students[0]), new IntWritable(maxMark));
	}

	public static ArrayList<Integer> getIntegerArray(List<String> stringArray) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (String stringValue : stringArray) {
			try {
				result.add(Integer.parseInt(stringValue));
			} catch (NumberFormatException nfe) {
			}
		}
		return result;
	}

}
