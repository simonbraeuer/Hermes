package at.gov.parlament.documentation.hermes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VideoFileRepository extends CrudRepository<VideoFile, Long> {
	List<VideoFile> findByName(String name);
}
