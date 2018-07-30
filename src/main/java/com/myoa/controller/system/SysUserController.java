package com.myoa.controller.system;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myoa.controller.base.BaseController;
import com.myoa.pojo.base.JsonResult;
import com.myoa.pojo.system.SysUser;
import com.myoa.service.system.impl.SysUserServiceImpl;
import com.myoa.util.UuidUtil;

/**
 * 用户管理控制器
 * @author caish
 * @date 2018年7月13日 
 */
@Controller
@RequestMapping(value="/sysUser")
public class SysUserController extends BaseController {

	@Autowired
    private SysUserServiceImpl sysUserService;
	
	/**
     * 添加或修改系统用户
     * @param sysUser
     * @return
     */
	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public JsonResult<SysUser> saveOrUpdate(SysUser sysUser) {
		JsonResult<SysUser> result = new JsonResult<>();
		String userId = sysUser.getUserId();
		// 主键不为空为更新
		if (StringUtils.isNotBlank(userId)) {
			try {
				String userPwd = "加密";
				sysUser.setPassword(userPwd);
				// 调用基础service方法
				sysUserService.updateByPK(sysUser);
				result.setSuccess(true);
				result.setMessage("修改成功");
			} catch (Exception e) {
				result.setSuccess(false);
				result.setMessage("修改失败");
				e.printStackTrace();
			}
		} else {// 主键为空为新增
			sysUser.setUserId(UuidUtil.get32UUID());
			String password = sysUser.getPassword();
			sysUser.setPassword(password + "加密");
			try {
				sysUserService.save(sysUser);
				result.setSuccess(true);
				result.setMessage("新增成功");
			} catch (Exception e) {
				result.setSuccess(false);
				result.setMessage("新增失败");
				e.printStackTrace();
			}
		}
		return result;
	}
    
    /**
     * 删除系统用户
     * @param ids
     * @return
     */
    @RequestMapping(value="/delete")
    @ResponseBody
    public JsonResult<SysUser> deleteSysUser(@RequestParam("ids") String[] ids){
    	JsonResult<SysUser> result = new JsonResult<>();
        try {
        	sysUserService.deleteByIds(Arrays.asList(ids), SysUser.class);
        	result.setSuccess(true);
			result.setMessage("删除成功");
        } catch (Exception e) {
        	result.setSuccess(false);
			result.setMessage("删除失败");
			e.printStackTrace();
        }
		return result;
    }
}
