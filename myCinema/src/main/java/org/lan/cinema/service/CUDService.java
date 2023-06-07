package org.lan.cinema.service;

import org.lan.cinema.pojo.Good;
import org.lan.cinema.pojo.Member;
import org.lan.cinema.pojo.Movie;

public interface CUDService {
    int addGood(Good good);

    int modifyGood(Good good);

    int deleteGood(String name);


    int modifyMember(Member member);

    int registerMember(String name,String password,String sex,String birthday);

    int deleteMember(String memberId);


    int registerCard(String memberId, int grade);


    int insertMovie(Movie movie);

    int deleteMovie(String name);

    int updateMovie(Movie movie);



}
