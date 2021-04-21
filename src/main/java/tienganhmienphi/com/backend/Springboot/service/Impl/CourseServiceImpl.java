package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.converter.CourseConverter;
import tienganhmienphi.com.backend.Springboot.dto.CourseDTO;
import tienganhmienphi.com.backend.Springboot.entity.CourseEntity;
import tienganhmienphi.com.backend.Springboot.entity.LearnCourse;
import tienganhmienphi.com.backend.Springboot.repository.CourseRepository;
import tienganhmienphi.com.backend.Springboot.repository.LearnCourseReporitory;
import tienganhmienphi.com.backend.Springboot.service.CourseService;
import tienganhmienphi.com.backend.Springboot.utils.CovertToString;
import tienganhmienphi.com.backend.Springboot.utils.UploadFileUtils;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private CourseConverter courseConverter;
	@Autowired
	private UploadFileUtils uploadFileUtils;
	@Autowired
	private CovertToString coverToString;
	@Autowired
	private LearnCourseReporitory learnCourseReporitory;
	
	@Override
	public List<CourseDTO> findAll() {
		List<CourseEntity> entities = courseRepository.findAll();
		List<CourseDTO> dtos = new ArrayList<>();
		for(int i = 0 ; i< entities.size();i++) {
			CourseDTO dto = new CourseDTO();
			dto = courseConverter.toDto(entities.get(i));
			dto.setImagetobase64(uploadFileUtils.read("/thumbnail/"+ dto.getImageName()));
			dto.setUrlName(coverToString.covertToStringUrl(dto.getCourseName()));
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	@Transactional
	public CourseDTO insert(CourseDTO dto) {
		// TODO Auto-generated method stub
		CourseEntity entity = courseConverter.toEntity(dto);
		byte[] decodeBase64 = Base64.getDecoder().decode(dto.getImagetobase64().split(",")[1]);
		uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+dto.getImageName());
		CourseDTO newDTO = courseConverter.toDto(courseRepository.save(entity));
		newDTO.setImagetobase64(uploadFileUtils.read("/thumbnail/"+newDTO.getImageName()));
		newDTO.setUrlName(coverToString.covertToStringUrl(newDTO.getCourseName()));
		return newDTO;
	}
	@Override
	@Transactional
	public CourseDTO update(CourseDTO dto) {
		// TODO Auto-generated method stub
		CourseEntity oldentity = courseRepository.findById(dto.getId()).get();
		CourseEntity newentity = courseConverter.toEntity(dto, oldentity);
		byte[] decodeBase64 = Base64.getDecoder().decode(dto.getImagetobase64().split(",")[1]);
		uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+dto.getImageName());
		CourseDTO newDTO = courseConverter.toDto(courseRepository.save(newentity));
		newDTO.setImagetobase64(uploadFileUtils.read("/thumbnail/"+newDTO.getImageName()));
		newDTO.setUrlName(coverToString.covertToStringUrl(newDTO.getCourseName()));
		return newDTO;
	}
	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
	}

	@Override
	public CourseEntity findByName(String name) {
		List<CourseEntity> entities = courseRepository.findAll();
		for(CourseEntity entity: entities) {
			if (name.equals(coverToString.covertToStringUrl(entity.getCourseName())))
				return entity;
		}
		return null;
	}

	@Override
	public List<CourseDTO> findByCategory(String category) {
		List<CourseEntity> entities = courseRepository.findByCategory(Integer.parseInt(category));
		List<CourseDTO> dtos = new ArrayList<>();
		for(CourseEntity entity: entities) {
			CourseDTO dto = new CourseDTO();
			dto = courseConverter.toDto(entity);
			dto.setImagetobase64(uploadFileUtils.read("/thumbnail/"+ dto.getImageName()));
			dto.setUrlName(coverToString.covertToStringUrl(dto.getCourseName()));
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<CourseDTO> findByUserId(Long id) {
		List<LearnCourse> list = learnCourseReporitory.findAllCourseByUser(id);
		List<Long> listCourseId = new ArrayList<>();
		List<CourseDTO> listCourse = new ArrayList<>();
		for(LearnCourse entity:list){
			listCourseId.add(entity.getCourseID());
		}
		for(Long courseId: listCourseId){
			CourseEntity courseEntity = courseRepository.findById(courseId).get();
			CourseDTO dto = new CourseDTO();
			dto = courseConverter.toDto(courseEntity);
			dto.setImagetobase64(uploadFileUtils.read("/thumbnail/"+ dto.getImageName()));
			dto.setUrlName(coverToString.covertToStringUrl(dto.getCourseName()));
			listCourse.add(dto);
		}
		return listCourse;
	}

}
