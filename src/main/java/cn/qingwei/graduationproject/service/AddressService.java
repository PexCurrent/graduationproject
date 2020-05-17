package cn.qingwei.graduationproject.service;

import cn.qingwei.graduationproject.pojo.Address;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AddressService {

    public List<Address> getAddressByUserId(int uid);
    public Address getAddressById(int id);
    public int delAddressById(int id);
    public int insertAddress(@RequestBody Address address, @RequestParam("uid") int uid);
    public int updateAddress(@RequestBody Address address);
    public int qudefault();
    public int defaultaddress(int id);
    public Address getDefaultAddressById(int id);

}
