package com.alessandromelo.dto.agenteoperacoes.atualizarstatus;

public class AtualizarStatusResponseDTO {

    private Long id;
    private Boolean sucesso; //indica sucesso ou não
    private String mensagem; //Mensagem indicando sucesso ou falha


    public AtualizarStatusResponseDTO() {
    }

    public AtualizarStatusResponseDTO(Long id) {
        this.id = id;
        this.sucesso = true;
        this.mensagem = "Status do agente atualizado com sucesso";
    }

    public AtualizarStatusResponseDTO(Long id, Boolean sucesso, String mensagem) {
        this.id = id;
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
