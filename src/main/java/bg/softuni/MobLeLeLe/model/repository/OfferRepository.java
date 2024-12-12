package bg.softuni.MobLeLeLe.model.repository;

import bg.softuni.MobLeLeLe.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
