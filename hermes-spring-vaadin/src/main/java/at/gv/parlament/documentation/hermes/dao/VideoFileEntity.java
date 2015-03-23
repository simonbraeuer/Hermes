package at.gv.parlament.documentation.hermes.dao;

import javax.persistence.*;

import org.eclipse.jdt.internal.compiler.classfmt.NonNullDefaultAwareTypeAnnotationWalker;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity(name="VideoFileEntity")
@Table(name="videofile")
@NoArgsConstructor
@EqualsAndHashCode(exclude={"id"})
@Setter
@Getter
public class VideoFileEntity {

    public static final int MAX_LENGTH_NAME = 254;
    public static final int MAX_LENGTH_CONTENTTYPE = 45;
    public static final int MAX_LENGTH_FILEPATH = 2000;

    @Id
    @NonNull @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;

    @NonNull @Column(name = "contenttype", nullable = false, length = MAX_LENGTH_CONTENTTYPE)
    private String contentType;
    
    @NonNull @Column(name = "filepath", nullable = false, length = MAX_LENGTH_FILEPATH)
    private String filePath;
    
    @NonNull @Version
    private Long version;
    
}
