package at.gov.parlament.documentation.hermes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FileLocatorRepository extends CrudRepository<FileLocator, Long> {
    List<FileLocator> findByLink(String link);
}
