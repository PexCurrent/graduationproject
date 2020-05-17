package cn.qingwei.graduationproject.pojo;

public enum  SexEnum {

    MALE(0,"男"),
    FEMALE(1,"女");
    private int id;
    private String name;
    SexEnum (int id,String name){
        this.id=id;
        this.name=name;
    }


    public static SexEnum getEnumByid(int id){
        for(SexEnum s:SexEnum.values()){
            if(s.getId()==id)
                return s;
        }
        return null;
    }








    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
