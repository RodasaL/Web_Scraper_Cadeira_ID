/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpp;

import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Attribute;


/**
 *
 * 
 */
import org.jdom2.Attribute;
public class ModeloXML {
    
    public static Document adicionaPais(Pais pais, Document doc) {
        Element raiz;
        boolean found = false;
        
        if(doc == null) {
            raiz = new Element("lista");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        
        List todos = raiz.getChildren("pais");
        for(int i=0; i < todos.size(); i++) {
            Element esc = (Element)todos.get(i);
            if(esc.getAttributeValue("iso").contains(pais.getIso())) {
                esc.getParent().removeContent(esc);
                System.out.println("País encontrado, não é possível adicionar!");
                found = true;
            }
        }
        if(!found){
            
        
        Element pai = new Element("pais");
        
        Attribute iso = new Attribute("iso", pais.getIso());
        pai.setAttribute(iso);
        Element filho = new Element("nome").addContent(pais.getNome());
        pai.addContent(filho);
        filho = new Element("bandeira").addContent(pais.getBandeira());
        pai.addContent(filho);
        filho = new Element("iso").addContent(pais.getIso());
        pai.addContent(filho);
        filho = new Element("populacao").addContent(pais.getPopulacao());
        pai.addContent(filho);
        filho = new Element("continente").addContent(pais.getContinente());
        pai.addContent(filho);
        filho = new Element("presidente").addContent(pais.getPresidente());
        pai.addContent(filho);
        /*
        filho = new Element("ocupacoes");
        pai.addContent(filho);
        for(int i = 0; i < autor.getOcupacoes().size(); i++) {
            Element oc = new Element("ocupacao").addContent(autor.getOcupacoes().get(i));
            filho.addContent(oc);
        } */
        
        raiz.addContent(pai);
        
        System.out.println("\nPaís adicionado com sucesso!");
        }
        return doc;
    }
    
    public static Document removePais(String procura, Document doc){
        Element raiz;
        if(doc == null){
            raiz = new Element("lista");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        
        List todos = raiz.getChildren("pais");
        boolean found = false;
        for(int i=0; i < todos.size(); i++) {
            Element esc = (Element)todos.get(i);
            if(esc.getAttributeValue("iso").contains(procura)) {
                esc.getParent().removeContent(esc);
                System.out.println("\nPais removido com sucesso!");
                found = true;
            }
        }
        if(!found){
            System.out.println("O pais  " + procura + " não foi encontrado");
            return null;
        }
        
        return doc;
    }
    
    public static Document removeOcupacao(String escritor, String ocupacao, Document doc){
        Element raiz;
        if(doc == null){
            raiz = new Element("lista");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        List todos = raiz.getChildren("escritor");
        boolean found1 = false;
        boolean found2 = false;
        for(int i=0; i < todos.size(); i++) {
            Element esc = (Element)todos.get(i);
            if(esc.getAttributeValue("nome").contains(escritor)) {
                Element ocup = esc.getChild("ocupacoes");
                List lista_oc = ocup.getChildren("ocupacao");
                found1 = true;
                found2 = false;
                for(int j = 0; j < lista_oc.size(); j++) {
                    Element o = (Element) lista_oc.get(j);
                    if(o.getText().equals(ocupacao)){
                        o.getParent().removeContent(o);
                        System.out.println("Ocupação Removida");
                        found2 = true;
                    } 
                }
                
            }
        }
        if(!found1){
            System.out.println("Escritor " + escritor + " não foi encontrado");
            return null;
        }
          if(!found2){
            System.out.println("A ocupacao  " + ocupacao + " não foi encontrado");
            return null;
        }
      
        return doc;
    }
}
