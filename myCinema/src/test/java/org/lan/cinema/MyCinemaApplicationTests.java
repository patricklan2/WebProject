package org.lan.cinema;

import org.junit.jupiter.api.Test;
import org.lan.cinema.mapper.CardMapper;
import org.lan.cinema.mapper.ManagerMapper;
import org.lan.cinema.mapper.MemberMapper;
import org.lan.cinema.pojo.Member;
import org.lan.cinema.utils.PageResult;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MyCinemaApplicationTests {
    @Resource
    CardMapper cardMapper;
    @Resource
    ManagerMapper managerMapper;
    @Resource
    MemberMapper memberMapper;
    @Test
    void contextLoads() {
//        final List<Card> cards = cardMapper.selectAll();
//        System.out.println(cards);

//        final List<Card> cards1 = cardMapper.selectAllWithName();
//        System.out.println(cards1);

//        final Manager admin = managerMapper.selectByPrimaryKey("admin");
//        System.out.println(admin);
//        final List<Member> members = memberMapper.inquireMember("梅超风", "2020-04-04");
//        System.out.println(members);
        final List<Member> members = memberMapper.selectAll();
        System.out.println(members);

    }
}
