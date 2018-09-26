package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.dbservice.biz.BaseBizImpl;
import com.iscas.smurfs.dbservice.entity.Base;
import com.iscas.smurfs.dbservice.entity.Users;
import com.iscas.smurfs.dbservice.mapper.BaseMapper;
import com.iscas.smurfs.dbservice.mapper.UsersMapper;
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
public class WqBaseBizImpl  extends BaseBizImpl<BaseMapper, Base> implements IWqBaseBiz{
}
