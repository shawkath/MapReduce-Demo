import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class StudentsReducer extends Reducer<Text,IntWritable,Text,IntWritable>{

		public void reduce(Text key,  Iterable<IntWritable> values,Context context ) throws IOException, InterruptedException {
			  Iterator<IntWritable> it=values.iterator();
			  int maxMarks = 0;
			  while (it.hasNext()) {
				  IntWritable tmp=it.next();
				  if(tmp.get() > maxMarks){
					  maxMarks =tmp.get();
				  }				  
			
			  }
			  context.write(key, new IntWritable(maxMarks));
		}
				
}
