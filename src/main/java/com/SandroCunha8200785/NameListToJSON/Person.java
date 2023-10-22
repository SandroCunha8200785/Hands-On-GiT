
package main.java.com.SandroCunha8200785.NameListToJSON;


/**
 *Classe que representa uma Pessoa
 * @author sandrocunha8200785
 */
public class Person implements Comparable<Person>{
    
    /**
     * Nome da pessoa
     */
    private String name;
    
    /**
     * Idade.
     */
    private int age;
    
    /**
     * PEso
     */
    private double weight;
    
    /**
     * Construtor vazio
     */
    public Person() {
        this.age = 0;
        this.name = "";
        this.weight = 0.0;
    }
    
    /**
     * Construtor com atributos
     * @param pName nome
     * @param pAge idade
     * @param pWeight peso
     */
    public Person(String pName, int pAge, double pWeight) {
        this.name = pName;
        this.age = pAge;
        this.weight = pWeight;
    }
    
    /**
     * Construtor copia
     * @param pPerson pessoa a copiar
     */
    public Person(Person pPerson){
        
        this.name = pPerson.getName();
        this.age = pPerson.getAge();
        this.weight = pPerson.getWeight();
        
    }
    
    /**
     * Devolve o nome
     * @return nome
     */
    public String getName() {
        return name;
    }
    /**
     * Define o nome
     * @param name nome
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Devolve a idade
     * @return idade
     */
    public int getAge() {
        return age;
    }
    /**
     * Deine a idade
     * @param age idade
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Devolve o peso
     * @return peso
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * Define o peso
     * @param weight peso
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /**
     * Imprime os dados da pessoa
     * @return String contendo os dados da pessoa
     */
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder("Person ->");
        
        sb.append("\tName: "); sb.append(this.name);
        sb.append("\tAge: "); sb.append(this.age);
        sb.append("\tWeight: "); sb.append(this.weight);
        
        return sb.toString();
    }
    
    /**
     * Realiza uma deep copy de uma Pessoa com auxilio do construtor copia
     * @return clone da pessoa
     * @throws CloneNotSupportedException 
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        
        return new Person(this);
    }
    
    /**
     * verifica a igualdade entre duas pessoas
     * @param obj Objeto Pessoa a comparar
     * @return true se identicas
     */
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        } 
        
        else if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        else {
            Person otherPerson = (Person) obj;
            
            return (this.name.equalsIgnoreCase(otherPerson.getName()) &&
                    this.age == otherPerson.getAge() &&
                    this.weight == otherPerson.getWeight() );
        }
    }

    /**
     * Compara duas pessoas em função da idade
     * @param pPerson pessoa a comparar
     * @return -1 se mais nova, 0 se com a mesma idade, 1 se pPerson é mais velha
     */
    @Override
    public int compareTo(Person pPerson) {
        
        if(this.age < pPerson.getAge()) return -1;
        if(this.age > pPerson.getAge()) return 1;
        else return 0;
    }
    
    
    
    
}
