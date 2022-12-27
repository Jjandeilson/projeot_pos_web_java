package pos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pos.web.domain.entity.Curso;
import pos.web.domain.repository.CursoRepository;
import pos.web.domain.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> buscar(@PathVariable Long id){
		try {
			Curso curso = this.cursoService.buscarouFalhar(id);
			
			return ResponseEntity.ok(curso);
		}catch (RuntimeException ex){
			return ResponseEntity.notFound().build();
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Curso salvar(@RequestBody Curso curso) {
		return this.cursoService.salvar(curso);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso curso){
		try {
			curso = this.cursoService.atualizar(id, curso);
			
			return ResponseEntity.ok(curso);
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		try {
			this.cursoService.remover(id);
			
			return ResponseEntity.noContent().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
