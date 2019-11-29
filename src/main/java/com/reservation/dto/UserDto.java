package com.reservation.dto;

public class UserDto {

    private String name;
    private String cpf;
    private String telefone;
    private Boolean deletado;

    public UserDto() {
    }

    public UserDto(String name, String cpf, String telefone, Boolean deletado) {
        this.name = name;
        this.cpf = cpf;
        this.telefone = telefone;
        this.deletado = deletado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getDeletado() {
        return deletado;
    }

    public void setDeletado(Boolean deletado) {
        this.deletado = deletado;
    }

}
