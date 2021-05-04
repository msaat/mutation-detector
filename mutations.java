import java.util.Arrays;

public class mutations{

  // missense() tests if a sequence has a missense mutation (one switched base that leads to a different amino acid sequence)
  public static boolean missense(String og, String mut,String[] ogArr, String[] mutArr){

    int indX = changeIndFind(og, mut);

    if(!(Arrays.equals(ogArr, mutArr)) && ((mut.substring(0, indX)).equals(og.substring(0, indX))) && ((mut.substring(indX+1, mut.length())).equals(og.substring(indX+1, og.length())))){
      return true;
    }
    else{
      return false;
    }
  }

  // silent() tests if a sequence has a silent mutation (one switched base that leads to the same amino acid sequence)
  public static boolean silent(String og, String mut, String[] ogArr, String[] mutArr){
    if(!(og.equals(mut)) && (Arrays.equals(ogArr, mutArr))){
      return true;
    }
    else{
      return false;
    }

  }

  // nonsense() tests if a sequence has a nonsense mutation (one switched base that leads to a new stop codon in the amino acid sequence)
  public static boolean nonsense(String og, String mut, String[] ogArr, String[] mutArr){
    if((mutArr[indxInNewArr(changeIndFind(og,mut))]).equals("Stop")){
      return true;
    }
    else{
      return false;
    }

  }

  // frameshift() tests if a sequence has a frameshift mutation (one inserted or removed base from the DNA sequence)
  public static boolean frameshift(String og, String mut){

    int changeIndx = changeIndFind(og, mut);

    if((mut.substring(changeIndx, mut.length()-1)).equals(og.substring(changeIndx+1,og.length()))){
      return true;
    }
    else if((mut.substring(changeIndx+1, mut.length())).equals(og.substring(changeIndx,og.length()-1))){
      return true;
    }
    else{
      return false;
    }

  }

  // indxInNewArr(), using the index of a codon that appears in a DNA sequence, determines the index of the amino acid it corresponds to an acid array 
  public static int indxInNewArr(int indx){
    int newIndex = 0;
    if (indx % 3 == 0){
      newIndex = (indx / 3);
    }
    else if ((indx - 1) % 3 == 0){
      newIndex = ((indx - 1) / 3);
    }
    else{
      newIndex = ((indx - 2) / 3);
    }
  return newIndex;
  }

  // changeIndFind() finds the index at which two DNA sequences differ, that is the index at which the mutation occurs
  public static int changeIndFind(String og, String mut){
    int indX = 0;
    for(int i = 0; i < og.length(); i++){
      if (og.charAt(i) != mut.charAt(i)){
        indX = i;
        break;
      }
      else{
        indX = og.length() + 1;
      } 
    }
    return indX;

  }


}