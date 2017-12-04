package br.com.projeto.suites;

import org.junit.runners.Suite.SuiteClasses;

import br.com.projeto.calculadora.CalculadoraTest;
import br.com.projeto.teste.CalculoValorLocacaoTest;
import br.com.projeto.teste.LocacaoServiceTest;

/*
 * Classe de suite, rodará os teste declarados
 * na anotação @SuiteClasses
 * 
 */

//@RunWith(Suite.class)
@SuiteClasses({
	CalculadoraTest.class,
	CalculoValorLocacaoTest.class,
	LocacaoServiceTest.class
})
public class SuiteExecucao {
	//Remova se puder!
}
