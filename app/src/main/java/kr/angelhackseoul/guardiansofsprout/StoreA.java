package kr.angelhackseoul.guardiansofsprout;

import java.io.Serializable;

public class StoreA implements Comparable<StoreA>, Serializable {
    Store store;
    double distance;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(StoreA s) {
        if (this.distance > s.distance) {
            return 1; // distance 에 대해서 오름차순
        }
        return -1;
    }
}
