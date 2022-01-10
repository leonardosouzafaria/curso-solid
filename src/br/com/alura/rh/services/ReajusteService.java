package br.com.alura.rh.services;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }
    
    public void ReajustarSalario(Funcionario funcionario, BigDecimal aumento) {

        this.validacoes.forEach(validacao -> {
            validacao.validar(funcionario, aumento);
        });
        
        BigDecimal salario = funcionario.getSalario();

        BigDecimal salarioReajustado = salario.add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}