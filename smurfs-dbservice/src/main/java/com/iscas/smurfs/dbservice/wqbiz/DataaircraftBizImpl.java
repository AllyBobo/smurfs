package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.dbservice.biz.BaseBizImpl;
import com.iscas.smurfs.dbservice.entity.Dataaircraft;
import com.iscas.smurfs.dbservice.entity.Facility;
import com.iscas.smurfs.dbservice.mapper.DataaircraftMapper;
import com.iscas.smurfs.dbservice.mapper.FacilityMapper;
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
public class DataaircraftBizImpl extends BaseBizImpl<DataaircraftMapper, Dataaircraft> implements IDataaircraftBiz  {
}
