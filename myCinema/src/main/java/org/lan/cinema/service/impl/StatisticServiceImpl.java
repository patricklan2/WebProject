package org.lan.cinema.service.impl;

import org.lan.cinema.mapper.*;
import org.lan.cinema.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Resource
    ConsumeRecordMapper consumeRecordMapper;
    @Resource
    ExchangeRecordMapper exchangeRecordMapper;
    @Resource
    MemberMapper memberMapper;
    @Resource
    CardMapper cardMapper;
    @Resource
    MovieMapper movieMapper;

    @Override
    public StatisticData getStatisticData() {
        StatisticData s = new StatisticData();
        s.setMemberNum(memberMapper.getCount());
        s.setCardNum(cardMapper.getCount());
        s.setMovieNum(movieMapper.getCount());
        return s;
    }

    @Override
    public DealData getDealData() {
        final DealData dealData = new DealData();
        dealData.setConsume(consumeRecordMapper.selectConsumeCount());
        dealData.setIntegral(exchangeRecordMapper.selectExchangeCount());
        dealData.setRecharge(consumeRecordMapper.selectRechargeCount());
        return dealData;
    }
}
