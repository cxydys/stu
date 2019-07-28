package com.guli.teacher.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.Result;
import com.guli.teacher.entity.EduTeacher;
import com.guli.teacher.entity.TeacherQuery;
import com.guli.teacher.service.EduTeacherService;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author javali
 * @since 2019-07-25
 */
@RestController
@RequestMapping("/teacher/edu-teacher")
@Api(description = "讲师管理")
public class EduTeacherController {
    @Autowired
    EduTeacherService duTeacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("list")
    public Result getList() {
        List<EduTeacher> list = duTeacherService.list(null);
        return Result.ok().data("list", list);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据ID删除讲师")
    public Result removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        Boolean b = duTeacherService.removeById(id);
        if (b) {
            return Result.ok();
        }
        return Result.error();
    }

    //多条件组合查询带分页
    @PostMapping("{page}/{limit}")
    public Result selectUserByPage(@PathVariable long page,
                                   @PathVariable long limit,
                                   @RequestBody TeacherQuery teacherQuery) {
        Page<EduTeacher> page1 = new Page<>(page, limit);
        duTeacherService.getPageTeacher(page1, teacherQuery);
        return Result.ok().data("row", page1.getRecords()).data("total", page1.getTotal());

    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("addTeacher")
    public Result save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher) {
        boolean save = duTeacherService.save(teacher);
        if (save) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("{id}")
    public Result getInfoTeacher(@PathVariable String id) {
        EduTeacher byId = duTeacherService.getById(id);
        return Result.ok().data("teacher", byId);

    }

    @ApiOperation(value = "根据id修改")
    @PostMapping()
    public Result alterTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean updateById = duTeacherService.updateById(eduTeacher);
        if (updateById) {
            return Result.ok();
        } else {
            return Result.error();
        }

    }

}

