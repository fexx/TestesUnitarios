package br.com.projeto.order;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/*
 * O Junit não garante a order de execução dos teste
 * Ou seja, não garante que será executado de cima para baixo, seguenciamente.
 * No caso abaixo, ele pode executar primeiro o verifica() e depois o inicia()
 * Para dizer ao junit a ordem dos teste, podemos usar uma anotação
 * @FixMethodOrder(MethodSorters.NAME_ASCENDING)
 * com isso ele executara em order alfabetica
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {
	
	public static int contador = 0;

	@Test
	public void inicia(){
		contador = 1;
	}
	
	@Test
	public void verifica(){
		Assert.assertEquals(1, contador);
	}
}
