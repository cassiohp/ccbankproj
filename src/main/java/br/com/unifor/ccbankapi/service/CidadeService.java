/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unifor.ccbankapi.service;

import br.com.unifor.ccbankapi.dao.CidadeDao;
import br.com.unifor.ccbankapi.domain.Cidade;
import br.com.unifor.ccbankapi.exception.ErroNegocioException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

/**
 *
 * @author cassi
 */
public class CidadeService {
    
    private CidadeDao cidadeDao;
    
    public CidadeService() {
        // TODO: Construtor padrão
        cidadeDao = new CidadeDao();
    }
    
    public boolean inserir(Cidade cidade) throws ErroNegocioException {
       
        // implementar regras de negócio
        if (cidade == null) {
            throw new ErroNegocioException("Cidade informada é nula!");
        }
        return cidadeDao.insert(cidade);
    }
    
    public boolean inserir(String cidadeJson) throws ErroNegocioException {
        try {
            ObjectMapper mapper = new ObjectMapper(); 
            Cidade cidade = mapper.readValue(cidadeJson, Cidade.class);
            inserir(cidade);            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CidadeService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ErroNegocioException("Erro ao converter Cidade. Motivo: " + ex.getMessage(), ex, Response.Status.BAD_REQUEST);
        }
        return true;
    }
    
    public void editar(Cidade cidade) {
        cidadeDao.update(cidade);
    }
    
    public boolean editar(String cidadeJson) throws ErroNegocioException {
        try {
            ObjectMapper mapper = new ObjectMapper(); 
            Cidade cidade = mapper.readValue(cidadeJson, Cidade.class);
            editar(cidade);            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CidadeService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ErroNegocioException("Erro ao converter Cidade. Motivo: " + ex.getMessage(), ex, Response.Status.BAD_REQUEST);
        }
        return true;
    }
    
    public List<Cidade> getTodasCidades() {
        return cidadeDao.findAll();
    }
    
    public Cidade getCidade(int id){
        return cidadeDao.findById(id);
    }
    
    public void excluir(Cidade cidade) {
        cidadeDao.delete(cidade);
    }
}
