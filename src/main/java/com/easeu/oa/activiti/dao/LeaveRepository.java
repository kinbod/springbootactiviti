package com.easeu.oa.activiti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easeu.oa.activiti.entity.oa.Leave;

/**
 * 请假实体管理接口
 *
 * @author HenryYan
 */

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
