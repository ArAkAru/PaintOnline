
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Paint extends JPanel {
    private ArrayList<Command> commands;
   
    
    public Paint(ArrayList<Command> commands) {
        this.commands = commands;
       // System.out.println(commands);
    }

    @Override
    public void paintComponent(Graphics g) {
    	Graphics2D graphics = (Graphics2D) g;
        Path2D.Double paint = new Path2D.Double();
        int width = getSize().width;
        int height = getSize().height;
        for (int i = 0; i < commands.size(); i ++) {
        	
        	switch(commands.get(i).getStep()) {
        	case "start":{
        		System.out.println("aa");
        		graphics.setColor(new Color(commands.get(i).getColor()));
        		paint.moveTo(commands.get(i).getcoordinateX() * width, commands.get(i).getcoordinateY() * height);
                break;
        	}
            
        	case "move":{
        		paint.curveTo(
        			/*
        			 * Adds a curved segment, defined by three new points, to the path by drawing a Bézier curve 
        			 * that intersects both the current coordinates and the specified coordinates
        			 * 
        			 */
        			commands.get(i).getcoordinateX() * width, commands.get(i).getcoordinateY() * height,
                    commands.get(i).getcoordinateX() * width, commands.get(i ).getcoordinateY() * height,
                    commands.get(i ).getcoordinateX() * width, commands.get(i).getcoordinateY() * height
            );
        		break;
        	}
        	
        	}
        	
        }
        graphics.draw(paint);
    }
}

