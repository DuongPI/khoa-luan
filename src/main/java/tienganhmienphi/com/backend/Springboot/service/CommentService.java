package tienganhmienphi.com.backend.Springboot.service;

import java.util.List;

import tienganhmienphi.com.backend.Springboot.entity.CommentEntity;

public interface CommentService {
	List<CommentEntity> findAll();
}
