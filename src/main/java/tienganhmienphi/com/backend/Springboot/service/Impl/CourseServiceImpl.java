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
import tienganhmienphi.com.backend.Springboot.repository.CourseRepository;
import tienganhmienphi.com.backend.Springboot.service.CourseService;
import tienganhmienphi.com.backend.Springboot.utils.UploadFileUtils;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private CourseConverter courseConverter;
	@Autowired
	private UploadFileUtils uploadFileUtils;
	
	
	
	@Override
	public List<CourseDTO> findAll() {
		List<CourseEntity> entities = courseRepository.findAll();
		List<CourseDTO> dtos = new ArrayList<CourseDTO>();
		for(int i = 0 ; i< entities.size();i++) {
			CourseDTO dto = new CourseDTO();
			dto = courseConverter.toDto(entities.get(i));
			dto.setImagetobase64(uploadFileUtils.read("/thumbnail/"+ dto.getImageName()));
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
		return newDTO;
	}
	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
	}

}
