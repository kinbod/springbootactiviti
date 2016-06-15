package com.easeu.oa.activiti.service.oa.leave;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easeu.oa.activiti.dao.LeaveRepository;
import com.easeu.oa.activiti.entity.oa.Leave;

/**
 * 请假实体管理
 *
 * @author HenryYan
 */
@Service
@Transactional(readOnly = true)
public class LeaveManager {

	@Autowired
    private LeaveRepository leaveRepository;

    public Leave getLeave(Long id) {
        return leaveRepository.findOne(id);
    }

    @Transactional(readOnly = false)
    public void saveLeave(Leave entity) {
        if (entity.getId() == null) {
            entity.setApplyTime(new Date());
        }
        leaveRepository.save(entity);
    }

}
