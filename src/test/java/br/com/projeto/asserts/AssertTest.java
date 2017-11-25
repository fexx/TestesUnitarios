package br.com.projeto.asserts;
import org.junit.Assert;
import org.junit.Test;

import br.com.projeto.entidades.Usuario;

public class AssertTest {

	@Test
	public void test(){
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		/*
		 	Também podemos usar uma mensagem para melhor 
		 	Analisar os testes quando falhar
		 	Como a mensagem abaixo: Erro de comparacao
		 	Caso o teste falhe a mensagem abaixo e exibida.
		 */
		Assert.assertEquals("Erro de comparacao", 1, 1);
		
		/*
		 * Para valores como double, é necessarios informa
		 * Uma marge de erro, no caso abaixo estamos verificando 
		 * se as casas decimais 0.001 é o mesmo com os valores
		 * 0.51234, 0.512, ou seja ele compara apenas os 0.512
		 * Nesse caso poderia testar valores como o valor PI
		 * Que é infinito, e queremos garatir que seja comparado
		 * Apenas os valores 3.14
		 */
		Assert.assertEquals(0.51234, 0.512, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		/*
			Para comprar objetos usando o assertEquals 
			é necessario sobrescrever o equals e hashCode
		 */ 
		Assert.assertEquals(u1, u2);
		
		/*
		 * Para comparar instancia de objeto que tenha o equals e hashcode
		 * Devemos usar o assertSame
		 */
		Assert.assertSame(u2, u2);
		Assert.assertNotSame(u1, u2);
		
		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
	}
}
