package at.gov.parlament.documentation.hermes.dao;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity(name="Property")
@Table(name="property")
@NoArgsConstructor
public class Property {

	public static final int MAX_LENGTH_NAME = 254;
	public static final int MAX_LENGTH_NO = 45;
	public static final int MAX_LENGTH_DATATYPE = 45;
	
    @Id
    @NonNull @Getter @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull @Getter @Column(name = "no", nullable = false, length = MAX_LENGTH_NO)
    private String no;
    
    @NonNull @Getter @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;
    
    @NonNull @Getter @Column(name = "datatype", nullable = false, length = MAX_LENGTH_DATATYPE)
    private String dataType;
    
    @NonNull @Getter @Version
    private long version;
    
}
