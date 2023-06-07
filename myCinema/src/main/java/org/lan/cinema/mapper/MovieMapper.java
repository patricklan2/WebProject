package org.lan.cinema.mapper;

import java.util.List;
import org.lan.cinema.pojo.Movie;

public interface MovieMapper {
    int deleteByPrimaryKey(String name);

    int insert(Movie row);

    Movie selectByPrimaryKey(String name);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie row);

    Long getCount();
}