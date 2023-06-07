package org.lan.cinema.service;

import org.lan.cinema.mapper.CardMapper;
import org.lan.cinema.pojo.*;
import org.lan.cinema.utils.PageResult;

import javax.annotation.Resource;

public interface SelectService {
    PageResult<Card> selectAllCard(String pageIndex, String pageSize);

    PageResult<Card> selectCardByMemberId(String memberId);

    PageResult<Card> selectCardByCondition(String pageIndex, String pageSize, String memberId, String name, String cardId);


    PageResult<Good> selectAllGood(String pageIndex, String pageSize);


    Manager selectManagerByManagerId(String managerId);

    Member selectMemberByName(String name);


    Member getMemberAllInfo(String memberId);
    PageResult<Member> selectAllMember(String pageIndex, String pageSize);

    PageResult<Member> selectMemberByCondition(String pageIndex, String pageSize, String name, String birthdayType);


    PageResult<Movie> selectAllMovie(String pageIndex, String pageSize);


    PageResult<ConsumeRecord> selectAllConsumeRecord(String pageIndex, String pageSize);

    PageResult<ExchangeRecord> selectAllExchangeRecord(String pageIndex, String pageSize);

}
