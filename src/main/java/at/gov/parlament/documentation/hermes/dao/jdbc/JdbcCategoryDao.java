package at.gov.parlament.documentation.hermes.dao.jdbc;

import org.springframework.stereotype.Component;

import at.gov.parlament.documentation.hermes.dao.CategoryEntity;
import at.gov.parlament.documentation.hermes.dao.GenericDaoImpl;
import at.gov.parlament.documentation.hermes.dao.ICategoryDao;

@Component("categoryDao")
public class JdbcCategoryDao extends GenericDaoImpl<CategoryEntity> implements ICategoryDao {

}
