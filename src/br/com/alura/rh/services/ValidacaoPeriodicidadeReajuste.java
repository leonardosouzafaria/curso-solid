package br.com.alura.rh.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidadeReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento){
       
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        Long intervaloUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        
        if(intervaloUltimoReajuste < 6) {
            throw new ValidacaoException(String.format("Intervalo de reajuste deve ser no minimo maior que %s meses", 6));
        }
    }
    
}
