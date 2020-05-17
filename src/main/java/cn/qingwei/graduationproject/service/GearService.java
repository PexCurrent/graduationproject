package cn.qingwei.graduationproject.service;

import cn.qingwei.graduationproject.pojo.Gear;

public interface GearService {
    Integer insertGear(Gear gear);
    Integer deletegearbyuid(int cid);
}
