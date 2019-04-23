package com.eastcom.error;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ErrorController {
	@GetMapping(value="/hello")//spring4.3.0的新特性
	public String error() {
		boolean a=true;
		if (a) {
			throw new NullPointerException();
		}
		return "报错";
	}
}
