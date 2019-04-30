package com.eastcom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eastcom.service.DeptService;
import com.eastcom.sql.bean.Dept;
import com.eastcom.sql.bean.JsonResult;

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
			result.setStatus("ok");
		} catch (Exception e) {
			result.setStatus("error");
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
			result.setStatus("ok");
		} catch (Exception e) {
			result.setStatus("error");
			result.setData(e.getClass()+":"+e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok(result); 
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<JsonResult> update(Integer id,@RequestBody Dept dept){
		JsonResult result = new JsonResult();
		try {
			Integer update = deptService.update(id,dept);
			result.setData(update);
			result.setStatus("ok");
		} catch (Exception e) {
			result.setStatus("error");
			result.setData(e.getClass()+":"+e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok(result); 
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<JsonResult> delete(Integer id){
		JsonResult result = new JsonResult();
		try {
			Integer delete = deptService.deleteById(id);
			result.setData(delete);
			result.setStatus("ok");
		} catch (Exception e) {
			result.setStatus("error");
			result.setData(e.getClass()+":"+e.getMessage());
			e.printStackTrace();
		}
		return ResponseEntity.ok(result); 
	}
}
