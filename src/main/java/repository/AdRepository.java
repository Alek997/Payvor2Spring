package repository;


import model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AdRepository  extends JpaRepository<Ad,Long> {
    public Ad findByTitle(String title);
    @Query(value="SELECT ad.`ad`, ad.`title`, ad.`lastname`, ad.`address`, ad.`description`, ad.`budget`, ad.`phone` FROM ad WHERE ad.title LIKE %:query%",nativeQuery = true)
    public Set<Ad> search(String query);
}

