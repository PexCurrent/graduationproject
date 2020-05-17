package cn.qingwei.graduationproject.pojo;

import lombok.Data;

@Data
public class AlipayVO {
    private String out_trade_no;
    private String total_amount;
    private String subject;
    private String product_code;

}
