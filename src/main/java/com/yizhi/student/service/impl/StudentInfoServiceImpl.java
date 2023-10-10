package com.yizhi.student.service.impl;

import com.yizhi.common.utils.PageUtils;
import com.yizhi.common.utils.R;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.yizhi.student.dao.StudentInfoDao;
import com.yizhi.student.domain.StudentInfoDO;
import com.yizhi.student.service.StudentInfoService;



@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	private StudentInfoDao studentInfoDao;
	
	@Override
	public StudentInfoDO get(Integer id){
		System.out.println("======service层中传递过来的id参数是：" + id + "======");
		return studentInfoDao.get(id);
	}


	@Override
	public List<StudentInfoDO> list(Map<String, Object> map){

		PageUtils.toMap(map);
		return studentInfoDao.list(map);
	}

	//"===================================================================================="

	@Override
	public int count(Map<String, Object> map){
		return studentInfoDao.count(map);
	}

	//添加学生信息的业务方法
	@Override
	public R save(StudentInfoDO studentInfo){
		//判断学生信息是否已经存在
		StudentInfoDO sid = studentInfoDao.get(studentInfo.getId());
		if(sid != null){//说明学生信息已经存在
			return R.error(500,"学生信息已经存在");
		}
		int i = studentInfoDao.save(studentInfo);
		if(i > 0){
			return R.ok("添加学生信息成功");
		}
		return R.error(500,"添加学生信息失败");
	}

	//修改学生信息的业务方法
	@Override
	public R update(StudentInfoDO studentInfo){
		int i = studentInfoDao.update(studentInfo);
		if(i > 0){
			return R.ok("修改学生信息成功");
		}
		return R.error(500,"修改学生信息失败");
	}

	//根据学生id删除学生信息的业务方法
	@Override
	public R remove(Integer id){
		int i = studentInfoDao.remove(id);
		if(i > 0){
			return R.ok("删除学生信息成功");
		}
		return R.error(500,"删除学生信息失败");
	}

	//根据学生ids批量删除学生信息的业务方法
	@Override
	public R batchRemove(Integer[] ids){
		int i = studentInfoDao.batchRemove(ids);
		if(i > 0){
			return R.ok("删除学生信息成功");
		}
		return R.error(500,"删除学生信息失败");
	}
}
