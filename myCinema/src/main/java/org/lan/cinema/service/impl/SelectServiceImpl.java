package org.lan.cinema.service.impl;

import com.github.pagehelper.PageHelper;
import org.lan.cinema.mapper.*;
import org.lan.cinema.pojo.*;
import org.lan.cinema.service.SelectService;
import org.lan.cinema.utils.PageResult;
import org.lan.cinema.utils.TimeTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    @Resource
    CardMapper cardMapper;
    @Resource
    MemberMapper memberMapper;
    @Resource
    ManagerMapper managerMapper;
    @Resource
    MovieMapper movieMapper;
    @Resource
    GoodMapper goodMapper;
    @Resource
    ConsumeRecordMapper consumeRecordMapper;
    @Resource
    ExchangeRecordMapper exchangeRecordMapper;


    @Override
    public PageResult<Card> selectAllCard(String pageIndex, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<Card> lists = cardMapper.selectAllWithName();
        return PageResult.build(lists);
    }

    @Override
    public PageResult<Card> selectCardByMemberId(String memberId) {
        List<Card> lists = cardMapper.selectByMemberId(memberId);
        return PageResult.build(lists);
    }

    @Override
    public PageResult<Card> selectCardByCondition(String pageIndex, String pageSize, String memberId, String name, String cardId) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<Card> lists = cardMapper.selectByCondition(memberId, name, cardId);
        return PageResult.build(lists);
    }

    @Override
    public PageResult<Good> selectAllGood(String pageIndex, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<Good> lists = goodMapper.selectAll();
        return PageResult.build(lists);
    }

    @Override
    public Manager selectManagerByManagerId(String managerId) {
        return managerMapper.selectByPrimaryKey(managerId);
    }

    @Override
    public Member selectMemberByName(String name) {
        return memberMapper.selectByName(name);
    }

    @Override
    public Member getMemberAllInfo(String name) {
        return memberMapper.getAllInfo(name);
    }

    @Override
    public PageResult<Member> selectAllMember(String pageIndex, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<Member> lists = memberMapper.selectAll();
        return PageResult.build(lists);
    }

    @Override
    public PageResult<Member> selectMemberByCondition(String pageIndex, String pageSize, String name, String birthdayType) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<Member> lists = memberMapper.inquireMember(name, TimeTool.getBirthdayQuery(birthdayType));
        return PageResult.build(lists);
    }

    @Override
    public PageResult<Movie> selectAllMovie(String pageIndex, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<Movie> lists = movieMapper.selectAll();
        return PageResult.build(lists);
    }

    @Override
    public PageResult<ConsumeRecord> selectAllConsumeRecord(String pageIndex, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<ConsumeRecord> lists = consumeRecordMapper.selectAll();
        return PageResult.build(lists);
    }

    @Override
    public PageResult<ExchangeRecord> selectAllExchangeRecord(String pageIndex, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        List<ExchangeRecord> lists = exchangeRecordMapper.selectAll();
        return PageResult.build(lists);
    }
}
