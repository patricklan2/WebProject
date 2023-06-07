package org.lan.cinema.mapper;

import org.lan.cinema.pojo.CareInfo;

import java.util.List;

public interface CareInfoMapper {
    CareInfo getInfo(String name);

    List<CareInfo> selectAll();

    int setInfo(CareInfo careInfo);
}
