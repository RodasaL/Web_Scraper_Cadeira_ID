/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pedro
 */
public class Wrappers {
        public static String obtemBandeiraLink(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "<img alt=\"Flag of.*?src=\"(.*?)\"";
        String er2 = "src=\"(.*?)\"";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                //ler.nextLine();
                //System.out.println("Hello World! 1");
                return m1.group(1);
            }
        }
        
        ler.close();
        return null;
    }
    
    
    
     public static String obtemISO(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "ISO 3166-2:[A-Z]*\">([^<]+)";
        String er2 = "";

        Pattern p1 = Pattern.compile(er1);
        //Pattern p2 = Pattern.compile(er2);

        Matcher m1;//, m2;
        String linha;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                ler.close();
                return m1.group(1);
            }
        }
        
        ler.close();
        return null;
    }
     
     
     
    public static String obtemCapital(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "<td class=\"infobox-data\"><a href=\"/wiki/([A-Za-z]+)\"";

        Pattern p1 = Pattern.compile(er1);
        Matcher m1;
        String linha;   
       
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                ler.close();
                return m1.group(1);
            }
        }     
        ler.close();
        return null;
    }
    
    public static String obtemMoeda(String pesquisa) throws FileNotFoundException, IOException {

        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Currency</th><td class=\"infobox-data\"><a href=\"/wiki/([A-Za-z]+)\"";

        Pattern p1 = Pattern.compile(er1);

        Matcher m1;
        String linha;
            
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                ler.close();
                return m1.group(1);
            }
        }
        
        ler.close();
        return null;
    }
    
    
    
    
    
    
    
    public static String obtemDominioInternet(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Internet TLD";
        String er2 = "><a href=\"/wiki/([a-z.]+)\"";

        

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        
        ler.close();
        return null;
    }
    
    public static String Pop(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://web.archive.org/web/20231130205007/https://www.countryreports.org/country/";

        HttpRequestFunctions.httpRequest1a(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Population[\\s]+</td>";
        String er2 = "([0-9,]+)";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                linha = ler.nextLine(); // td lixo
                linha = ler.nextLine();
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }
    
    
    public static String Area(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://web.archive.org/web/20231130205007/https://www.countryreports.org/country/";

        HttpRequestFunctions.httpRequest1a(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Total Area[\\s]+</td>";
        String er2 = "<br/>[\\s]*([\b0-9][A-Za-z0-9,\\s]+)";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                linha = ler.nextLine(); // td lixo
                linha = ler.nextLine();
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }
    
    
    
    public static String IdiomasOficiais(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://web.archive.org/web/20231130205007/https://www.countryreports.org/country/";

        HttpRequestFunctions.httpRequest1a(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Language[\\s]+</td>";
        String er2 = "([\bA-Z][A-Za-z\\s,\\(\\)-]+)";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                linha = ler.nextLine(); // td lixo
                linha = ler.nextLine();
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }
    
    public static String PaisesVizinhos(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://web.archive.org/web/20231130205007/https://www.countryreports.org/country/";

        HttpRequestFunctions.httpRequest1a(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Location[\\s]+</td>";
        String er2 = "([\bA-Z][A-Za-z\\s,\\(\\)-]+)";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                linha = ler.nextLine(); // td lixo
                linha = ler.nextLine();
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }
    
    public static String CrescimentoPop(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://web.archive.org/web/20231130205007/https://www.countryreports.org/country/";
        HttpRequestFunctions.httpRequest1a(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Population Growth Rate[\\s]+</td>";
        String er2 = "([\b0-9\\.%]+)";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;

        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                linha = ler.nextLine(); // td lixo
                linha = ler.nextLine();
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }
    
    public static String CidadesmaisPop(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://web.archive.org/web/20231130205007/https://www.countryreports.org/country/";

        HttpRequestFunctions.httpRequest1a(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Population in Major Urban Areas[\\s]+</td>";
        String er2 = "([\bA-Z][A-Za-z0-9\\s,\\(\\)\\.;-]+)";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                linha = ler.nextLine(); // td lixo
                linha = ler.nextLine();
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }

    
    
    
    public static String obtemContinente(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "Show globe";
        String er2 = "–&#160;in <a href=\"/wiki/[A-Za-z]+\" title=\"([A-Za-z]+)\">";

        

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        
        ler.close();
        return null;
    }
    
    public static String obtemPresidente(String pesquisa) throws FileNotFoundException, IOException {
        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "paises.html");
        Scanner ler = new Scanner(new FileInputStream("paises.html"));
        String er1 = "President";
        String er2 = "</a> </div></th><td class=\"infobox-data\">[<span class=\"nowrap\">]*<a href=\"/wiki/[A-Za-z_]+\" title=\"[A-Za-z\\s]+\">([A-Za-z\\s]+)</a>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1, m2;
        String linha;
        int flag = 1;
        
        while(ler.hasNextLine()){
            linha = ler.nextLine();
            m1 = p1.matcher(linha);
            if(m1.find()){
                m2 = p2.matcher(linha);
                if(m2.find()){
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        
        ler.close();
        return null;
    }

     public static Pais criaPais(String pesquisa) throws IOException {
         String bandeira = obtemBandeiraLink(pesquisa);
         String isoP = obtemISO(pesquisa);
         String populacao = Pop(pesquisa);
         String continente = obtemContinente(pesquisa);
         String presidente = obtemPresidente(pesquisa);
         if(isoP != null) {
            Pais PaisACriar = new Pais(pesquisa, bandeira, populacao, isoP, continente, presidente);
            return PaisACriar;
         }
         return null;
     } 
     
     public static Factos criaPaisFactos(String pesquisa) throws IOException {
         String bandeira = obtemBandeiraLink(pesquisa);
         String isoP = obtemISO(pesquisa);
         String populacao = Pop(pesquisa);
         String continente = obtemContinente(pesquisa);
         String presidente = obtemPresidente(pesquisa);
         String capital = obtemCapital(pesquisa);
         String moeda = obtemMoeda(pesquisa);
         String area = Area(pesquisa);
         String crescPop = CrescimentoPop(pesquisa);
         String cidades = CidadesmaisPop(pesquisa);
         String dominio = obtemDominioInternet(pesquisa);
         String idiomas = IdiomasOficiais(pesquisa);
         String paises = PaisesVizinhos(pesquisa);
         
         
         if(isoP != null) {
            Factos PaisACriar = new Factos(pesquisa, bandeira, populacao, isoP, continente, presidente,
            area, capital, cidades, crescPop, idiomas, moeda, paises, dominio);
            return PaisACriar;
         }
         return null;
     } 
    
}
