/*
 */
package at.gov.parlament.documentation.hermes.dao;


import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 */
public class JDBCUserDao implements IUserDao
{

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert createUser;

	public void setDataSource(DataSource dataSource)
	{
		createUser = new SimpleJdbcInsert(dataSource).withSchemaName("hermesdb").withTableName("user").usingGeneratedKeyColumns("id");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public UserEntity create(UserEntity user)
	{
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
		Number id = createUser.executeAndReturnKey(parameters);
		user.setId(id.intValue());
		return user;
	}

	public void update(UserEntity user)
	{
		jdbcTemplate.update("UPDATE hermesdb.USER SET name=? WHERE id=?",
				new Object[]
				{
					user.getName(), user.getId()
				});
	}

	public UserEntity find(int id)
	{
		return jdbcTemplate.queryForObject("SELECT * FROM hermesdb.USER WHERE id=?", new BeanPropertyRowMapper<UserEntity>(UserEntity.class), id);
	}

	public List<UserEntity> findAll()
	{
		return jdbcTemplate.query("SELECT * FROM hermesdb.USER", new BeanPropertyRowMapper<UserEntity>(UserEntity.class));
	}

	public List<UserEntity> findUserByName(String user)
	{
		return jdbcTemplate.query("SELECT * FROM hermesdb.USER WHERE name LIKE ?", new BeanPropertyRowMapper<UserEntity>(UserEntity.class), "%" + user + "%");
	}

	public UserEntity findUserByNameAndPassword(String userName, String password)
	{
		try
		{
			return jdbcTemplate.queryForObject("SELECT * FROM hermesdb.USER WHERE name=? AND password=?",
					new BeanPropertyRowMapper<UserEntity>(UserEntity.class), userName, password);
		}
		catch (DataAccessException ex)
		{
			return null;
		}
	}

	public void delete(UserEntity user)
	{
		jdbcTemplate.update("DELETE FROM hermesdb.USER WHERE id=?", user.getId());
		user.setId(-1);
	}
}
