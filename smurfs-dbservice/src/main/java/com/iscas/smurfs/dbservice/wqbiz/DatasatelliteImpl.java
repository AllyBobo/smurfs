package com.iscas.smurfs.dbservice.wqbiz;

import com.iscas.smurfs.dbservice.biz.BaseBizImpl;
import com.iscas.smurfs.dbservice.entity.Datasatellite;
import com.iscas.smurfs.dbservice.mapper.DatasatelliteMapper;
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
public class DatasatelliteImpl extends BaseBizImpl<DatasatelliteMapper, Datasatellite> implements IDatasatelliteBiz  {
}
