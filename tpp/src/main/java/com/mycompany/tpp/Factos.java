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
public class Factos {
    String  populacao, iso, nome;
    String capital, moeda, area, crescPopulacao, paisesVizinhas, cidadesPopulosas, dominioIT, idiomas;
    public Factos(){
        
    }

    

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCrescPopulacao() {
        return crescPopulacao;
    }

    public void setCrescPopulacao(String crescPopulacao) {
        this.crescPopulacao = crescPopulacao;
    }

    public String getPaisesVizinhas() {
        return paisesVizinhas;
    }

    public void setPaisesVizinhas(String paisesVizinhas) {
        this.paisesVizinhas = paisesVizinhas;
    }

    public String getCidadesPopulosas() {
        return cidadesPopulosas;
    }

    public void setCidadesPopulosas(String cidadesPopulosas) {
        this.cidadesPopulosas = cidadesPopulosas;
    }

    public String getDominioIT() {
        return dominioIT;
    }

    public void setDominioIT(String dominioIT) {
        this.dominioIT = dominioIT;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
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
    
    
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
    
    public Factos(String nome, String img, String pop, String iso, String continente, String presidente, String area, String capital, String cidadesV, String Crescpop, String idiomas, String moeda, String PaisesV, String dominio) throws IOException{
        this.nome = nome;
        this.populacao = pop;
        this.iso = iso;
        this.area = area;
        this.capital = capital;
        this.cidadesPopulosas = cidadesV;
        this.crescPopulacao = Crescpop;
        this.dominioIT = dominio;
        this.idiomas = idiomas;
        this.moeda = moeda;
        this.paisesVizinhas = PaisesV;
        
    }
    
    public void printPais(){
        System.out.println("Nome Pais: " + this.nome);
        
        System.out.println("ISO: " + this.iso);
        System.out.println("Populacao: " + this.populacao);
        
        System.out.println("Area: " + this.area);
        System.out.println("Capital: " + this.capital);
        System.out.println("Cidades Mais Populosas: " + this.cidadesPopulosas);
        System.out.println("Crescimento populacional: " + this.crescPopulacao);
        System.out.println("Dominio IT: " + this.dominioIT);
        System.out.println("Idiomas: " + this.idiomas);
        System.out.println("Moeda: " + this.moeda);
        System.out.println("Paises Vizinhos: " + this.paisesVizinhas);
    }
    
}
