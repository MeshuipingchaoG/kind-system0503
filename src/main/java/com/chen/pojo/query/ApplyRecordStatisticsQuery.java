package com.chen.pojo.query;

import java.util.Date;

public class ApplyRecordStatisticsQuery {

    /**
     * 统计时间
     */
    private Date statisticsTime;

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    @Override
    public String toString() {
        return "ApplyRecordStatisticsQuery{" +
                "statisticsTime=" + statisticsTime +
                '}';
    }
}
