package at.gv.parlament.documentation.hermes.dao;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity(name="VideoFile")
@Table(name="videofile")
@NoArgsConstructor
public class VideoFile {

    public static final int MAX_LENGTH_NAME = 254;
    public static final int MAX_LENGTH_CONTENTTYPE = 45;

    @Id
    @NonNull @Getter @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull @Getter @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;

    @NonNull @Getter @Column(name = "contenttype", nullable = false, length = MAX_LENGTH_CONTENTTYPE)
    private String contentType;
    
    @NonNull @Getter @OneToOne(fetch=FetchType.EAGER) @JoinColumn(name="filelocatorid")
    private FileLocator fileLocator;
    
    @NonNull @Getter @Version
    private long version;
    
}
