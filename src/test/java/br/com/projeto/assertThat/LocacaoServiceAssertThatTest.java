package br.com.projeto.assertThat;

import static br.com.projeto.utils.DataUtils.isMesmaData;
import static br.com.projeto.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import br.com.projeto.entidades.Filme;
import br.com.projeto.entidades.Locacao;
import br.com.projeto.entidades.Usuario;
import br.com.projeto.servicos.LocacaoService;

public class LocacaoServiceAssertThatTest {

	@Test
	public void teste() {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificacao
		/*
		 * assertThat normalmente usando para ter uma melhor
		 * leitura do codigo de teste, já que é mais claro
		 * o que diz, como os metodos abaixo: is, equalTo, not
		 * Pois tem o mesmo resultado que o assertEquals
		 * assertThat é da api hamcrest que o junit importa
		 * http://hamcrest.org/JavaHamcrest/javadoc/1.3/index.html?help-doc.html
		 */
		assertThat(locacao.getValor(), is(equalTo(5.0)));
		assertThat(locacao.getValor(), is(not(6.0)));
		assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}
}
