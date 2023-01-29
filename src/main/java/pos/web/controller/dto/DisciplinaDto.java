package pos.web.controller.dto;

import lombok.Getter;
import lombok.Setter;
import pos.web.domain.entity.StatusDisciplina;

@Getter
@Setter
public class DisciplinaDto {

	private String nome;
	private Long cargaHoraria; 
	private String professor;
	private StatusDisciplina status;
	private String observacao;
	
}
