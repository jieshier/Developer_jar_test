package com.developer_jdk_test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cbs.Developer.Developer;
import cbs.Developer.Model.Return.Country;
import cbs.Developer.Model.Return.CountryFlagReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller	//return 返回到指定页面
@ResponseBody	//加上此注解return 返回的是 JSON
@RequestMapping("/Standard")
@Api(tags = "Standard")
public class StandardController {

	@RequestMapping(value = "/StandardCountry" , produces = { "application/json;charset=UTF-8" })
	@ApiResponses(value= {
			@ApiResponse(code = 400,message="参数错误"),
			@ApiResponse(code = 401,message="未授权"),
			@ApiResponse(code = 403,message="拒绝执行此请求"),
			@ApiResponse(code = 404,message="系统资源未发现"),
			@ApiResponse(code = 500,message="系统错误"),
			@ApiResponse(code = 200,message="success",response=String.class)
	})
	@ApiOperation(value="获取 统一国家代码信息",notes="获取 统一国家代码信息", httpMethod = "GET")
	public Boolean testStandardCountry() {
		Developer developer = new Developer(null, null);
    	List<Country> countries = developer.StandardCountry();
    	if(countries != null) {
    		return true;
    	}else {
    		return false;
    	}
	}
	
	@RequestMapping(value = "/StandardCountryFlag", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value="获取 国家数据 带国旗测试", notes="获取 国家数据 带国旗测试", httpMethod = "GET")
	public Boolean testStandardCountryFlag() {
		Developer developer = new Developer(null, null);
    	List<CountryFlagReturn> countryFlags = developer.StandardCountryFlag();
    	if(countryFlags != null) {
    		return true;
    	}else {
    		return false;
    	}
	}
}
