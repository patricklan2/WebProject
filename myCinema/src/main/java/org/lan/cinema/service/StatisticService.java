package org.lan.cinema.service;

import java.io.Serializable;

public interface StatisticService {
    StatisticData getStatisticData();

    DealData getDealData();


    class DealData{
        private static final long serialVersionUID = 1L;
        Long consume;
        Long recharge;
        Long integral;

        @Override
        public String toString() {
            return "DealData{" +
                    "consume=" + consume +
                    ", recharge=" + recharge +
                    ", integral=" + integral +
                    '}';
        }

        public Long getConsume() {
            return consume;
        }

        public void setConsume(Long consume) {
            this.consume = consume;
        }

        public Long getRecharge() {
            return recharge;
        }

        public void setRecharge(Long recharge) {
            this.recharge = recharge;
        }

        public Long getIntegral() {
            return integral;
        }

        public void setIntegral(Long integral) {
            this.integral = integral;
        }
    }

    class StatisticData implements Serializable {
        Long memberNum;
        Long cardNum;
        Long movieNum;
        private static final long serialVersionUID = 1L;
        @Override
        public String toString() {
            return "StatisticData{" +
                    "memberNum=" + memberNum +
                    ", cardNum=" + cardNum +
                    ", movieNum=" + movieNum +
                    '}';
        }

        public Long getMemberNum() {
            return memberNum;
        }

        public void setMemberNum(Long memberNum) {
            this.memberNum = memberNum;
        }

        public Long getCardNum() {
            return cardNum;
        }

        public void setCardNum(Long cardNum) {
            this.cardNum = cardNum;
        }

        public Long getMovieNum() {
            return movieNum;
        }

        public void setMovieNum(Long movieNum) {
            this.movieNum = movieNum;
        }
    }

}
