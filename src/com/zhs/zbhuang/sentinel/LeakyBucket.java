package com.zhs.zbhuang.sentinel;

/**
 * 漏桶算法
 */
public class LeakyBucket {
    public Long timestamp = System.currentTimeMillis();
    public Long capacity;
    public Long rate;
    public Long water;

    public boolean limit(){
        Long now =System.currentTimeMillis();
        water = Math.max(0, water - ((now - timestamp/1000)) * rate);
        timestamp = now;
        if(water + 1 < capacity) {
            water += 1;
            return true;
        } else {
            return false;
        }
    }
}
