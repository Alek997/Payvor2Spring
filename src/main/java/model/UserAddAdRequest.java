package model;

public class UserAddAdRequest {
    private Integer userId;
    private Ad ad;

    public UserAddAdRequest(Integer userId, Ad ad) {
        this.userId = userId;
        this.ad = ad;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "UserAddAdRequest{" +
                "userId='" + userId + '\'' +
                ", ad=" + ad +
                '}';
    }
}
