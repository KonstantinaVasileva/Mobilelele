package bg.softuni.MobLeLeLe.model.repository;

import bg.softuni.MobLeLeLe.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
