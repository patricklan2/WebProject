package org.lan.cinema.mapper;

import java.util.List;
import org.lan.cinema.pojo.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String memberId);

    Member selectByPrimaryKey(String memberId);

    List<Member> selectAll();

    int updateByPrimaryKey(Member row);

    List<Member> inquireMember(String name, String birthdayQuery);

    List<Member> selectAllWithName(String name);

    List<Member> selectByPageWithBirthdayType(String birthdayType);

    int upgrade(String memberId);

    int degrade(String memberId);

    int getIntegral(String memberId, int number);

    int reduceIntegral(String memberId, int number);

    int setInfo(String memberId, String info);

    int register(Member member);

    Member getAllInfo(String name);

    Long getCount();

    Member selectByName(String name);
}