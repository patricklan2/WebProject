package org.lan.cinema.service;

public interface GradeService {
    int cardUpgrade(String cardId);
    int cardDegrade(String cardId);
    int memberUpgrade(String memberId);
    int memberDegrade(String memberId);
}
