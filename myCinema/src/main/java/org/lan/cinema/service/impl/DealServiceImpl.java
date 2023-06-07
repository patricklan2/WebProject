package org.lan.cinema.service.impl;

import org.lan.cinema.mapper.*;
import org.lan.cinema.pojo.*;
import org.lan.cinema.service.DealService;
import org.lan.cinema.utils.TimeTool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class DealServiceImpl implements DealService {
    @Resource
    CardMapper cardMapper;
    @Resource
    MovieMapper movieMapper;
    @Resource
    MemberMapper memberMapper;
    @Resource
    GoodMapper goodMapper;
    @Resource
    ConsumeRecordMapper consumeRecordMapper;
    @Resource
    ExchangeRecordMapper exchangeRecordMapper;
    @Override
    public int recharge(String cardId, int number) {
        int num = 0;
        num += cardMapper.recharge(cardId,number);
        num += rechargeRecord(cardId, number);
        return num;
    }

    @Override
    public int consume(String cardId, String name, int number) {
        Movie movie = movieMapper.selectByPrimaryKey(name);
        Card card = cardMapper.selectByPrimaryKey(cardId);
        int totalPrice = movie.getPrice() * number;
        int integral = movie.getIntegral() * number;
        if (card.getBalance() > totalPrice) {
            int num = 0;
            num += cardMapper.consume(cardId, totalPrice);
            num += memberMapper.getIntegral(card.getMemberId(),integral);
            num += consumeRecord(card.getCardId(),card.getMemberId(),movie,number);
            return num;
        }else{
            return -1;
        }
    }

    @Override
    public int exchangeGoods(String memberId, String goodName, int number) {
        Good good = goodMapper.selectByPrimaryKey(goodName);
        Member member = memberMapper.selectByPrimaryKey(memberId);
        if (good.getStock() > number) {
            int exchangeTotal = good.getIntegral() * number;
            if (exchangeTotal < member.getIntegral()) {
                int num = 0;
                num += goodMapper.reduce(good.getName(),number);
                num += memberMapper.reduceIntegral(member.getMemberId(),exchangeTotal);
                num += exchangeRecord(memberId,good,number);
                return num;
            }
        }
        return -1;
    }

    @Override
    public int consumeRecord(String cardId, String memberId, Movie movie, int number) {
        int num = 0;
        ConsumeRecord consumeRecord = new ConsumeRecord();
        consumeRecord.setInfo(movie.getName() + '*' + number);
        consumeRecord.setReason(1);
        consumeRecord.setCardId(cardId);
        consumeRecord.setTime(TimeTool.getDetailTime());
        consumeRecord.setValue(movie.getPrice() * number);
        num += consumeRecordMapper.insert(consumeRecord);
        ExchangeRecord exchangeRecord = new ExchangeRecord();
        exchangeRecord.setTime(TimeTool.getDetailTime());
        exchangeRecord.setInfo(movie.getName() + '*' + number);
        exchangeRecord.setReason(2);
        exchangeRecord.setMemberId(memberId);
        exchangeRecord.setValue(movie.getIntegral() * number);
        num += exchangeRecordMapper.insert(exchangeRecord);
        return num;
    }

    @Override
    public int rechargeRecord(String cardId, int number) {
        ConsumeRecord consumeRecord = new ConsumeRecord();
        consumeRecord.setValue(number);
        consumeRecord.setReason(2);
        consumeRecord.setInfo("recharge");
        consumeRecord.setCardId(cardId);
        consumeRecord.setTime(TimeTool.getDetailTime());
        return consumeRecordMapper.insert(consumeRecord);
    }

    @Override
    public int exchangeRecord(String memberId, Good good, int number) {
        ExchangeRecord exchangeRecord = new ExchangeRecord();
        exchangeRecord.setValue(good.getIntegral() * number);
        exchangeRecord.setReason(1);
        exchangeRecord.setInfo(good.getName()+'*'+number);
        exchangeRecord.setMemberId(memberId);
        exchangeRecord.setTime(TimeTool.getDetailTime());
        return exchangeRecordMapper.insert(exchangeRecord);
    }


}
