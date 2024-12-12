package bg.softuni.MobLeLeLe.model.repository;

import bg.softuni.MobLeLeLe.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
