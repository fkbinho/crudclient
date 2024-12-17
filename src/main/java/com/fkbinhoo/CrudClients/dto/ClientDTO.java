package com.fkbinhoo.CrudClients.dto;


public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, Double income, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public Integer getChildren() {
        return children;
    }
}
