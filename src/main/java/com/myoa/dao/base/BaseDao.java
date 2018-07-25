package com.myoa.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 基础Dao接口
 * @author caihua
 * @date 2018年7月8日
 */
public interface BaseDao<T> {

	/**
	 * 保存实体
	 * @param t
	 * @return
	 */
	int save(T t);
	
	/**
	 * 根据ID查询实体信息
	 * @param id 实体ID
	 * @return 返回base实体
	 */
	T getById(@Param("id") String id);

	/**
	 * 更新实体
	 * @param t 实体
	 */
	void update(T t);

	/**
	 * 查询所有
	 * @return 返回list数组
	 */
	List<T> listAll();

	/**
	 * 根据id删除实体
	 * @param id 要删除的主键id
	 */
	void deleteById(@Param("id") String id);

	/**
	 * 批量新增
	 * @param list 新增数据
	 */
	void saveBatch(@Param("list") List<T> list);

	/**
	 * 根据id集合实现批量的删除
	 * @param ids id集合
	 */
	void deleteByIds(@Param("ids") String[] ids);

	/**
	 * 分页查询
	 * @param pageNo 页码
	 * @param pageSize 显示条数
	 * @param orderBy 排序字段
	 * @param order 排序方式,true:asc;fales:desc
	 * @return 返回list数组
	 */
	List<T> listByPage(@Param("pageNo") int pageNo,
			@Param("pageSize") int pageSize, @Param("orderBy") String orderBy,
			@Param("order") boolean order);

	/**
	 * 查询数据表中记录集合总数
	 * @return 返回查询总条数
	 */
	int getCount();

	/**
	 * 动态sql查询
	 * @param table 表名称
	 * @param fields list集合
	 * @param wheres 条件　都是key-value对应
	 * @param begin 开始位置
	 * @param end 结束位置
	 * @param order 排序方式,true:asc;fales:desc
	 * @return 返回查询结果
	 */
	List getBySQL(@Param("table") String table,
			@Param("fields") List<String> fields,
			@Param("wheres") Map<String, Object> wheres,
			@Param("begin") Integer begin, 
			@Param("end") Integer end,
			@Param("order") String order);

	/**
	 * 总数
	 * @param table 表名称
	 * @param wheres 条件　都是key-value对应
	 * @return　总数
	 */
	int countBySQL(@Param("table") String table,
			@Param("wheres") Map<String, Object> wheres);

	/**
	 * 动态SQL更新
	 * @param table 表名称
	 * @param fields list集合每个map都是key-value对应
	 * @param wheres 条件 都是key-value对应
	 */
	void updateBySQL(@Param("table") String table,
			@Param("fields") Map fields,
			@Param("wheres") Map<String, Object> wheres);

	/**
	 * 动态SQL删除
	 * @param table 表名称
	 * @param wheres 條件 都是key-value对应
	 */

	void deleteBySQL(@Param("table") String table,
			@Param("wheres") Map<String, Object> wheres);

	/**
	 * 添加记录
	 * @param table 表名称
	 * @param fields 编号
	 */
	void insertBySQL(@Param("table") String table,
			@Param("fields") Map<String, Object> fields);

	// public void createTable(@Param("table") String table, @Param("fileds")
	// Map<Object, List> fileds);

	/**
	 * 动态建表
	 * @param table
	 * @param list
	 */
//	void createTable(@Param("table") String table,
//			@Param("fieldsList") List<TableMata> list);

	/**
	 * 修改表
	 * @param table 表名称
	 * @param fileds key:字段名称 list[0] 类型 list[1]长度 list[2]默认值 list[3]是否不填
	 */
	void alterTable(@Param("table") String table,
			@Param("fileds") Map fileds, @Param("type") String type);

	/**
	 * 删除表
	 * @param table 表名称
	 */
	void dropTable(@Param("table") String table);

	/**
	 * 导入执行数据
	 * @param sql sql语句
	 */
	void excuteSql(@Param("sql") String sql);
}
