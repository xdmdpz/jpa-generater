package com.yf.sys.controller;

import com.yf.core.base.RestResponse;
import com.yf.core.base.RestResponseCodeEnum;
import com.yf.sys.entity.SysDict;
import com.yf.sys.service.SysDictService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by if on 2017/11/22.
 *
 * @author if
 */
@RestController
@RequestMapping("SysDict")
public class SysDictController {

    private static Logger logger = Logger.getLogger(SysDictController.class);

    @Autowired
    private SysDictService _SysDictService;


    /**
     * 获取列表
     *
     * @param response
     * @return
     */
    @GetMapping("list")
    public RestResponse findAll(RestResponse response) {
        try {
            response.builder(RestResponseCodeEnum.SUCCESS, "查询成功", _SysDictService.findList(null));
        } catch (Exception e) {
            response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
        }
        return response;
    }

    /**
     * 新增
     *
     * @param entity   新增实体，前端数据需要 JSON.stringify(data)
     * @param response
     * @return
     */
    @PostMapping
    public RestResponse create(@RequestBody SysDict entity, RestResponse response) {
        try {
            _SysDictService.create(entity);
            response.builder(RestResponseCodeEnum.SUCCESS, "添加成功", null);
        } catch (Exception e) {
            response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
        }
        return response;
    }

    /**
     * 更新
     *
     * @param entity   更新实体，前端数据需要 JSON.stringify(data)
     * @param response
     * @return
     */
    @PatchMapping
    public RestResponse update(@RequestBody SysDict entity, RestResponse response) {
        try {
            _SysDictService.update(entity);
            response.builder(RestResponseCodeEnum.SUCCESS, "添加成功", null);
        } catch (Exception e) {
            response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
        }
        return response;
    }

    /**
     * 删除
     *
     * @param id       主键
     * @param response
     * @return
     */
    @DeleteMapping
    public RestResponse delete(String id, RestResponse response) {
        try {
            SysDict entity = _SysDictService.findByid(id);
            if (entity != null) {
                _SysDictService.delete(entity);
                response.builder(RestResponseCodeEnum.SUCCESS, "删除成功", null);
            } else {
                response.builder(RestResponseCodeEnum.RECORD_EXIST);
            }
        } catch (Exception e) {
            response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
        }
        return response;
    }

    /**
     * 获取字典表
     *
     * @param response
     * @return
     */
    @GetMapping
    public RestResponse getDictsByType(String type, RestResponse response) {
        try {
            if (type != null && !type.equals(""))
                response.builder(RestResponseCodeEnum.SUCCESS, "查询成功", _SysDictService.getDictsByType(type));
            else
                response.builder(RestResponseCodeEnum.SUCCESS, "查询成功", _SysDictService.findList(null));
        } catch (Exception e) {
            response.builder(RestResponseCodeEnum.FAILED, "系统出现bug:" + e.getMessage(), null);
        }
        return response;
    }
}