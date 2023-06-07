package org.lan.cinema.service;

import org.lan.cinema.pojo.CareInfo;

import java.util.List;

public interface CareService {
    int flush(String memberId);

    int flushAll();

    String getGradeInfo(int grade);

    String getBlessing();

    List<CareInfo> selectAll();

    int setGradeInfo(String grade_1, String grade_2, String grade_3);

    int setBlessing(String blessing);

}
