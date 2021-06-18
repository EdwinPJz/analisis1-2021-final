package gt.edu.umg.analisis1.examen_final.builders;

import gt.edu.umg.analisis1.examen_final.computerParts.Case;
import gt.edu.umg.analisis1.examen_final.computerParts.Keyboard;
import gt.edu.umg.analisis1.examen_final.computerParts.Monitor;
import gt.edu.umg.analisis1.examen_final.computerParts.Mouse;
import gt.edu.umg.analisis1.examen_final.computerParts.Part;
import java.util.*;

public class ComputerBuilder {
    public static final int MAX_MONITOR = 2;
    public static final int MAX_MOUSE = 1;
    public static final int MAX_KEYBOARD = 1;
    public static final int MAX_CASE = 1;
    
    private Map<String,Integer> partsCount;
    private List<Part> parts;
    
    private double totalSinIva=0;
    private double iva=0;
    private double total=0;
    
    public ComputerBuilder() {
        this.partsCount = new HashMap();
        this.parts = new LinkedList();
    }

    public ComputerBuilder addPart(Part part) {
        this.parts.add(part);
        return this;
    }

    public void build(String clientName) {
        this.reviewParts();
        
        this.buildInvoice(clientName);
    }

    public void reviewParts() {
        for(Part part: this.parts){
            if(this.partsCount.containsKey(part.getName())){
                int maxAllowedParts=1;
                if(part instanceof Monitor){
                    maxAllowedParts=MAX_MONITOR;
                }else if(part instanceof Mouse){
                    maxAllowedParts=MAX_MOUSE;
                }else if(part instanceof Keyboard){
                    maxAllowedParts=MAX_KEYBOARD;
                }else if(part instanceof Case){
                    maxAllowedParts=MAX_CASE;
                }
                if (this.partsCount.get(part.getName()) >= maxAllowedParts) {
                    System.out.println(String.format("Se excedió cantidad máxima de cantidad de partes de %s",part.getName()));
                }
               
                this.partsCount.put(part.getName(), this.partsCount.get(part.getName()) + 1);
                
            }else{
                this.partsCount.put(part.getName(), 1);
            }       
        }
    }

    public void buildInvoice(String clientName) {
        
        System.out.println("===========================================================================================");
        System.out.println("|");
        System.out.println("|\t\t\t\tCOTIZACIÓN DE COMPUTADORA ARMADA");
        System.out.println("============================================================================================");
        System.out.println(String.format("|\n|\tCLIENTE: %s",clientName));
        System.out.println("============================================================================================");
        System.out.println("|\t\t\t\tDESCRIPCIÓN DE PARTES SOLICITADAS");
        System.out.println("____________________________________________________________________________________________");
        System.out.println("|   CANTIDAD        DESCRIPCIÓN                 \t\tP/U");
        
        for (Part part : this.parts) {          
            
            System.out.println(String.format("|   1\t\t %s\t\t\t%,.2f", part.getName(),part.getPrice()));
            
            totalSinIva += part.getPrice();
        }
        
        System.out.println("____________________________________________________________________________________________");
        
        this.iva=this.totalSinIva*0.12;
        this.total=this.totalSinIva+this.iva;
                
    }

    public double getTotalSinIva() {
        return totalSinIva;
    }

    public void setTotalSinIva(double totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    

}