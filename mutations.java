import java.util.Arrays;

public class mutations{

  public static boolean missense(String og, String mut,String[] ogArr, String[] mutArr){

    int indX = changeIndFind(og, mut);

    if(!(Arrays.equals(ogArr, mutArr)) && ((mut.substring(0, indX)).equals(og.substring(0, indX))) && ((mut.substring(indX+1, mut.length())).equals(og.substring(indX+1, og.length())))){
      return true;
    }
    else{
      return false;
    }
  }

  public static boolean silent(String og, String mut, String[] ogArr, String[] mutArr){
    if(!(og.equals(mut)) && (Arrays.equals(ogArr, mutArr))){
      return true;
    }
    else{
      return false;
    }

  }

/*
  public static boolean nonsense(String og, String mut, String[] ogArr, String[] mutArr){
    if(!(Arrays.equals(ogArr, mutArr)) && (Arrays.asList(mutArr).contains("Stop"))){
      return true;
    }
    else{
      return false;
    }

  }
*/

  public static boolean nonsense(String og, String mut, String[] ogArr, String[] mutArr){
    if((mutArr[indxInNewArr(changeIndFind(og,mut))]).equals("Stop")){
      return true;
    }
    else{
      return false;
    }

  }

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