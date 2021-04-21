package tienganhmienphi.com.backend.Springboot.service.Impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienganhmienphi.com.backend.Springboot.converter.PostConverter;
import tienganhmienphi.com.backend.Springboot.dto.PostDTO;
import tienganhmienphi.com.backend.Springboot.entity.PostEntity;
import tienganhmienphi.com.backend.Springboot.repository.PostRepository;
import tienganhmienphi.com.backend.Springboot.service.PostService;
import tienganhmienphi.com.backend.Springboot.utils.CovertToString;
import tienganhmienphi.com.backend.Springboot.utils.UploadFileUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;
//	@Autowired
//	private PostCategoryRepository postCategoryRepository;
	@Autowired
	private PostConverter postConverter;
	@Autowired
	private UploadFileUtils uploadFileUtils;
	@Autowired
	private CovertToString coverToString;
	@Override
	public List<PostDTO> findAll() {
		List<PostEntity> entities = postRepository.findAll();
		List<PostDTO> dtos = new ArrayList<>();
		for(PostEntity entity: entities) {
			PostDTO dto = postConverter.toDTO(entity);
			dto.setImagetobase64(uploadFileUtils.read("/thumbnail/"+ dto.getImage()));
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public PostDTO insert(PostDTO dto) {
		PostEntity entity = postConverter.toEntity(dto);
		byte[] decodeBase64 = Base64.getDecoder().decode(dto.getImagetobase64().split(",")[1]);
		uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+dto.getImage());
		PostDTO newdto = postConverter.toDTO(postRepository.save(entity));
		newdto.setImagetobase64(uploadFileUtils.read("/thumbnail/"+ dto.getImage()));
		return newdto;
	}

	@Override
	public PostDTO update(PostDTO dto) {
		PostEntity oldentity = postRepository.findById(dto.getId()).get();
		PostEntity newentity = postConverter.toEntity(dto,oldentity);
		PostDTO newdto = postConverter.toDTO(postRepository.save(newentity));
		byte[] decodeBase64 = Base64.getDecoder().decode(dto.getImagetobase64().split(",")[1]);
		uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+dto.getImage());
		newdto.setImagetobase64(uploadFileUtils.read("/thumbnail/"+ dto.getImage()));
		newdto.setUrlname(coverToString.covertToStringUrl(newdto.getName()));
		return newdto;
	}

	@Override
	public void delete(long id) {
		postRepository.deleteById(id);
		
	}

	@Override
	public PostDTO findByName(String name) {
		List<PostEntity> entities = postRepository.findAll();
		PostDTO dto = new PostDTO();
		for(PostEntity entity: entities) {
			if(name.equals(coverToString.covertToStringUrl(entity.getName()))){
				dto = postConverter.toDTO(entity);
				break;
			}
		}
		return dto;
	}

}
