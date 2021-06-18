package gt.edu.umg.analisis1.examen_final;

import gt.edu.umg.analisis1.examen_final.builders.CaseBuilder;
import gt.edu.umg.analisis1.examen_final.builders.ComputerBuilder;
import gt.edu.umg.analisis1.examen_final.caseParts.HDD;
import gt.edu.umg.analisis1.examen_final.caseParts.Motherboard;
import gt.edu.umg.analisis1.examen_final.caseParts.PowerSource;
import gt.edu.umg.analisis1.examen_final.caseParts.Processor;
import gt.edu.umg.analisis1.examen_final.caseParts.RamMemory;
import gt.edu.umg.analisis1.examen_final.caseParts.SSD;
import gt.edu.umg.analisis1.examen_final.computerParts.Case;
import gt.edu.umg.analisis1.examen_final.computerParts.Keyboard;
import gt.edu.umg.analisis1.examen_final.computerParts.Monitor;
import gt.edu.umg.analisis1.examen_final.computerParts.Mouse;
import java.util.*;

public class ComputerBuilderFadade {
    private Scanner entry;

    private String clientName;

    private ComputerBuilder computerBuilder;

    private CaseBuilder caseBuilder;

    public ComputerBuilderFadade() {
        entry = new Scanner(System.in);
        computerBuilder = new ComputerBuilder();
        caseBuilder = new CaseBuilder();
    }
    
    public void facadeExecute(){
        System.out.println("\tBuen Día, BIENVENIDO");
        System.out.println("\tIngrese su nombre por favor: ");
        this.clientName = entry.nextLine(); 
        
        this.computerBuilder
                .addPart(new Monitor())
                .addPart(new Monitor())
                .addPart(new Mouse())
                .addPart(new Keyboard())
                .addPart(new Case())
                .build(this.clientName);
        
        this.caseBuilder
                .addPart(new HDD())
                .addPart(new Motherboard())
                .addPart(new PowerSource())
                .addPart(new Processor())
                .addPart(new RamMemory())
                .addPart(new RamMemory())
                .addPart(new SSD())
                .addPart(new SSD())
                .build();
    }
}