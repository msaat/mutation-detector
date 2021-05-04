public class mRNA{

  // mGen() generates the corresponding MRNA sequence for a DNA sequence
  public static String mGen(String dSeq) {
    String mrna = "";
    for(int i = 0; i < dSeq.length(); i++){
      if(dSeq.substring(i,i+1).equals("T")){
        mrna = mrna + "A";
      }
      else if (dSeq.substring(i,i+1).equals("A")){
        mrna = mrna + "U";
      }
      else if (dSeq.substring(i,i+1).equals("C")){
        mrna = mrna + "G";
      }
      else{
        mrna = mrna + "C";
      }
    }
    return mrna;

  }

}