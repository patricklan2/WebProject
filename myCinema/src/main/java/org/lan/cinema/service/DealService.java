package org.lan.cinema.service;

import org.lan.cinema.pojo.Card;
import org.lan.cinema.pojo.Good;
import org.lan.cinema.pojo.Movie;

public interface DealService {
    int recharge(String cardId, int number);

    int consume(String cardId, String name, int number);

    int exchangeGoods(String memberId, String goodName, int number);

    int consumeRecord(String cardId, String memberId, Movie movie, int number);

    int rechargeRecord(String cardId, int number);

    int exchangeRecord(String memberId, Good good, int number);
}
