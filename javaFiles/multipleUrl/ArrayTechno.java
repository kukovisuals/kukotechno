import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

class ArrayTechno {
   public static int counter = 0;
   public static void main(String args[]) throws IOException {
      String[] artistName = {"Diego Ferran","Diego G","Diego Quintero","DIESN","DIFERTH","Dilan Lugo","Dirt Vibes","Discoholycs","DiSRuPTiVe","DJ Alex Soul","DJ Care","DJ Crash","DJ Daw","DJ Fafo","Dj Femboy","DJ Fronter","DJ Fuad","DJ Goozo","DJ Guess","DJ Haze (CO)","DJ Jhon B","DJ Lush","DJ Maybe","DJ Moras","DJ Myrla","Dj Smilk"};
      Pattern patt = Pattern.compile("[\\s]");
      for (int i=0; i<10; i++) {
         Matcher artName = patt.matcher(artistName[i]);
         System.out.println(artName.replaceAll("")); 
         download("https://www.residentadvisor.net/dj/"+artName.replaceAll(""));
      }
   }
   public static void download(String urlString) throws IOException {
      URL url = new URL(urlString);
      counter ++;
      try(
         BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
         BufferedWriter writer = new BufferedWriter(new FileWriter("../artists/name"+counter+".html"));        
      ) {
         String line;
         while ((line = reader.readLine()) != null) {
            writer.write(line);
         }

         System.out.println("Page downloaded." + counter);
      }
   }
}
