package main.java.com.SandroCunha8200785.NameListToJSON;
/**
 *Classe Principal
 * @author sandroCunha8200785
 */
public class NameListToJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListToJsonProcessor processor = new ListToJsonProcessor("C:\\Users\\sssan\\OneDrive\\Ambiente de Trabalho\\Estg\\2 Ano\\ESII\\Git Projects\\Hands On GiT\\src\\main\\Resources\\NameList");
        processor.exportNamesToJson();
    }
    
}
