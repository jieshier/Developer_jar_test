package com.developer_jdk_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cbs.Developer.BulkSendMail;
import cbs.Developer.Model.Request.SearchMailRequest;
import cbs.Developer.Model.Return.PageReturn;
import cbs.Developer.Model.Return.VEmail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller	//return 返回到指定页面
@ResponseBody	//加上此注解return 返回的是 JSON
@RequestMapping("/BulkSendMail")
@Api(tags = "BulkSendMail")
public class BulkSendMailController {

	@RequestMapping(value = "/BulkSendMailSearchByDomain", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value="域名搜索邮箱地址", notes="域名搜索邮箱地址", httpMethod = "POST")
	public Boolean testBulkSendMailSearchByDomain() {
		BulkSendMail bulkSendMail = new BulkSendMail(null, null);
		SearchMailRequest searchMailRequest = new SearchMailRequest();
		searchMailRequest.setUrl("www.baidu.com");
		PageReturn<VEmail> pageRetuen =  bulkSendMail.BulkSendMailSearchByDomain(searchMailRequest);
		if(pageRetuen.getTotalPages() > 0) {
			return true;
		}else {
			return false;
		}
	}
}
