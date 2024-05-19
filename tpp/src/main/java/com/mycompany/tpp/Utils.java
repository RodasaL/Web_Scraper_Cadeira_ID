/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpp;
  import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * 
 */
public class Utils {
    

    public static String lerFicheiroTXT(String caminhoDoArquivo) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }
        
        return conteudo.toString();
    }
    
    

}
