package com.bdyh.service;

import com.bdyh.common.APIResponse;
import com.bdyh.entity.UserOrder;
import com.bdyh.entity.UserWechat;
import org.simpleframework.xml.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
  APIResponse createOrder (Integer courseId, Integer [] videosId ,UserWechat userWechat);
  APIResponse cancel(String orderId);
  APIResponse finish(UserOrder orderId);
  APIResponse pay(String orderId);
  UserOrder findOne(String orderId);
 UserOrder findByOpenIdAndOrderId(String openId,String orderId);

}
