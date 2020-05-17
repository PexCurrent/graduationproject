package cn.qingwei.graduationproject.pojo;

public class Hometown extends Place {
    @Override
    public String toString() {
        return super.getProvince()+"-"+super.getCity()+"-"+super.getDistrict();
    }


    public static  Hometown getHometownbyStr(String str){
        String[] array=str.split("-");
        Hometown hometown=new Hometown();
        hometown.setProvince(array[0]);
        hometown.setCity(array[1]);
        hometown.setDistrict(array[2]);
        return hometown;
    }
}
