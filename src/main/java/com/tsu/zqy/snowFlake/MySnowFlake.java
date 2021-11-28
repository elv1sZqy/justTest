package com.tsu.zqy.snowFlake;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MySnowFlake
 * @Author Elv1s
 * @Date 2021/11/13 11:39
 * @Description:
 */
public class MySnowFlake {

    private long BASE_TIME = 0;
    private int workId = 0;
    private int WORK_ID_LENGTH = 0;
    private int SEQ_NUM_LENGTH = 0;
    private int MAX_SEQ_NUM;
    private int CURRENT_SEQ_NUM;

    public MySnowFlake(long BASE_TIME, int workId, int WORK_ID_LENGTH, int SEQ_NUM_LENGTH) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < BASE_TIME) {
            throw new IllegalArgumentException("设置的baseTime必须早于当前时间");
        }
        this.BASE_TIME = BASE_TIME;
        int maxWorkId = 2 << WORK_ID_LENGTH;
        if (workId > maxWorkId) {
            throw new IllegalArgumentException("WORK_ID_LENGTH和所设置的workId不匹配");
        }
        this.workId = workId;
        this.WORK_ID_LENGTH = WORK_ID_LENGTH;
        this.SEQ_NUM_LENGTH = SEQ_NUM_LENGTH;
        MAX_SEQ_NUM = 2 << SEQ_NUM_LENGTH;
    }

    public static void main(String[] args) {
        MySnowFlake snowFlake = new MySnowFlake(1636773216000L, 1, 2, 10);
        long startTime = System.currentTimeMillis();

        int total = 1000;
        Set<Long> sets = new HashSet<>();
        for (int i = 0; i < total; i++) {
            long id = snowFlake.nextId();
            if (sets.contains(id)) {
                System.out.println("出现重复的了:" + id);
            }
            sets.add(id);
        }
        long userTime = System.currentTimeMillis() - startTime;
        System.out.println(Integer.MAX_VALUE);

        System.out.println("一共生成了:" + String.valueOf(sets.size()) + ", 耗时: " + userTime);
    }

    private long nextId() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < BASE_TIME) {
            throw new IllegalArgumentException("设置的baseTime必须早于当前时间");
        }
        long timeInterval = currentTimeMillis - BASE_TIME;

        return generateId(timeInterval);
    }

    private long generateId(long timeInterval) {
        synchronized (MySnowFlake.class) {
            if (CURRENT_SEQ_NUM > MAX_SEQ_NUM) {
                CURRENT_SEQ_NUM = 0;
            }
            return (timeInterval << (WORK_ID_LENGTH + SEQ_NUM_LENGTH))
                    + (workId << SEQ_NUM_LENGTH)
                    + CURRENT_SEQ_NUM++;
        }
    }


}
