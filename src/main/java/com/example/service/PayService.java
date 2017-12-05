package com.example.service;

import com.example.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * 支付
 *
 * 2017-07-04 00:53
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    /**
     * 微信异步通知
     *
     * @param notifyData
     */
    PayResponse notify(String notifyData);

    /**
     * 退款
     *
     * @param orderDTO
     */
    RefundResponse refund(OrderDTO orderDTO);
}
