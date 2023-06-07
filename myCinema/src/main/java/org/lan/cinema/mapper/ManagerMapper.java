package org.lan.cinema.mapper;

import java.util.List;
import org.lan.cinema.pojo.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(String managerId);

    int insert(Manager row);

    Manager selectByPrimaryKey(String managerId);

    List<Manager> selectAll();

    int updateByPrimaryKey(Manager row);
}