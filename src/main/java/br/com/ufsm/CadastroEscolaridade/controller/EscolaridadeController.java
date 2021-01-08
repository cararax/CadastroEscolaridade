package br.com.ufsm.CadastroEscolaridade.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.ufsm.CadastroEscolaridade.controller.dto.EscolaridadeDTO;
import br.com.ufsm.CadastroEscolaridade.entity.EscolaridadeEntity;
import br.com.ufsm.CadastroEscolaridade.model.Escolaridade;
import br.com.ufsm.CadastroEscolaridade.repository.EscolaridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cadastroEscolaridade")
public class EscolaridadeController {

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;
    private EscolaridadeEntity escolaridadeEntity;

    @GetMapping //Não devolve DTO se não não sei a id
    public List<EscolaridadeEntity> listar(){
        List<EscolaridadeEntity> escolaridadeEntityList = escolaridadeRepository.findAll();
        return escolaridadeEntityList;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<EscolaridadeDTO> listarPorId(@PathVariable(value = "id") Integer id){
        Optional<EscolaridadeEntity> escolaridadeEntity = escolaridadeRepository.findById(id);
        if(escolaridadeEntity.isPresent()){
            return ResponseEntity.ok(new EscolaridadeDTO(escolaridadeEntity.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EscolaridadeEntity> criarEscolaridade(@RequestBody @Valid EscolaridadeEntity escolaridade, UriComponentsBuilder uriComponentsBuilder) {
        EscolaridadeEntity escolaridadeSalvo = escolaridadeRepository.save(escolaridade);
        URI uri = uriComponentsBuilder.path("/escolariade/{id}").buildAndExpand(escolaridade.getId()).toUri();
        return ResponseEntity.created(uri).body(escolaridade);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EscolaridadeEntity> atualizarEscolaridade(@PathVariable(value = "id") Integer id, @RequestBody @Valid EscolaridadeEntity escolaridadeEntity) {
        Optional<EscolaridadeEntity> escolaridade = escolaridadeRepository.findById(id);
        if(escolaridade.isPresent()){
            escolaridade.get().setNome(escolaridadeEntity.getNome());
            escolaridade.get().setDataInicial(escolaridadeEntity.getDataInicial());
            escolaridade.get().setDataFinal(escolaridadeEntity.getDataFinal());
            escolaridade.get().setInstituicao(escolaridadeEntity.getInstituicao());

            EscolaridadeEntity escolaridadeAtualizada = escolaridadeRepository.save(escolaridade.get());
            return ResponseEntity.ok(escolaridadeAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerEscolaridade(@PathVariable(value = "id") Integer id) {
        escolaridadeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}