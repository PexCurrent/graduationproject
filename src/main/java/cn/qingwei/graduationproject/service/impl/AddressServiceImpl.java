package cn.qingwei.graduationproject.service.impl;

import cn.qingwei.graduationproject.pojo.Address;
import cn.qingwei.graduationproject.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.qingwei.graduationproject.mapper.Addressmapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Transactional
@Service
public class AddressServiceImpl implements AddressService {
     @Autowired
     Addressmapper mapper;

    @Override
    public Address getDefaultAddressById(int id) {
        return mapper.getDefaultAddressById(id);
    }

    @Override
    public List<Address> getAddressByUserId(int uid) {
        return mapper.getAddressByUserId(uid);
    }

    @Override
    public Address getAddressById(int id) {
        return mapper.getAddressById(id);
    }


    @Override
    public int delAddressById(int id) {
        return mapper.delAddressById(id);
    }

    @Override
    public int insertAddress(@RequestBody Address address, @RequestParam("uid") int uid) {
        return mapper.insertAddress(address,uid);
    }

    @Override
    public int qudefault() {
        return mapper.qudefault();
    }

    @Override
    public int defaultaddress(int id) {
        return mapper.defaultaddress(id);
    }

    @Override
    public int updateAddress(@RequestBody Address address) {
        return mapper.updateAddress(address);
    }
}
