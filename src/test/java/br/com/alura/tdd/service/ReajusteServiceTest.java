package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;


public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}

	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	
	}
	
	@Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
	
	@Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
	
	@Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForEspetacular() {
        service.concederReajuste(funcionario, Desempenho.ESPETACULAR);
        assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
    }
}