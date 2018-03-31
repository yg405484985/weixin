package com.hzit.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * 
 * @author THINK
 *
 */
@EnableAutoConfiguration
@RestController
public class TestController {

	@RequestMapping(value = "test")
	public String test() {
		return "hello";
	}

}
