package cn.qingwei.graduationproject.pojo;

import lombok.Data;

@Data
public class OrderStatusCount {
    private int totalcount;  //
    private int shippingcount;  //待发货
    private  int receivingcount;//待收货
    private int completedcount;  //已完成
    private  int refundingcount; //退款中
    private int refundedcount;   //已退款
}
