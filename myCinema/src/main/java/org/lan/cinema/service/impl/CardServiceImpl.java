package org.lan.cinema.service.impl;

import org.lan.cinema.mapper.CardMapper;
import org.lan.cinema.service.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CardServiceImpl implements CardService {
    @Resource
    CardMapper cardMapper;

    @Override
    public int handleLose(String cardId) {
        return cardMapper.handleLose(cardId);
    }

    @Override
    public int handleCancel(String cardId) {
        return cardMapper.handleCancel(cardId);
    }
}
