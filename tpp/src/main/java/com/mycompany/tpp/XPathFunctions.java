/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpp;

import java.io.File;
import java.util.List;
import net.sf.saxon.s9api.Axis;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmSequenceIterator;
import net.sf.saxon.s9api.XdmValue;

/**
 *
 * 
 */
public class XPathFunctions {

    static XdmValue executaXpath(String xp, String xmlFile) throws SaxonApiException {
        XdmValue resultado = null;
        File f = new File(xmlFile);
        if (f.exists()) {
            Processor proc = new Processor(false);
            XPathCompiler xpath = proc.newXPathCompiler();

            DocumentBuilder builder = proc.newDocumentBuilder();

            XdmNode xml = builder.build(new File(xmlFile));
            XPathSelector selector = xpath.compile(xp).load();

            selector.setContextItem(xml);
            resultado = selector.evaluate();
        }
        return resultado;
    }

    static String listaResultado(XdmValue lista) {
        if (lista != null) {
            StringBuilder texto = new StringBuilder();
            System.out.println("RESULTADO DA PESQUISA XPATH:");
            for (XdmItem item : lista) {
                if (item instanceof XdmNode) {
                    XdmNode node = (XdmNode) item;
                    String nodeName = node.getNodeName().getLocalName();
                    texto = texto.append(nodeName).append(": ").append(item.getStringValue()).append("\n");
                }
            }
            return texto.toString();
        }
        else
            return "Ficheiro XML não existe";

    }
    
    static String listaResultadoPopulacao(XdmValue lista) {
    if (lista != null) {
        long maxPopulation = Long.MIN_VALUE;
        String maxPopulationISO = "";
        String maxPop = "";

        // Iterar sobre as populações para encontrar o máximo
        for (XdmItem item : lista) {
            if (item instanceof XdmNode) {
                XdmNode populationNode = (XdmNode) item;
                String populationStr = populationNode.getStringValue().replaceAll(",", "");
                if(!populationStr.isEmpty()) {
                    long population = Long.parseLong(populationStr);
                
                
                // Se encontrarmos uma população maior, atualizamos o máximo
                if (population > maxPopulation) {
                    maxPopulation = population;
                    maxPop =  item.getStringValue();
                    // Obter o ISO do país correspondente a esta população
                    XdmNode isoNode = (XdmNode) populationNode.axisIterator(Axis.PRECEDING_SIBLING).next();
                    maxPopulationISO = isoNode.toString();
                }
                }
            }
        }

        // Imprimir o país com a população máxima
        if (!maxPopulationISO.isEmpty()) {
            StringBuilder texto = new StringBuilder();
            texto.append("\nPaís com a maior população:\n");
            texto.append("ISO: ").append(maxPopulationISO).append("\n");
            texto.append("População: ").append(maxPop).append("\n");
            return texto.toString();
        } else {
            return "Nenhum país encontrado.";
        }
    } else {
        return "Ficheiro XML não existe";
    }
}
    
    
    static String listaResultadoPopulacao1(XdmValue lista) {
    if (lista != null) {
        long maxPopulation = Long.MIN_VALUE;
        String maxPopulationISO = "";
        String maxPop = "";
        String maxNome = "";  // Para armazenar o nome do país com a maior população

        // Iterar sobre as populações para encontrar o máximo
        for (XdmItem item : lista) {
            if (item instanceof XdmNode) {
                XdmNode populationNode = (XdmNode) item;
                String populationStr = populationNode.getStringValue().replaceAll(",", "");
                if (!populationStr.isEmpty()) {
                    long population = Long.parseLong(populationStr);

                    // Se encontrarmos uma população maior, atualizamos o máximo
                    if (population > maxPopulation) {
                        maxPopulation = population;
                        maxPop = populationStr;

                        // Obter o nó <pais> (pai do nó <populacao>)
                        XdmNode paisNode = (XdmNode) populationNode.getParent();

                        // Iterar sobre os filhos do nó <pais> para encontrar o nó <nome> e <iso>
                        XdmSequenceIterator children = paisNode.axisIterator(Axis.CHILD);
                        while (children.hasNext()) {
                            XdmNode child = (XdmNode) children.next();
                            if (child.getNodeName().getLocalName().equals("nome")) {
                                maxNome = child.getStringValue();
                            }
                            if (child.getNodeName().getLocalName().equals("iso")) {
                                maxPopulationISO = child.getStringValue();
                            }
                        }
                    }
                }
            }
        }

        // Imprimir o país com a população máxima
        if (!maxPopulationISO.isEmpty() && !maxNome.isEmpty()) {
            StringBuilder texto = new StringBuilder();
            texto.append("\nPaís com a maior população:\n");
            texto.append("Nome: ").append(maxNome).append("\n");
            texto.append("ISO: ").append(maxPopulationISO).append("\n");
            texto.append("População: ").append(maxPop).append("\n");
            return texto.toString();
        } else {
            return "Nenhum país encontrado.";
        }
    } else {
        return "Ficheiro XML não existe.";
    }
}


    static long parsePopulation(String populationStr) {
    // Remove vírgulas da string de população e converte para long
    String cleanPopulationStr = populationStr.replaceAll(",", "");
    return Long.parseLong(cleanPopulationStr);
}


}
