/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tpp;

import static com.mycompany.tpp.ModeloXML.adicionaPais;
import static com.mycompany.tpp.XPathFunctions.executaXpath;
import static com.mycompany.tpp.XPathFunctions.listaResultado;
import static com.mycompany.tpp.XPathFunctions.listaResultadoPopulacao;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;
import net.sf.saxon.trans.XPathException;
import org.jdom2.Document;

/**
 *
 * 
 */
public class Tpp {

    public static void main(String[] args) throws IOException, SaxonApiException, XPathException {
        String pesquisa = null;
        Document doc = null;
        Document doc2 = null;
        Pais exemplo = new Pais();
        Factos exemplo2 = new Factos();
        Jframe app = new Jframe();
        app.setVisible(true);
      
    }
}
