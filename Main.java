import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

class Main {
  public static void main(String[] args) {

    while (true){

    Scanner myObj = new Scanner(System.in); 
    System.out.println("input a valid 5' to 3' segment of a DNA sequence whose length is a multiple of 3 (template strand)\nor enter 'exit' to quit:");
    String ogDna = myObj.nextLine(); 
    
    
    
    Scanner myObjTwo = new Scanner(System.in); 
    System.out.println("input a mutated version of your previously inputted DNA sequence of the same length, with only one mutation which affects a single base (in the case of a frameshift mutation, to keep the sequence length consistent, either take a base off or add one at the end)\nor enter 'exit' again to quit:");
    String mutatedVer = myObjTwo.nextLine(); 

    /*
    String ogMrna = mRNA.mGen(ogDna);
    String mutatedMrna = mRNA.mGen(mutatedVer);

    String[] ogAA = aaGen.acidSeq(ogMrna);
    String[] mutatedAA = aaGen.acidSeq(mutatedMrna);
    */


    if(ogDna.equals("exit")){
      break;
    }
    else if( ((ogDna.length() % 3) == 0) && ((mutatedVer.length() % 3) == 0) && (ogDna.length() == mutatedVer.length()) && (aaGen.validBases(ogDna)) && (aaGen.validBases(mutatedVer))
    //(!(Arrays.asList(mutatedAA).contains("Not a valid codon")) && !(Arrays.asList(ogAA).contains("Not a valid codon"))) 
    ){ 

    String ogMrna = mRNA.mGen(ogDna);
    String mutatedMrna = mRNA.mGen(mutatedVer);

    String[] ogAA = aaGen.acidSeq(ogMrna);
    String[] mutatedAA = aaGen.acidSeq(mutatedMrna);


    if(mutations.changeIndFind(ogDna, mutatedVer) > ogDna.length()){
      System.out.println("no mutation detected");
    }
    else if (mutations.silent(ogDna, mutatedVer, ogAA, mutatedAA)){
      System.out.println("the sequence has a silent mutation");
    }
    else if (mutations.nonsense(ogDna, mutatedVer, ogAA, mutatedAA)){
      System.out.println("the sequence has a nonsense mutation");
    }
    else if (mutations.missense(ogDna, mutatedVer, ogAA, mutatedAA)){
      System.out.println("the sequence has a missense mutation");
    }
    else if (mutations.frameshift(ogDna, mutatedVer)){
      System.out.println("the sequence has a frameshift mutation");
    }


    }


    else{
      System.out.println("invalid input, please try again");
    }





  }
    //System.out.println(mutations.frameshift(ogDna, mutatedVer));

    //System.out.println(Arrays.toString(ogAA));
    //System.out.println(Arrays.toString(mutatedAA));

     //System.out.println(aaGen.amAcGen("UAU"));
}
}
