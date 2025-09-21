package me.yangjun.study.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import me.yangjun.study.entity.OrderEntity;

@Repository
public interface OrderMapper extends BaseMapper<OrderEntity> {}
