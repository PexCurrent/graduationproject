package cn.qingwei.graduationproject.service.impl;

import cn.qingwei.graduationproject.mapper.GearMapper;
import cn.qingwei.graduationproject.pojo.Gear;
import cn.qingwei.graduationproject.service.GearService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GearServiceImpl implements GearService {
    @Autowired
    GearMapper gearMapper;

    @Override
    public Integer insertGear(Gear gear) {
        return  gearMapper.insertgear(gear);
    }

    @Override
    public Integer deletegearbyuid(int cid) {
        return gearMapper.deletegearbyuid(cid);
    }
}
