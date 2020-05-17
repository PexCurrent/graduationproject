package cn.qingwei.graduationproject.service.impl;

import cn.qingwei.graduationproject.mapper.ReservationMapper;
import cn.qingwei.graduationproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationMapper reservationMapper;


    @Override
    public Integer insertreservation(int cid, int uid) {
        return reservationMapper.insertreservation(cid,uid);
    }

    @Override
    public Integer delreservation(int cid, int uid) {
        return reservationMapper.delreservation(cid,uid);
    }



}
