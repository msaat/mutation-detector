public class aaGen{

  public static String amAcGen(String codon) {
    String acid = "";
    if (codon.charAt(0) == 'U')
    {
      if (codon.charAt(1) == 'U')
      {
        if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C')
        {
          acid = "Phenylalanine";
        }
        else
        {
          acid = "Leucine";
        }
      }
      else if (codon.charAt(1) == 'C')
      {
        acid = "Serine";
      }
      else if (codon.charAt(1) == 'A')
      {
        if (codon.charAt(2) == 'U' ||codon.charAt(2) == 'C')
        {
          acid = "Tyrosine";
        }
        else
        {
          acid = "Stop";
        }
      }
      else if (codon.charAt(1) == 'G')
      {
        if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C')
        {
          acid = "Cysteine";
        }
        else if (codon.charAt(2) == 'G')
        {
          acid = "Tryptophan";
        }
        else
        {
          acid = "Stop";
        }
      }
    }
    else if (codon.charAt(0) == 'C')
    {
      if (codon.charAt(1) == 'U')
      {
        acid = "Leucine";
      }
      else if (codon.charAt(1) == 'C')
      {
        acid = "Proline";
      }
      else if (codon.charAt(1) == 'G')
      {
        acid = "Arginine";
      }
      else if (codon.charAt(1) == 'A')
      {
        if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C')
        {
          acid = "Histidine";
        }
        else{
          acid = "Glutamine";
        }
      }
    }
    else if (codon.charAt(0) == 'A')
    {
      if (codon.charAt(1) == 'U')
      {
        if (codon.charAt(2) == 'G')
        {
          acid = "Methianine";
        }
        else
        {
          acid = "Isoleucine";
        }
      }
      else if (codon.charAt(1) == 'C')
      {
        acid = "Threonine";
    }
    else if (codon.charAt(1) == 'A')
    {
      if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C')
        {
          acid = "Asparagine";
        }
        else
        {
          acid = "Lysine";
        }
    }
    else if (codon.charAt(1) == 'G')
    {
      if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C')
        {
          acid = "Serine";
        }
        else
        {
          acid = "Arginine";
        }
    }
  }
  else if (codon.charAt(0) == 'G')
    {
      if (codon.charAt(1) == 'U')
      {
        acid = "Valine";
      }
      else if (codon.charAt(1) == 'C')
      {
        acid = "Alanine";
    }
    else if (codon.charAt(1) == 'A')
    {
      if (codon.charAt(2) == 'U' || codon.charAt(2) == 'C')
        {
          acid = "Aspartic acid";
        }
        else
        {
          acid = "Glutamic acid";
        }
    }
    else if (codon.charAt(1) == 'G')
    {
      acid = "Glycine";
        }
    }
    //else {
    //  acid = "Not a valid codon";
    //}

    return acid;
    
  }

  public static String[] acidSeq(String mrna){
    String[] acidArray = new String[(mrna.length())/3];
    int indX = 0;
    for(int i = 0; i < mrna.length(); i = i+3){
      acidArray[indX] = amAcGen(mrna.substring(i,i+3));
      indX++;
    }
    return acidArray;
  }

  public static boolean validBases(String dna){

    Boolean result = true;
    
    for (int i = 0; i < dna.length(); i++){
      if( (dna.charAt(i) == 'A') || (dna.charAt(i) == 'T') || (dna.charAt(i) == 'C') || (dna.charAt(i) == 'G') ){
        result = true;
      }
      else{
        result = false;
        break;
      }
    }
    return result;
  }




/*
  public static String[] codonSeq(String mrna){
    String[] codonArray = new String[(mrna.length())/3];
    int indX = 0;
    for(int i = 0; i < mrna.length(); i = i+3){
      codonArray[indX] = mrna.substring(i,i+3);
      indX++;
    }
    return codonArray;
  }
*/


}