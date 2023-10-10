package com.yizhi.student.service;

import com.yizhi.common.utils.R;
import com.yizhi.student.domain.StudentInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 生基础信息表
 * 
 * @author dunhf
 * @email 499345515@qq.com
 * @date 2019-08-01 09:45:46
 */
public interface StudentInfoService {

	//根据id查询学生信息的业务方法
	StudentInfoDO get(Integer id);

	//分页查询学生信息的业务方法
	List<StudentInfoDO> list(Map<String, Object> map);

	//查询学生信息的总行数的业务方法
	int count(Map<String, Object> map);

	//添加学生信息的业务方法
	R save(StudentInfoDO studentInfo);

	//修改学生信息的业务方法
	R update(StudentInfoDO studentInfo);

	//根据学生id删除学生信息的业务方法
	R remove(Integer id);

	//根据学生ids批量删除学生信息的业务方法
	R batchRemove(Integer[] ids);
}
