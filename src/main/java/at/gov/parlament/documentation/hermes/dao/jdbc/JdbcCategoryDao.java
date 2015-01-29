package at.gov.parlament.documentation.hermes.dao.jdbc;

import org.springframework.stereotype.Component;

import at.gov.parlament.documentation.hermes.dao.GenericDaoImpl;
import at.gov.parlament.documentation.hermes.dao.entities.CategoryEntity;
import at.gov.parlament.documentation.hermes.dao.interfaces.CategoryDao;

@Component("categoryDao")
public class JdbcCategoryDao extends GenericDaoImpl<CategoryEntity> implements CategoryDao {

}
