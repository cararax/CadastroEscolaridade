package br.com.ufsm.CadastroEscolaridade.repository;

import br.com.ufsm.CadastroEscolaridade.entity.EscolaridadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaridadeRepository extends JpaRepository<EscolaridadeEntity, Integer> {
}
