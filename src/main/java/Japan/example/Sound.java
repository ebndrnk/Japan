package Japan.example;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sound{
   public static Player player;
   static Thread startListening;


    public static void start(){

         startListening = new Thread(() -> {
             try {
                 player = new Player(new FileInputStream("C:\\Users\\Егор\\Desktop\\Японская музыка\\Japan\\yaponskaya-muzyka-grustnaya-yaponskaya-muzyka.mp3"));
                 player.play();
             } catch (JavaLayerException | FileNotFoundException e) {
                 throw new RuntimeException(e);
             }
         });
         startListening.start();

    }







    public static void stop(){
        player.close();
    }
}