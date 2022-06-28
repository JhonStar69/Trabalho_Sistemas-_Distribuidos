package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")

public class Usuario {

    public Usuario() {
        this.saldo = 100f;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String Nome;
    @Column
    private float saldo;
    @Column
    private String senha;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
/*
 * Usuario: id, nome, saldo,  senha*/