package cn.qingwei.graduationproject.service;

import org.apache.ibatis.annotations.Delete;

public interface ReservationService {
    public Integer insertreservation(int cid,int uid);
    public Integer delreservation(int cid,int uid);
}
