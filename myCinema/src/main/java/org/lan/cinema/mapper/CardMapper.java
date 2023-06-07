package org.lan.cinema.mapper;

import java.util.List;
import org.lan.cinema.pojo.Card;

public interface CardMapper {
    int deleteByPrimaryKey(String cardId);

    int register(Card row);

    Card selectByPrimaryKey(String cardId);

    List<Card> selectAll();

    int updateByPrimaryKey(Card row);

    List<Card> selectAllWithName();

    int handleCancel(String cardId);

    int handleLose(String cardId);

    List<Card> selectByMemberId(String memberId);

    List<Card> selectByCondition(String memberId, String name, String cardId);

    int upgrade(String cardId);

    int degrade(String cardId);

    int recharge(String cardId, int number);

    int consume(String cardId, int number);

    Long getCount();
}