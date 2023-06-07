package org.lan.cinema;

import org.junit.jupiter.api.Test;
import org.lan.cinema.mapper.CardMapper;
import org.lan.cinema.mapper.CareInfoMapper;
import org.lan.cinema.mapper.GoodMapper;
import org.lan.cinema.mapper.MemberMapper;
import org.lan.cinema.pojo.CareInfo;
import org.lan.cinema.pojo.Member;
import org.lan.cinema.service.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Resource
    GradeService gradeService;
    @Resource
    DealService dealService;
    @Resource
    CareService announceService;
    @Resource
    CUDService cudService;
    @Resource
    SelectService selectService;

    @Test
    public void serviceTest() {
//        final PageResult<Member> memberPageResult = memberService.inquireMember("1","5","","3   ");
//        System.out.println(memberPageResult);

//        int i = memberService.exchangeGoods("567ced95cf1541bc94ccb3dfa767b53f", "23", 3);
//        System.out.println(i);

//            gradeService.cardDegrade("0967a8dd2cc04fc887cb69f35ae831fd");
//            gradeService.memberDegrade("2525943c9c0f4f6a9530262628df56db");

//        System.out.println(dealService.consume("0967a8dd2cc04fc887cb69f35ae831fd", "tip1", 10));
//        System.out.println(dealService.recharge("0161c880e711464c9bbb5f699f292e23", 100));
//        dealService.exchangeGoods("567ced95cf1541bc94ccb3dfa767b53f","23",5);
//        System.out.println(announceService.flush("2525943c9c0f4f6a9530262628df56db"));
//        System.out.println(announceService.flushAll());
//        System.out.println(cudService.registerCard("567ced95cf1541bc94ccb3dfa767b53f", 3));
        final Member memberAllInfo = selectService.getMemberAllInfo("567ced95cf1541bc94ccb3dfa767b53f");
        System.out.println(memberAllInfo);
    }

    @Resource
    MemberMapper memberMapper;
    @Resource
    CardMapper cardMapper;
    @Resource
    GoodMapper goodMapper;
    @Resource
    CareInfoMapper careInfoMapper;
    @Test
    public void mapperTest() {
//        final List<Member> members = memberMapper.selectAll();
//        System.out.println(members);
//        final List<Card> cards = cardMapper.selectByMemberId("567ced95cf1541bc94ccb3dfa767b53f");
//        final List<Card> cards = cardMapper.selectByCondition("567ced95cf1541bc94ccb3dfa767b53f", "张三丰", "0b5705e0ed8f4b6fafc4126147b7d6fc");
//        final List<Card> cards = cardMapper.selectAll();
//        final List<Card> cards = cardMapper.selectAllWithName();
//        System.out.println(cards);

//        cardMapper.degrade("0161c880e711464c9bbb5f699f292e23");
//        final Member member = memberMapper.selectByPrimaryKey("2525943c9c0f4f6a9530262628df56db");
//        System.out.println(member);

//        cardMapper.consume("0161c880e711464c9bbb5f699f292e23",1000);
//        cardMapper.recharge("0967a8dd2cc04fc887cb69f35ae831fd",6000);

//        memberMapper.reduceIntegral("2525943c9c0f4f6a9530262628df56db",3000);

//        goodMapper.reduce("23",25);
//        goodMapper.supply("变形金刚",3);
//        final CareInfo grade1 = careInfoMapper.getInfo("grade_2");
//        System.out.println(grade1);

//        final List<CareInfo> careInfos = careInfoMapper.selectAll();
//        System.out.println(careInfos);
//        final CareInfo grade_1 = careInfoMapper.getInfo("grade_1");
//        grade_1.setInfo("ONE");
//        careInfoMapper.setInfo(grade_1);
        System.out.println(cardMapper.selectByMemberId("567ced95cf1541bc94ccb3dfa767b53f"));
    }

}
