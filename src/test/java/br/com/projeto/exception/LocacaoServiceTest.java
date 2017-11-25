package br.com.projeto.exception;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.projeto.entidades.Filme;
import br.com.projeto.entidades.Usuario;
import br.com.projeto.servicos.LocacaoService;

/*
 * Algumas formas de trabalhar com exception em teste unitarios
 */
public class LocacaoServiceTest {
	
	/*
	 * Rule para se trabalhar com exeçoes em teste
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/*
	 * Quando queremos testar um codigo que lança
	 * uma exceção e caso isso aconteça o teste
	 * passará com sucesso, pois já esta esperando a exceção
	 * Para deixar o Junt cuidar disso
	 * Temos que informar para ele qual exceção estamos esperando
	 * Para isso temos que passar a excecão como parametro
	 * na Anotação test: @Test(expected = Exception.class)
	 * No caso abaixo, esperamos uma exeção bem generica a Exception
	 * Mas poderia esperar uma outra qualquer .  
	 * 
	 */
	@Test(expected = Exception.class)
	public void testLocacao_filmeSemEstoque() throws Exception{
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 2", 0, 4.0);
		
		//acao
		service.alugarFilme(usuario, filme);
	}
	
	/*
	 * Uma outra forma de trabalhar com exception em teste
	 * É trantando manualmente, sem a ajudar do junit
	 * No caso abaixo englobamos o metodo que lanca uma
	 * excecao com um try catch, detro do catch verificamos
	 * Se a mensagem da exception e a esperada
	 * Nesse caso, vai ser um parecido com um falso positivo
	 * Pois lancar uma excecao o vai cair no catch e no catch
	 * Estamos verificando a mensagem de erro, com o isso
	 * O teste passar com sucesso.
	 * Mas se o metodo não lancar excecao ele tbm passara com sucesso
	 * Para isso no try logo apos a chamada do metodo, temos que 
	 * incluir um Assert.fail, informado que era para ter lancado
	 * uma excecao
	 * 
	 * Caso isso aconteca o teste passara com sucesso
	 * 
	 */
	@Test
	public void testLocacao_filmeSemEstoque_2() {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 2", 0, 4.0);
		
		//acao
		try {
			service.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter lancado uma excecao");
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Filme sem estoque"));
		}
	}
	

	/*
	 * Uma outra forma de trabalhar com exception em teste
	 * É usando um novo rule de excecao
	 * O ExpectedException exception = ExpectedException.none();
	 * Depois precisamos informar antes da chamada do metodo que
	 * lanca uma exceçao, as seguinte instrucoes de codigo:
	 * exception.expect(Exception.class);
	 * exception.expectMessage("Filme sem estoque");
	 * 
	 * Ou seja: queremos que o metodo a seguinte lance
	 * As seguinte excecao, e esperamos essa mensagem
	 * Caso isso aconteca o teste passara com sucesso
	 * 
	 */
	@Test
	public void testLocacao_filmeSemEstoque_3() throws Exception {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 2", 0, 4.0);
		
		exception.expect(Exception.class);
		exception.expectMessage("Filme sem estoque");
		
		//acao
		service.alugarFilme(usuario, filme);
	}
}
