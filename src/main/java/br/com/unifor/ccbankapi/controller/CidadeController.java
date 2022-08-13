package br.com.unifor.ccbankapi.controller;

import br.com.unifor.ccbankapi.domain.Cidade;
import br.com.unifor.ccbankapi.domain.ErroResponse;
import br.com.unifor.ccbankapi.exception.ErroNegocioException;
import br.com.unifor.ccbankapi.service.CidadeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Wander
 */
@Path("cidade")
public class CidadeController {
    
    private CidadeService cidadeService;
    
    public CidadeController() {
        cidadeService = new CidadeService();
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(String cidadeJson) {
        try {
            cidadeService.inserir(cidadeJson);
            return Response.ok().build();
        } catch (ErroNegocioException e) {
            return Response
                    .status(e.getErroResponse().getStatus())
                    .entity(e.getErroResponse())
                    .build();
        } catch (Exception ex) {            
            return Response
                    .serverError()
                    .entity(new ErroResponse("Erro ao inserir cidade. Motivo: " + ex.getMessage(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()))
                    .build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response buscar(@PathParam("id") int id) throws JsonProcessingException{ 
        try{
            Cidade cidade = cidadeService.getCidade(id);
            ObjectMapper mapper = new ObjectMapper();
            return Response.ok(mapper.writeValueAsBytes(cidade)).build();

        }  catch (Exception ex) {            
            return Response
                    .serverError()
                    .entity(new ErroResponse("Erro ao buscar cidade. Motivo: " + ex.getMessage(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()))
                    .build();
        }
        
    }
    
    
    @DELETE
    @Path("/{id}") // passa o codigo para o endereço
    public Response deletar(@PathParam("id") int id) throws JsonProcessingException {
        
        try{
            Cidade cidade = cidadeService.getCidade(id);
            cidadeService.excluir(cidade);
            return Response.ok().build();

        }  catch (Exception ex) {            
            return Response
                    .serverError()
                    .entity(new ErroResponse("Erro ao deletar cidade. Motivo: " + ex.getMessage(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()))
                    .build();
        }

    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") int id, String cidadeEdit) throws JsonProcessingException {
        
        try {

            cidadeService.editar(cidadeEdit);
            return  Response.ok().build();

        } catch (Exception ex) {
            return Response
                    .serverError()
                    .entity(new ErroResponse("Erro ao alterar cidade. Motivo: " + ex.getMessage(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()))
                    .build();
        }
 
    }
    
    
    
    
}
