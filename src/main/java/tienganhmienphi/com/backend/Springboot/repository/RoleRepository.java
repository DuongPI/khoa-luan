package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tienganhmienphi.com.backend.Springboot.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}
