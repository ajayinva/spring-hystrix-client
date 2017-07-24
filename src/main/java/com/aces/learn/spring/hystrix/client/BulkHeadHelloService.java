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
public class BulkHeadHelloService {
	/**
	 * 
	 * @return
	 */
	@HystrixCommand(
		fallbackMethod = "sayHelloFallback"
	,	threadPoolKey = "helloServiceThreadPool"
	,	threadPoolProperties= {
			@HystrixProperty(
				name="coreSize",
				value="30"
			)
		,	@HystrixProperty(
				name="maxQueueSize",
				value="10"
			)
		}		
	)
	public String sayHello(){
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		if (randomNum==3){					
			try{Thread.sleep(6000);}catch(Exception e){}
		}
		return "Hello from BulkHead Hystrix Client";
	}
	/**
	 * 
	 * @return
	 */
	public String sayHelloFallback(){		
		return "Hello from Hystrix Client -- Fallback";
	}
}
