package kr.angelhackseoul.guardiansofsprout;

public class SingleItem {
    String name;    // 가게 이름
    String address; // 가게 주소
    double distance;    // 가게 거리

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public SingleItem(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public SingleItem(String name, String address, double distance) {
        this.name = name;
        this.address = address;
        this.distance = distance;
    }
}
