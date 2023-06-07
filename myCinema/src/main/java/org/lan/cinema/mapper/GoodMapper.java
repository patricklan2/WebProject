package org.lan.cinema.mapper;

import java.util.List;
import org.lan.cinema.pojo.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(String name);

    int insert(Good row);

    Good selectByPrimaryKey(String name);

    List<Good> selectAll();

    int updateByPrimaryKey(Good row);
    int supply(String name, int number);
    int reduce(String name, int number);
}