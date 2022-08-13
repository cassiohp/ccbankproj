/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.unifor.ccbankapi.service;


import br.com.unifor.ccbankapi.domain.Cidade;
import br.com.unifor.ccbankapi.exception.ErroNegocioException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author wander
 */

@Disabled
public class CidadeServiceTest {
    
    public CidadeServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class CidadeService.
     */
    @Test
    @DisplayName("Deve retornar erro FALSE ao tentar inserir uma cidade NULL")
    public void testInserir_Cidade() throws Exception {
        System.out.println("inserir");
        String mensagem = "Cidade informada é nula!";
        Cidade cidade = null;
        CidadeService instance = new CidadeService();           
        ErroNegocioException erro = assertThrows(ErroNegocioException.class, () -> instance.inserir(cidade));
        assertEquals(mensagem, erro.getMessage());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class CidadeService.
     */
    @Test
    public void testInserir_String() throws Exception {
        System.out.println("inserir");
        String cidadeJson = "";
        CidadeService instance = new CidadeService();
        boolean expResult = false;
        boolean result = instance.inserir(cidadeJson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class CidadeService.
     */
    @org.junit.jupiter.api.Test
    public void testEditar() {
        System.out.println("editar");
        Cidade cidade = null;
        CidadeService instance = new CidadeService();
        instance.editar(cidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodasCidades method, of class CidadeService.
     */
    @org.junit.jupiter.api.Test
    public void testGetTodasCidades() {
        System.out.println("getTodasCidades");
        CidadeService instance = new CidadeService();
        List<Cidade> expResult = null;
        List<Cidade> result = instance.getTodasCidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class CidadeService.
     */
    @org.junit.jupiter.api.Test
    public void testExcluir() {
        System.out.println("excluir");
        Cidade cidade = null;
        CidadeService instance = new CidadeService();
        instance.excluir(cidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
