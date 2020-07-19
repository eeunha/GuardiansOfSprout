package kr.angelhackseoul.guardiansofsprout;

import java.util.ArrayList;
import java.util.List;

// store 데이터 보낼 때 사용
public class StoreDTO {
    String name;
    double latitude;
    double longitude;
    String address;

    public StoreDTO(String name, double latitude, double longitude,String address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address= address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
