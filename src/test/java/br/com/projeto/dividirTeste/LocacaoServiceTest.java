package br.com.projeto.dividirTeste;

import static br.com.projeto.utils.DataUtils.isMesmaData;
import static br.com.projeto.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.projeto.entidades.Filme;
import br.com.projeto.entidades.Locacao;
import br.com.projeto.entidades.Usuario;
import br.com.projeto.servicos.LocacaoService;

public class LocacaoServiceTest {

	/*
	 * Rules São formas de mudar o comportamento
	 * de um teste
	 */
	@Rule
	/*
	 * Caso queremos que em apenas um metodo tenha
	 * varias verificação como o metodo testeLocacao()
	 * e caso algum teste falhe e queremos mostrar todas
	 * as verificcoes que falhou podemos adicionar todos no
	 * ErrorCollector, nele estamos adicionando os erros
	 * em uma coleção para separar cada erro, assim
	 * fica quando mais de 1 teste falha, fica mais facil 
	 * saber qual quais testes falhou 
	 * E m um senario,como esse, que temos varias verificaçoes em um metodo.
	 * Normalemte separamos cada verificação em um metodo.
	 */
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void testeLocacao() {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificacao
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}
}
