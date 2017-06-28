package hspm.centrocirurgico.anestesia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cir30")
public class Anestesia {
	@Column(name="c30codanest")
 private String codAnestesia;
	@Column(name="c30nomeanest")
 private String descAnestesia;
 
public String getCodAnestesia() {
	return codAnestesia;
}
public void setCodAnestesia(String codAnestesia) {
	this.codAnestesia = codAnestesia;
}
public String getDescAnestesia() {
	return descAnestesia;
}
public void setDescAnestesia(String descAnestesia) {
	this.descAnestesia = descAnestesia;
}
 
}
