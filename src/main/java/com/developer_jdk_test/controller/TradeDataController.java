package com.developer_jdk_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cbs.Developer.Developer;
import cbs.Developer.QueryVersion;
import cbs.Developer.Model.Enum.SearchTypeEnum;
import cbs.Developer.Model.Enum.SortType;
import cbs.Developer.Model.Request.BillDetailsRequest;
import cbs.Developer.Model.Request.SearchTradeDataRequest;
import cbs.Developer.Model.Request.SearchTradeDataRequest.TradeDataSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller	//return 返回到指定页面
@ResponseBody	//加上此注解return 返回的是 JSON
@RequestMapping("/TradeData")
@Api(tags = "BILL")
public class TradeDataController {
	private QueryVersion queryVersion;

	@RequestMapping(value = "/info", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value="版本信息",notes="版本信息查询", httpMethod = "GET")
	public Object test() {
		queryVersion = new QueryVersion();
		String strApiInfo = queryVersion.info();
		Object obj = JSONArray.toJSON(strApiInfo);
		return obj;
	}
	
	@RequestMapping(value = "/TradeDataDetailsBill", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value="查询提单明细", notes="查询提单明细", httpMethod = "POST")
	public Boolean testTradeDataDetailsBill() {
		Developer developer = new Developer(null, null);
		BillDetailsRequest request = new BillDetailsRequest();
    	request.setCountryCode("USA2");
    	request.setTradeKey("69EC8045-1B09-4A95-A76B-6AC8052DC180");
    	request.setIe("i");
    	request.setDataType("Bill");
    	request.setLanguages("cn");
		Object data = developer.TradeDataDetailsBill(request);
		System.out.println("有数据吗："+data);
		if(StringUtils.isEmpty(data)) {
			return true;
		}else {
			return false;
		}
	}
	
	@RequestMapping(value = "/TradeDataExport", produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value="贸易记录 下载", notes="贸易记录 下载", httpMethod = "POST")
	public Boolean testTradeDataExport() {
		Developer developer = new Developer(null, null);
		TradeDataSearch request = new SearchTradeDataRequest().new TradeDataSearch();
		request.set_keydoc("Led");
		request.setIe("i");
		request.setStartDate("2019-01-01");
		request.setEndDate("2019-10-01");
		request.setIsShip(true);
		request.setSearchType(SearchTypeEnum.Product);
		request.setSortType(SortType.Frequency);
		request.setLanguages("cn");
		request.setDownloadNum(20);
		request.setSmtpIndex(0);
		request.setThreeEnCountryCode("USA");
		request.setPageIndex(1);
		request.setPageSize(10);
		byte[] b = developer.TradeDataExport(request);
		if(b==null) {
			return false;
		}else {
			return true;
		}
	}
	
}
