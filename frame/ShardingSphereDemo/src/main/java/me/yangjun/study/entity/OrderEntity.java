package me.yangjun.study.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_order")
public class OrderEntity {
    /**
     * 订单ID
     */
    @TableId
    private long orderId;

    /**
     * 商品ID
     */
    private long goodsId;

    /**
     * 用户ID
     */
    private int userId;

    /**
     * 支付状态 1 支付完成 0 支付中
     */
    private short payStatus;

}
