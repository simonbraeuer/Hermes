package at.gv.parlament.documentation.hermes.dao;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity(name="Contribution")
@Table(name="contribution")
@NoArgsConstructor
public class Contribution {

	public static final int MAX_LENGTH_NAME = 254;
	public static final int MAX_LENGTH_NO = 45;
	public static final int MAX_LENGTH_DESCRIPTION = 2000;
	
    @Id
    @NonNull @Getter @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull @Getter @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;
    
    @NonNull @Getter @Column(name = "no", nullable = false, length = MAX_LENGTH_NO)
    private String no;

    @NonNull @Getter @Column(name = "contenttype", nullable = true, length = MAX_LENGTH_DESCRIPTION)
    private String description;
    
    @Getter @Column(name="videofileid", nullable=true)
    private Long videoFileId;
    
    @NonNull @Getter @Version
    private long version;
    
}
