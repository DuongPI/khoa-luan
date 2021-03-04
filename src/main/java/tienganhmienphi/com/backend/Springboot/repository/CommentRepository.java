package tienganhmienphi.com.backend.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienganhmienphi.com.backend.Springboot.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

}
