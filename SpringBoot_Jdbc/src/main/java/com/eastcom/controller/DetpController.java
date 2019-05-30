package com.eastcom.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eastcom.service.DeptService;
import com.eastcom.sql.bean.Dept;
import com.eastcom.sql.bean.JsonResult;
import com.eastcom.sql.bean.ParamDto;
import com.eastcom.sql.bean.Status;

@Controller
@RequestMapping("/jdbc")
public class DetpController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value="/select",method=RequestMethod.GET)
	public ResponseEntity<JsonResult> selectById(Integer id){
		JsonResult result = new JsonResult();
		try {
			Dept data = deptService.selectById(id);
			result.setData(data);
			result.setStatus(Status.OK);
		} catch (Exception e) {
			result.setStatus(Status.ERROR);
			result.setData(e.getClass()+":"+e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok(result); 
	}
	
	//@RequestBody:把接收到的json字符串自动转换为所对应的对象
	/**
	 * @param dept  { "deptno":"60", "dname":"开发", "location":"上海" }
	 * @return
	 */
	@PostMapping(value="/insert")
	public ResponseEntity<JsonResult> insert(@RequestBody Dept dept){
		JsonResult result = new JsonResult();
		try {
			Integer insert = deptService.insert(dept);
			result.setData(insert);
			result.setStatus(Status.OK);
		} catch (Exception e) {
			result.setStatus(Status.ERROR);
			result.setData(e.getClass()+":"+e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok(result); 
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<JsonResult> update(@RequestBody ParamDto dto){
		JsonResult result = new JsonResult();
		try {
			System.out.println("dto:"+ dto.toString());
			Integer update = deptService.updateById(dto.getId(),dto.getDept());
			result.setData(update);
			result.setStatus(Status.OK);
		} catch (Exception e) {
			result.setStatus(Status.ERROR);
			result.setData(e.getClass()+":"+e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok(result); 
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<JsonResult> delete(@RequestParam("id") String id,HttpServletRequest request){
		JsonResult result = new JsonResult();
		try {
			System.out.println("id :"+id);
			Integer delete = deptService.deleteById(Integer.parseInt(id));
			result.setData(delete);
			result.setStatus(Status.OK);
		} catch (Exception e) {
			result.setStatus(Status.ERROR);
			result.setData(e.getClass()+":"+e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok(result); 
	}
	
	/*
	 * Content-Type=application/json，请求方式post，使用@RequestBody，单个参数直接写值,是对象时写json串
	 * delete(@RequestBody String id)
	 * 
	 * Content-Type=application/x-www-form-urlencoded，请求方式post，单个参数直接id=61,多个用&拼接
	 * delete(@RequestParam("id") String id)
	 * 
	 * */
}
