package at.gov.parlament.documentation.hermes.dao;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity(name="ContributionType")
@Table(name="contributiontype")
@NoArgsConstructor
public class ContributionType {

	public static final int MAX_LENGTH_NAME = 254;
	public static final int MAX_LENGTH_NO = 45;
	
    @Id
    @NonNull @Getter @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull @Getter @Column(name = "no", nullable = false, length = MAX_LENGTH_NO)
    private String no;
    
    @NonNull @Getter @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;
    
    @NonNull @Getter @Version
    private long version;
    
}
