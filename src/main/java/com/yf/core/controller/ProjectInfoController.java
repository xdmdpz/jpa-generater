package com.yf.core.controller;


import com.yf.core.base.RestResponse;
import com.yf.core.base.RestResponseCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import com.yf.core.service.ProjectInfoService;
import com.yf.core.entity.ProjectInfo;


/**
* Created by if on 2017/11/22.
* @author if
*/
@RestController
@RequestMapping("ProjectInfo")
public class ProjectInfoController {

	private static Logger logger = Logger.getLogger(ProjectInfoController.class);
	
	@Autowired
	private ProjectInfoService _ProjectInfoService;


	/**
	* 获取列表
	* @param page 页码
	* @param size 分页大小
	* @param response
	* @return
	*/
	@GetMapping("list")
	public RestResponse findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
								@RequestParam(value = "size", defaultValue = "15") Integer size,
								RestResponse response) {
		try {
			Sort sort = new Sort(Sort.Direction.DESC, "createTime");
			Pageable pageable = new PageRequest(page, size, sort);
			response.builder(RestResponseCodeEnum.SUCCESS, "查询成功", _ProjectInfoService.findPage(pageable));
		} catch (Exception e) {
			response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
		}
		return response;
	}

	/**
	* 新增
	*
	* @param entity 新增实体，前端数据需要 JSON.stringify(data)
	* @param response
	* @return
	*/
	@PostMapping
	public RestResponse create(@RequestBody ProjectInfo entity, RestResponse response) {
		try {
			_ProjectInfoService.create(entity);
			response.builder(RestResponseCodeEnum.SUCCESS, "添加成功", null);
		} catch (Exception e) {
			response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
		}
		return response;
	}
	/**
	 * 修改
	 *
	 * @param entity 修改实体，前端数据需要 JSON.stringify(data)
	 * @param response
	 * @return
	 */
	@PostMapping
	public RestResponse update(@RequestBody ProjectInfo entity, RestResponse response) {
		try {
			_ProjectInfoService.update(entity);
			response.builder(RestResponseCodeEnum.SUCCESS, "添加成功", null);
		} catch (Exception e) {
			response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
		}
		return response;
	}
	/**
	* 删除
	*
	* @param id 主键
	* @param response
	* @return
	*/
	@DeleteMapping
	public RestResponse delete(String id, RestResponse response) {
		try {
			ProjectInfo entity = _ProjectInfoService.findByid(id);
			if (entity != null) {
			_ProjectInfoService.delete(entity);
				response.builder(RestResponseCodeEnum.SUCCESS, "删除成功", null);
			} else {
				response.builder(RestResponseCodeEnum.RECORD_EXIST);
			}
		} catch (Exception e) {
			response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
		}
		return response;
	}
}