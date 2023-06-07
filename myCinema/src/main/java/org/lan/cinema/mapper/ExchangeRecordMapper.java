package org.lan.cinema.mapper;

import java.util.List;
import org.lan.cinema.pojo.ExchangeRecord;

public interface ExchangeRecordMapper {
    int insert(ExchangeRecord row);

    List<ExchangeRecord> selectAll();

    Long selectExchangeCount();
}