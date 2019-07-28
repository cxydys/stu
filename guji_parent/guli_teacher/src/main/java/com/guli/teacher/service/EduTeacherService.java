package com.guli.teacher.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.teacher.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.teacher.entity.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author javali
 * @since 2019-07-25
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void getPageTeacher(Page<EduTeacher> page1, TeacherQuery teacherQuery);
}
