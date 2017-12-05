package com.example.repository;

import com.example.po.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 2017-07-23 23:04
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
