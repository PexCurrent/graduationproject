package cn.qingwei.graduationproject.pojo;

public enum  Status {
    审核中(0,"审核"),
    发布中(1,"发布"),
    成功(2,"成功"),
    失败(3,"失败"),
    已发货(4,"已发货"),
    已退款(5,"已退款");



    private int id;
    private  String crowdfundingstatus;
    Status(int id,String crowdfundingstatus){
        this.id=id;
        this.crowdfundingstatus=crowdfundingstatus;
    }

   public static Status getEnumByid(int id){
        for (Status s:Status.values()){
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

    public String getCrowdfundingstatus() {
        return crowdfundingstatus;
    }

    public void setCrowdfundingstatus(String crowdfundingstatus) {
        this.crowdfundingstatus = crowdfundingstatus;
    }

}
