/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.net;

/**
 *
 * @author italberto
 */
public class HttpStatus {
    public static String getStatusMessage(Integer erCode){
        String retorno = "";
        
        
        //Informativas
        if (erCode == 100){
            
        }else if (erCode == 100){
            retorno = "Continuar";
        }else if (erCode == 101){
            retorno ="Mudando protocolos";
        }else if (erCode == 122){ //de sucesso
            retorno ="Pedido-URI muito longo";
        }else if (erCode == 200){
            retorno ="OK";
        }else if (erCode == 201){
            retorno ="Criado";
        }else if (erCode == 202){
            retorno ="Aceito";
        }else if (erCode == 203){
            retorno ="Não autorizado";
        }else if (erCode == 204){
            retorno ="Nenhum conteúdo";
        }else if (erCode == 205){
            retorno ="Reset";
        }else if (erCode == 206){
            retorno ="Conteúdo parcial";
        }else if (erCode == 207){
            retorno = "Status Multi";
        }else if (erCode == 300){ //redirecionamento
            retorno ="Múltipla escolha";
        }else if (erCode == 301){
            retorno ="Movido";
        }else if (erCode == 302){
            retorno ="Encontrado";
        }else if (erCode == 304){
            retorno ="Não modificado";
        }else if (erCode == 305){
            retorno ="Use Proxy";
        }else if (erCode == 306){
            retorno ="Proxy Switch";
        }else if (erCode == 307){
            retorno ="Redirecionamento temporário";
        }else if (erCode == 400){ //erros do cliente
            retorno ="Requisição inválida";
        }else if (erCode == 401){
            retorno ="Não autorizado";
        }else if (erCode == 402){
            retorno ="Pagamento necessário";
        }else if (erCode == 403){
            retorno ="Proibido";
        }else if (erCode == 404){
            retorno ="Não encontrado";
        }else if (erCode == 405){
            retorno ="Método não permitido";
        }else if (erCode == 406){
            retorno ="Não acessível";
        }else if (erCode == 407){
            retorno ="Autenticação de proxy necessária";
        }else if (erCode == 408){
            retorno ="Timeout pedido";
        }else if (erCode == 409){
            retorno ="Conflito";
        }else if (erCode == 410){
            retorno ="Gone";
        }else if (erCode == 411){
            retorno ="Comprimento necessário";
        }else if (erCode == 412){
            retorno ="Pré condição falhou";
        }else if (erCode == 413){
            retorno ="Entidade de solicitação muito grande";
        }else if (erCode == 414){
            retorno ="Pedido UTI muito longo";
        }else if (erCode == 415){
            retorno ="Tipo de mídia não suportado";
        }else if (erCode == 416){
            retorno ="";
        }else if (erCode == 417){
            retorno ="";
        }else if (erCode == 418){
            retorno ="";
        }else if (erCode == 422){
            retorno ="";
        }else if (erCode == 423){
            retorno ="";
        }else if (erCode == 424){
            retorno ="";
        }else if (erCode == 425){
            retorno ="";
        }else if (erCode == 426){
            retorno ="";
        }else if (erCode == 450){
            retorno ="";
        }else if (erCode == 499){
            retorno ="";
        }else if (erCode == 500){ //outros erros
            retorno ="Eror interno do servidor";
        }else if (erCode == 501){
            retorno ="";
        }else if (erCode == 502){
            retorno ="Bad Gateway";
        }else if (erCode == 503){
            retorno ="Serviço indisponível";
        }else if (erCode == 504){
            retorno ="Gateway time-out";
        }else if (erCode == 505){
            retorno ="HTTP Version not supported";
        }
            
            
        
        
        return retorno;
    }
}
