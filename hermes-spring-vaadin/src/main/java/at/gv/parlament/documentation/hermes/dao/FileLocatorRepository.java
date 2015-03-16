package at.gv.parlament.documentation.hermes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface FileLocatorRepository extends CrudRepository<FileLocator, Long> {
    List<FileLocator> findByLink(String link);
}
