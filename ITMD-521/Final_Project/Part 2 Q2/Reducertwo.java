// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducertwo
  extends Reducer<Text, IntWritable, Text, IntWritable> {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    int sum=0;
    int count=0;
    for (IntWritable value : values) {
      sum += value.get();
      count++;
    }
    int average = Math.round(sum/count);
    context.write(key, new IntWritable(average));
  }
}
// ^^ MaxTemperatureReducer
