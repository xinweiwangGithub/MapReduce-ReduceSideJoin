package myhadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author xinwei
 * 
 * Mapper for customer_info table.
 * Input pair: LongWritable-no use, Text-raw data of this id
 * Output pair: CustomerIdKey-encapsulated customer info, JoinGenericWritable-double encapsulated state info
 * Next step: JoinReducer.java
 */

public class CustomerMapper extends Mapper<LongWritable, Text, CustomerIdKey, JoinGenericWritable> {
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, CustomerIdKey, JoinGenericWritable>.Context context)
			throws IOException, InterruptedException {
		
		String[] recordFields = value.toString().split(",");
		//get customer id
		int customerId = Integer.parseInt(recordFields[0]);
		//get customer state
		String state = recordFields[4];
		
		CustomerIdKey recordKey = new CustomerIdKey(customerId, CustomerIdKey.CUSTOMER_RECORD); //output key
		CustomerRecord record = new CustomerRecord(state); // output value before encapsulation
		
		// encapsulate output value
		JoinGenericWritable genericRecord = new JoinGenericWritable(record); //output value
		
		// output key-value pair, write into mapper context
		context.write(recordKey, genericRecord);
	}
}