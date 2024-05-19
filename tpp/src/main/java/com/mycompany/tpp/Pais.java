/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpp;

import java.io.IOException;

/**
 *
 * @author pedro
 */
public class Pais {
    
    String imagem, populacao, iso, presidente, continente, nome;
   // String 
    public Pais(){
        
    }

    public String getBandeira() {
        return imagem;
    }
    
     public String getNome() {
        return nome;
    }

    public String getPopulacao() {
        return populacao;
    }

    public String getIso() {
        return iso;
    }
    
     public String getPresidente() {
        return presidente;
    }

     public String getContinente() {
        return continente;
    }


    public void setBandeira(String imagem) {
        this.imagem = imagem;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public void setPresidente(String presidente) {
        this.imagem = presidente;
    }
    
    public void setContinente(String continente) {
        this.continente = continente;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
    
    public Pais(String nome, String img, String pop, String iso, String continente, String presidente) throws IOException{
        this.nome = nome;
        this.imagem = img;
        this.populacao = pop;
        this.iso = iso;
        this.continente = continente;
        this.presidente = presidente;
    }
    
    public void printPais(){
        System.out.println("Nome Pais: " + this.nome);
        System.out.println("Bandeira Link: " + this.imagem);
        System.out.println("ISO: " + this.iso);
        System.out.println("Populacao: " + this.populacao);
        System.out.println("Continente: " + this.continente);
        System.out.println("Presidente: " + this.presidente);
    }
    
    
}
