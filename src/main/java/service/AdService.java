package service;


import model.Ad;

import java.util.List;
import java.util.Set;


public interface AdService {
    void save(Ad ad);
    void update(Ad ad);
    Ad findByTitle(String title);
    List<Ad> getAll();
    void deleteAd(Ad user);
    Set<Ad> search(String query);
}