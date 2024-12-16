package bg.softuni.MobLeLeLe.repository;

import bg.softuni.MobLeLeLe.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
