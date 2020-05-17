package cn.qingwei.graduationproject.pojo;

public enum  OrderStatus {
    待发货(0,"待发货"),
    待收货(1,"待收货"),
    已完成(2,"已收货"),
    退款中(3,"退款中"),
    已退款(4,"已退款");

    private int id;
    private  String orderStatus;
    OrderStatus(int id,String orderStatus){
        this.id=id;
        this.orderStatus=orderStatus;
    }

    public static OrderStatus getEnumByid(int id){
        for (OrderStatus s:OrderStatus.values()){
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
        return orderStatus;
    }

    public void setCrowdfundingstatus(String crowdfundingstatus) {
        this.orderStatus = orderStatus;
    }
}
