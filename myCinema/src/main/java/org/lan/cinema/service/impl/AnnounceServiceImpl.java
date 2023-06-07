package org.lan.cinema.service.impl;

import org.lan.cinema.mapper.CareInfoMapper;
import org.lan.cinema.mapper.MemberMapper;
import org.lan.cinema.pojo.CareInfo;
import org.lan.cinema.pojo.Member;
import org.lan.cinema.service.CareService;
import org.lan.cinema.utils.TimeTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnnounceServiceImpl implements CareService {
    @Resource
    CareInfoMapper careInfoMapper;
    @Resource
    MemberMapper memberMapper;

    @Override
    public int flush(String memberId) {
        Member member = memberMapper.selectByPrimaryKey(memberId);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(announceForGrade(member)).append(" ").append(announceForIntegral(member)).append(announceBirthdayCare(member));
        return memberMapper.setInfo(memberId, stringBuilder.toString());
//        return 0;
    }

    @Override
    public int flushAll() {
        int num = 0;
        final List<Member> members = memberMapper.selectAll();
        for (Member member : members) {
            num += flush(member.getMemberId());
        }
        return num;
    }

    @Override
    public String getGradeInfo(int grade) {
        switch (grade){
            case 1: return careInfoMapper.getInfo("grade_1").getInfo();
            case 2: return careInfoMapper.getInfo("grade_2").getInfo();
            case 3: return careInfoMapper.getInfo("grade_3").getInfo();
            default: return "none";
        }
    }

    @Override
    public String getBlessing() {
        return careInfoMapper.getInfo("blessing").getInfo();
    }

    @Override
    public List<CareInfo> selectAll() {
        return careInfoMapper.selectAll();
    }

    @Override
    public int setGradeInfo(String grade_1, String grade_2, String grade_3) {
        int num = 0;
        num += careInfoMapper.setInfo(new CareInfo("grade_1",grade_1));
        num += careInfoMapper.setInfo(new CareInfo("grade_2",grade_2));
        num += careInfoMapper.setInfo(new CareInfo("grade_3",grade_3));
        return num;
    }

    @Override
    public int setBlessing(String blessing) {
        return careInfoMapper.setInfo(new CareInfo("blessing",blessing));
    }

    private String announceForGrade(Member member){
        switch (member.getGrade()){
            case 1: return getGradeInfo(1);
            case 2: return getGradeInfo(2);
            case 3: return getGradeInfo(3);
            default: return "none";
        }
    }

    private String announceForIntegral(Member member){
        if (member.getIntegral() == 0) {
            return "zero";
        }else{
            return "no zero";
        }
    }

    private String announceBirthdayCare(Member member){
        String time = TimeTool.getDetailTime().substring(5);
        if (time.equals(member.getBirthday())){
            return "happy birthday";
        }
        return "";
    }
}
