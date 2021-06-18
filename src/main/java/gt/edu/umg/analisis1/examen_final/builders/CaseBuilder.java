package gt.edu.umg.analisis1.examen_final.builders;

import gt.edu.umg.analisis1.examen_final.caseParts.CasePart;
import gt.edu.umg.analisis1.examen_final.caseParts.HDD;
import gt.edu.umg.analisis1.examen_final.caseParts.Motherboard;
import gt.edu.umg.analisis1.examen_final.caseParts.PowerSource;
import gt.edu.umg.analisis1.examen_final.caseParts.Processor;
import gt.edu.umg.analisis1.examen_final.caseParts.RamMemory;
import gt.edu.umg.analisis1.examen_final.caseParts.SSD;
import java.util.*;

public class CaseBuilder {

    private Map<String,Integer> partsCount;
    private List<CasePart> parts;
    
    public static final int MAX_HDD = 2;
    public static final int MAX_MOTHERBOARD = 1;
    public static final int MAX_POWERSOURCE = 1;
    public static final int MAX_PROCESSOR = 1;
    public static final int MAX_RAM = 4;
    public static final int MAX_SSD = 2;
    
    public CaseBuilder() {
        this.partsCount = new HashMap();
        this.parts = new LinkedList();
    }

    public CaseBuilder addPart(CasePart part) {
        this.parts.add(part);
        return this;
    }

    public void build() {
        this.reviewParts();
        
        this.buildInvoice();        
    }

    public void reviewParts() {
        for(CasePart casePart: this.parts){
            if(this.partsCount.containsKey(casePart.getName())){
                int maxAllowedParts=1;
                if(casePart instanceof HDD){
                    maxAllowedParts=MAX_HDD;
                }else if(casePart instanceof Motherboard){
                    maxAllowedParts=MAX_MOTHERBOARD;    
                }else if(casePart instanceof PowerSource){
                    maxAllowedParts=MAX_POWERSOURCE;    
                }else if(casePart instanceof Processor){
                    maxAllowedParts=MAX_PROCESSOR;    
                }else if(casePart instanceof RamMemory){
                    maxAllowedParts=MAX_RAM;    
                }else if(casePart instanceof SSD){
                    maxAllowedParts=MAX_SSD;    
                }
                
                if (this.partsCount.get(casePart.getName()) >= maxAllowedParts) {
                    System.out.println(String.format("Se excedió cantidad máxima de cantidad de partes de %s",casePart.getName()));
                }
                this.partsCount.put(casePart.getName(), this.partsCount.get(casePart.getName()) + 1);
            }else {
                this.partsCount.put(casePart.getName(), 1);
            }
        }
    }

    public void buildInvoice() {
        ComputerBuilder computerBuilder = new ComputerBuilder();
        double totalSinIva=0;
        double iva=0;
        double total=0;
        
        System.out.println("|   \t\tCANTIDAD        DESCRIPCIÓN                     \t\tP/U");
        
        for (CasePart casePart : this.parts) {          
            
            System.out.println(String.format("|   \t\t 1 \t\t %s\t\t\t%,.2f", casePart.getName(),casePart.getPrice()));
            
            totalSinIva += casePart.getPrice();
        }
        totalSinIva+=computerBuilder.getTotalSinIva();
        iva=(totalSinIva*0.12)+computerBuilder.getIva();
        total=(totalSinIva+iva)+computerBuilder.getTotal();
       
        System.out.println("____________________________________________________________________________________________");
        System.out.println(String.format("|   TOTAL: Q. %,.2f",totalSinIva));
        System.out.println(String.format("|   IVA: Q. %,.2f",iva));
        System.out.println(String.format("|TOTAL A PAGAR: Q. %,.2f",total));
        System.out.println("|\n|\n=======================================================================================");
        
    }
    

}