package cn.qingwei.graduationproject.pojo;

public class Habitation extends Place {
    @Override
    public String toString() {
        return super.getProvince()+"-"+super.getCity()+"-"+super.getDistrict();
    }
    public static  Habitation getHabitationbyStr(String str){
        String[] array=str.split("-");
        Habitation habitation=new Habitation();
        habitation.setProvince(array[0]);
        habitation.setCity(array[1]);
        habitation.setDistrict(array[2]);
        return habitation;
    }
}
