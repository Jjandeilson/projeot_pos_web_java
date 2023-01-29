package pos.web.controller.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.web.controller.dto.DisciplinaDto;
import pos.web.domain.entity.Disciplina;

@Component
public class DisciplinaAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public DisciplinaDto disciplinaDto(Disciplina disciplina) {
		return modelMapper.map(disciplina, DisciplinaDto.class);
	}
	
	public List<DisciplinaDto> disciplinasDto(List<Disciplina> disciplinas) {
		return disciplinas.stream().map(this::disciplinaDto).toList();
	}
	
}
