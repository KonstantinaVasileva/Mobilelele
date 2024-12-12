package bg.softuni.MobLeLeLe.model.repository;

import bg.softuni.MobLeLeLe.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
