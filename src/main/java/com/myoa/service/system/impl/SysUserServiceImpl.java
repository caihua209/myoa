package com.myoa.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myoa.dao.system.SysUserMapper;
import com.myoa.pojo.system.SysUser;
import com.myoa.service.base.BaseService;

/**
 * 用户服务接口实现类
 * @author caihua
 * @date 2018年7月8日
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseService<SysUser>{

	@Autowired
    private SysUserMapper sysUserMapper;
	
}
