package br.com.alura.rh.services;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {
    
    public void promover(Funcionario funcionario, boolean metaBatida) {
        if(Cargo.GERENTE == funcionario.getDadosPessoais().getCargo()) {
            throw new ValidacaoException("Gerente não possui mais promoção");
        }

        if(metaBatida) {
            Cargo novoCargo = funcionario.getDadosPessoais().getCargo().getProximoCargo();
            funcionario.promover(novoCargo);
        }
    }

}
