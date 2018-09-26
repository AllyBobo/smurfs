package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.dbservice.biz.BaseBizImpl;
import com.iscas.smurfs.dbservice.entity.Group;
import com.iscas.smurfs.dbservice.mapper.GroupMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/21
 */
@Service
@Transactional
public class GroupBizImpl extends BaseBizImpl<GroupMapper, Group> implements IGroupBiz  {
}
