package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ad")
public class Ad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ad_id;
    @Column
    private String title;
    @Column
    private String address;
    @Column
    private String description;
    @Column
    private Integer budget;
    @Column
    private String phone;

    @ManyToOne
    private User advertiser;

    public Ad() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
