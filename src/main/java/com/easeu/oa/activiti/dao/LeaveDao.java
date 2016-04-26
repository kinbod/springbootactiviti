package com.easeu.oa.activiti.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.easeu.oa.activiti.entity.oa.Leave;

/**
 * 请假实体管理接口
 *
 * @author HenryYan
 */
@Component
public interface LeaveDao extends CrudRepository<Leave, Long> {
}
