import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

class Main {
  public static void main(String[] args) {

    while (true){
    
    // getting a DNA sequence from the user
    Scanner myObj = new Scanner(System.in); 
    System.out.println("input a valid 5' to 3' segment of a DNA sequence whose length is a multiple of 3 (template strand)\nor enter 'exit' to quit:");
    String ogDna = myObj.nextLine(); 
    
    // getting the mutated version of the DNA sequence    
    Scanner myObjTwo = new Scanner(System.in); 
    System.out.println("input a mutated version of your previously inputted DNA sequence of the same length, with only one mutation which affects a single base (in the case of a frameshift mutation, to keep the sequence length consistent, either take a base off or add one at the end)\nor enter 'exit' again to quit:");
    String mutatedVer = myObjTwo.nextLine(); 

    // testing if the user wants to exit the program
    if(ogDna.equals("exit")){
      break;
    }
    // checks for valid input and only proceeds if input is valid
    else if( ((ogDna.length() % 3) == 0) && ((mutatedVer.length() % 3) == 0) && (ogDna.length() == mutatedVer.length()) && (aaGen.validBases(ogDna)) && (aaGen.validBases(mutatedVer))){ 

    // initializing original and mutated mRNA sequences
    String ogMrna = mRNA.mGen(ogDna);
    String mutatedMrna = mRNA.mGen(mutatedVer);

    // initializing original and mutated amino acid sequences
    String[] ogAA = aaGen.acidSeq(ogMrna);
    String[] mutatedAA = aaGen.acidSeq(mutatedMrna);

    // checking for mutations
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

    // if input is invalid this is outputted and the program starts again
    else{
      System.out.println("invalid input, please try again");
    }





  }

}
}
