package com.developer_jdk_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cbs.Developer.Developer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller	//return 返回到指定页面
@ResponseBody	//加上此注解return 返回的是 JSON
@RequestMapping("/BusinessData")
@Api(tags = "BusinessData")
public class BusinessDataController {

	@RequestMapping(value = "/BusinessDataCompanyProfile", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value="公司简况", notes="公司简况", httpMethod = "GET")
	public Boolean testBusinessDataCompanyProfile() {
		Developer developer = new Developer(null, null);
		Object data = developer.BusinessDataCompanyProfile("744303884");
		if(StringUtils.isEmpty(data)) {
			return true;
		}else {
			return false;
		}
	}
}
