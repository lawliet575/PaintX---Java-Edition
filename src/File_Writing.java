import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class File_Writing {
    String filename;
    Layers allLayers; //from board
    File writefile;
    PrintWriter writer;


    public File_Writing(String filename, Layers allLayers) {
        this.filename = filename;
        this.allLayers = allLayers;
        writefile=new File("src\\Files",filename); //location of files
    }

    public void dowrite(){
        try {
        writer=new PrintWriter(writefile); //ye to writer hai jani
        } catch (IOException e) {
            System.out.println("File error");
        }

        ArrayList<Layer> templayer=allLayers.Seperate_Layers;
        if(templayer.isEmpty()){
            return;
        }

        for (int i = 0; i < templayer.size(); i++) {
                   ArrayList<Shape> shapes=templayer.get(i).shapes;
                   if(!shapes.isEmpty()){
                     for (int j = 0; j < shapes.size(); j++) {
                        String temp=shapes.get(i).toString();
                        writer.println(temp);
                     }
                   } 
                   else continue;
        }

        writer.close();
    }




    
}
