package com.myoa.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 基础服务实现类
 * @author caihua
 * @date 2018年7月8日
 */
public abstract class BaseService<T> {

	/** 注入通用Mapper */
    @Autowired
    private Mapper<T> mapper;
    
    /**
     * 查询所有
     * @return
     */
    public List<T> listAll(){
        return mapper.select(null);
    }
    
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public T getById(String id){
        return mapper.selectByPrimaryKey(id);
    }
    
    /**
     * 根据条件查询 
     * @param param
     * @return
     */
    public List<T> getByWhere(T param){
        return mapper.select(param);
    }
    
    /**
     * 根据条件查询数量
     * @param param
     * @return
     */
    public Integer getCountByWhere(T param){
        return mapper.selectCount(param);
    }
    
    /**
     * 条件分页查询
     * @param param
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<T> listByPage(T param, Integer page, Integer rows){
        PageHelper.startPage(page, rows);
        //调用根据条件查询方法
        List<T> list = this.getByWhere(param);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }
    
    /**
     * 根据条件查询一条数据
     * @param param
     * @return
     */
    public T getOneByWhere(T param){
        return mapper.selectOne(param);
    }
    
    /**
     * 新添记录
     * @param t
     * @return
     */
    public void save(T t){
        mapper.insert(t);
    }
    
    /**
     * 选择性地插入
     * <pre>
     * 使用不为null的属性作为字段进行插入(只插入不为null的)
     * </pre>
     * @param t
     * @return
     */
    public void saveSelective(T t){
        mapper.insertSelective(t);
    }
    
    /**
     * 根据主键更新记录
     * @param t
     * @return
     */
    public void updateByPK(T t){
        mapper.updateByPrimaryKey(t);
    }
    
    /**
     * 根据主键选择性地更新
     * <pre>
     * 使用不为null的属性作为字段进行更新(只更新不为null的)
     * </pre>
     * @param t
     * @return
     */
    public void updateBySelective(T t){
        mapper.updateByPrimaryKeySelective(t);
    }
    
    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    public void deleteById(Long id){
        mapper.deleteByPrimaryKey(id);
    }
    
    /**
     * 批量删除
     * @param ids
     * @param clazz
     * @return
     */
    public void deleteByIds(List<Object> ids, Class<T> clazz){
        Example example = new Example(clazz);
        example.createCriteria().andIn("id", ids);
        mapper.deleteByExample(example);
    }
}
