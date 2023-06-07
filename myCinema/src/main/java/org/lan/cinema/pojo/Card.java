package org.lan.cinema.pojo;

public class Card {
    private String cardId;

    private String name;

    private String memberId;

    private Integer balance;

    private Integer lose;

    private Integer grade;

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", balance=" + balance +
                ", lose=" + lose +
                ", grade=" + grade +
                '}';
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberidId) {
        this.memberId = memberidId == null ? null : memberidId.trim();
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }
}