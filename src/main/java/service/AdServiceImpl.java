package service;

import model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repository.AdRepository;

import java.util.List;
import java.util.Set;


@Service
public class AdServiceImpl implements AdService{


    @Autowired
    private AdRepository adRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(Ad ad) {
        adRepository.save(ad);
    }


    @Override
    public void update(Ad ad) {
        adRepository.save(ad);
    }


    @Override
    public Ad findByTitle(String title) {
        return adRepository.findByTitle(title);
    }

    @Override
    public List<Ad> getAll() {
        return adRepository.findAll();
    }



    @Override
    public void deleteAd(Ad ad) {
        adRepository.delete(ad);
    }

    @Override
    public Set<Ad> search(String query) {
        return adRepository.search(query);
    }



}
