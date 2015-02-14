package at.gov.parlament.documentation.hermes.dao;

public interface IUserDao {

	UserEntity findUserByNameAndPassword(String usernam, String password);

}
