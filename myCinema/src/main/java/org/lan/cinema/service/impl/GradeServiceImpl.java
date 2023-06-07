package org.lan.cinema.service.impl;

import org.lan.cinema.mapper.CardMapper;
import org.lan.cinema.mapper.MemberMapper;
import org.lan.cinema.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    CardMapper cardMapper;
    @Resource
    MemberMapper memberMapper;

    @Override
    public int cardUpgrade(String cardId) {
        int grade = cardMapper.selectByPrimaryKey(cardId).getGrade();
        if (grade != 3){
            return cardMapper.upgrade(cardId);
        }
        return 2;
    }

    @Override
    public int cardDegrade(String cardId) {
        int grade = cardMapper.selectByPrimaryKey(cardId).getGrade();
        if (grade != 1){
            return cardMapper.degrade(cardId);
        }
        return 2;
    }

    @Override
    public int memberUpgrade(String memberId) {
        int grade = memberMapper.selectByPrimaryKey(memberId).getGrade();
        if (grade != 3){
            return memberMapper.upgrade(memberId);
        }
        return 2;
    }

    @Override
    public int memberDegrade(String memberId) {
        int grade = memberMapper.selectByPrimaryKey(memberId).getGrade();
        if (grade != 3){
            return memberMapper.degrade(memberId);
        }
        return 2;
    }
}
