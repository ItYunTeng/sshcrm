package com.ithc.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
@SuppressWarnings("all")
public class JsonUtil {

	/**
	 * 禁止循环引用
	 * @param object
	 * @return
	 */
	public static String JsonString(Object object){
		
		return JSON.toJSONString(object,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	public static void write(HttpServletResponse response,String jsonString) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");;
		PrintWriter writer = response.getWriter();
		writer.print(jsonString);
	}
	
}
