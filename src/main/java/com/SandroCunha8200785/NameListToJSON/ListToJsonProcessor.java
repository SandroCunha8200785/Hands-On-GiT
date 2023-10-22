package main.java.com.SandroCunha8200785.NameListToJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *Classe que vai processar a lista de um ficheiro "fileName" que deverá conter os
 * dados sobre diferentes pessoas, e criar um ficheiro JSON com os seus dados. A classe
 * também deve ser capaz de imprimir as pessoas processadas na tela.
 * @author sandroCunha8200785
 */
public class ListToJsonProcessor {
    
    /**
     * Construtor que recebe o ficheiro a ler por parametro e cria um ArrayList
     * de Person(Pessoas) vazio.
     * @param fileName ficheiro a abrir.
     */
    public ListToJsonProcessor(String fileName) {
        
        this.fileName = fileName;
        this.list = new ArrayList<Person>();
    }
    
    /**
     * Atributo para o nome do ficheiro
     */
    private String fileName;
    /**
     * ArrayList que irá armazenar os nomes das pessoas
     */
    private ArrayList<Person> list;
    
    /**
     * Define um novo ficheiro
     * @param fileName novo ficheiro
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Devolve o ficheiro atual
     * @return nome do ficheiro atual
     */
    public String getFileName() {
        return fileName;
    }
    
    
    
    
    

    /**
     * Metodo que irá ler os nomes do ficheiro de texto
     */
    private void loadPeopleFromFile(){
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(this.fileName+".txt"));
            String line;

            while ((line = br.readLine()) != null) {
                
                String[] parts = line.split(" ");
                
                if (parts.length == 3) {
                    String nome = parts[0];
                    int idade = Integer.parseInt(parts[1]);
                    double peso = Double.parseDouble(parts[2]);
                    
                    Person pessoa = new Person(nome, idade, peso);
                    list.add(pessoa);
                }
            }

            br.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo que usa o metodo privado de leitura de nomes e cria um ficheiro JSON com os dados
     * 
     */
    public void exportNamesToJson() {
        
        this.loadPeopleFromFile();
        
        JSONArray personList = new JSONArray();

        for (Person person : this.list) {
            
            JSONObject personObject = new JSONObject();
            
            personObject.put("Name", person.getName());
            personObject.put("Idade", person.getAge());
            personObject.put("Peso", person.getWeight());
            
            personList.add(personObject);
        }

        JSONObject jsonContainer = new JSONObject();
        jsonContainer.put("PeopleList", personList);

        try (FileWriter file = new FileWriter(this.fileName+".json")) {
            file.write(jsonContainer.toJSONString());
            System.out.println("Nomes exportados para " + this.fileName+".json");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
