package org.lan.cinema.service.impl;

import org.lan.cinema.mapper.CardMapper;
import org.lan.cinema.mapper.GoodMapper;
import org.lan.cinema.mapper.MemberMapper;
import org.lan.cinema.mapper.MovieMapper;
import org.lan.cinema.pojo.Card;
import org.lan.cinema.pojo.Good;
import org.lan.cinema.pojo.Member;
import org.lan.cinema.pojo.Movie;
import org.lan.cinema.service.CUDService;
import org.lan.cinema.utils.TimeTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class CUDServiceImpl implements CUDService {
    @Resource
    GoodMapper goodMapper;
    @Resource
    MemberMapper memberMapper;
    @Resource
    MovieMapper movieMapper;
    @Resource
    CardMapper cardMapper;

    @Override
    public int addGood(Good good) {
        return goodMapper.insert(good);
    }

    @Override
    public int modifyGood(Good good) {
        return goodMapper.updateByPrimaryKey(good);
    }

    @Override
    public int deleteGood(String name) {
        return goodMapper.deleteByPrimaryKey(name);
    }

    @Override
    public int modifyMember(Member member) {
        member.setBirthday(member.getBirthday().substring(5));
        return memberMapper.updateByPrimaryKey(member);
    }

    @Override
    public int registerMember(String name, String password, String sex, String birthday) {
        Member member = new Member();
        member.setBirthday(birthday.substring(5));
        member.setName(name);
        member.setMemberId(UUID.randomUUID().toString().replaceAll("-", ""));
        member.setPassword(password);
        member.setSex(sex);
        return memberMapper.register(member);
    }

    @Override
    public int deleteMember(String memberId) {
        return memberMapper.deleteByPrimaryKey(memberId);
    }

    @Override
    public int registerCard(String memberId, int grade) {
        Card card = new Card();
        card.setCardId(UUID.randomUUID().toString().replaceAll("-", ""));
        card.setMemberId(memberId);
        card.setGrade(grade);
        return cardMapper.register(card);
    }


    @Override
    public int insertMovie(Movie movie) {
        movie.setTime(TimeTool.getDetailTime());
        return movieMapper.insert(movie);
    }

    @Override
    public int deleteMovie(String name) {
        return movieMapper.deleteByPrimaryKey(name);
    }

    @Override
    public int updateMovie(Movie movie) {
        return movieMapper.updateByPrimaryKey(movie);
    }
}
