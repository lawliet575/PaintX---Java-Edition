import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class EditButton extends Button {
     Button redoButton;
     Button undoButton;
     


    public EditButton(int x, int y, int width, int height) {
        super(x, y, width, height, Color.BLACK,Color.WHITE,"Edit");

        // Create the redo button
        redoButton = new Button(x, y + height, width, height,Color.BLACK,Color.WHITE,"Redo");


        // Create the undo button
        undoButton = new Button(x, y + 2 * height, width, height, Color.BLACK,Color.WHITE,"Undo");
    }

    public int handleClick(int x, int y){
        Toggle(x,y);
        if(super.getClicked()) {
            if(redoButton.Clicked(x,y)){
                //System.out.println("Redo"); //yaha pe redo functionality ayegi           
                return 0;
            }
            if(undoButton.Clicked(x,y)){
                //System.out.println("Undo"); //yaha ye undo functionality after undo button clicked
                return 1;
            }
        }

        return -1;

    }


   

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(super.getClicked()){
            redoButton.paint(g);
            undoButton.paint(g);
        }

    }

    public void Key(char key){
        if(key == 'u'){
            System.out.println("Undo");
        }
        if(key == 'r'){
            System.out.println("Redo");
        }
    }
}
