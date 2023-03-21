package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.excelVO.UserExcelVO;

import java.util.List;
import java.util.Map;

/**
 * 用户信息servcie接口
 */
public interface UserService {
    /**
     * 新增
     *
     * @param entity
     * @return
     */
    int insert(UserEntity entity);

    /**
     * 条件查询
     *
     * @param entity
     * @return
     */
    List<UserEntity> findByWhere(UserEntity entity);

    /**
     * 检查是否存在该用户名
     *
     * @param userName
     * @return
     */
    int checkForPresence(String userName);

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    int update(UserEntity entity);

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    int delete(List<String> list);

    /**
     * 获取所有数据（返回map）
     *
     * @return
     */
    List<Map<String, Object>> getAllData();

    /**
     * 获取导出excel数据
     *
     * @param vo
     * @return
     */
    List<UserExcelVO> findUserExcelData(UserExcelVO vo);

    /**
     * 批量插入数据
     *
     * @param list
     * @return
     */
    int batchInsert(List<UserExcelVO> list);
}
