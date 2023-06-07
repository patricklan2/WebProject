package org.lan.cinema.mapper;

import java.util.List;
import org.lan.cinema.pojo.ConsumeRecord;

public interface ConsumeRecordMapper {
    int insert(ConsumeRecord row);

    List<ConsumeRecord> selectAll();

    Long selectConsumeCount();

    Long selectRechargeCount();
}