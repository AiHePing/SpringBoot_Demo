package com.eastcom.error;


import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		if ((int)errorAttributes.get("status")==500) {
			errorAttributes.replace("message", "服务器内部错误");
		}
		return errorAttributes;
	}
}
