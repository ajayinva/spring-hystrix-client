/**
 * 
 */
package com.aces.learn.spring.hystrix.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aagarwal
 *
 */
@RestController
public class HelloController {		
	@Autowired
	private HelloService helloService;
	
	@Autowired
	private BulkHeadHelloService bulkHeadHelloService;
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/sayHello")
	public String sayHello(){		
		return helloService.sayHello();
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/sayHelloBulkHead")
	public String sayHelloBulkHead(){		
		return bulkHeadHelloService.sayHello();
	}
}
