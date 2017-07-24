/**
 * 
 */
package com.aces.learn.spring.hystrix.client;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * @author aagarwal
 *
 */
@Component
public class HelloService {
	/**
	 * 
	 * @return
	 */
	@HystrixCommand(
		commandProperties= {
			@HystrixProperty(
				name="execution.isolation.thread.timeoutInMilliseconds",
				value="5000"
			)}
	,	fallbackMethod = "sayHelloFallback"
	)
	public String sayHello(){
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		if (randomNum==3){					
			try{Thread.sleep(6000);}catch(Exception e){}
		}
		return "Hello from Hystrix Client";
	}
	/**
	 * 
	 * @return
	 */
	public String sayHelloFallback(){		
		return "Hello from Hystrix Client -- Fallback";
	}
}
