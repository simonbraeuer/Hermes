package at.gv.parlament.documentation.hermes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VideoFileRepository extends CrudRepository<VideoFileEntity, Long> {
	List<VideoFileEntity> findByName(String name);
}
