package in.springboot.webservices.springboottech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.*;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;


public class Processing {

	private static final transient Logger LOGGER = Logger.getLogger(Processing.class);

	public void getFibonacciResult(Exchange exchange){
		long n=1000, t1=0,t2=1;
		List list = new ArrayList<>();
		for(int i = 2;i<=n;++i){
			list.add(t1);
			long sum = t1+t2;
			t1 = t2;
			t2 = sum;
		}
		exchange.getIn().setHeader("Result",list);
	}
}
