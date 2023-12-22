
package makeasquare;

import java.awt.Color;
import javax.swing.JFrame;



public class MakeASquare {
    
    public static void main(String[] args)  {
        openForm(new InputPieces());
        
    }

    // open any form
        public static void openForm(JFrame form) {
            form.setLocationRelativeTo(null);
            form.setDefaultCloseOperation(2);
            form.getContentPane().setBackground(Color.white);
            form.pack();
            form.setVisible(true);
    }

}
