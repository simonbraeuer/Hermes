package at.gov.parlament.documentation.hermes.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;


@Entity(name="FileLocator")
@Table(name="filelocator")
public class FileLocator{
	
	public static final int MAX_LENGTH_HASHVALUE = 50;
	public static final int MAX_LENGTH_FILEPATH = 254;
	public static final int MAX_LENGTH_LINK = 254;
    
    @Getter @Id @GeneratedValue(strategy=GenerationType.AUTO) 
    private long id;
    
    @Getter @Column(name="hashvalue", unique=true, nullable=false, length=MAX_LENGTH_HASHVALUE) 
    private String hashValue;
    
    @Getter @Column(name="filepath", unique=true, nullable=false, length=MAX_LENGTH_FILEPATH) 
    private String filePath;
    
    @Getter @Column(name="link", unique=true, nullable=false, length=MAX_LENGTH_LINK) 
    private String link;

    @Getter @Version
    private long version;

    public FileLocator() {
    }
    
}

