package cn.qingwei.graduationproject.pojo;

import lombok.Data;

@Data
public class AlipayRefundInfo {
    private String out_trade_no;
    private Double refund_amount;
    private  String trade_no;
}
