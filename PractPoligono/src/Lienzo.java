
import java.awt.Color;
import java.awt.Graphics;


public class Lienzo extends javax.swing.JPanel {
  
    private Puntos[] vertices;
    private int X;
    private int Y;
    private double Radio;
    private int Lados;
    public Lienzo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
   //Propiedades Escritura:
    public void setRadio(double DRadio) {
    this.Radio = DRadio;
    }

    public void setLados(int NLados) {
    this.Lados = NLados;
    }
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
            
    }//GEN-LAST:event_formMousePressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       this.X = evt.getX();
       this.Y = evt.getY();
    }//GEN-LAST:event_formMouseClicked

     @Override
    public void paint(Graphics g) {
    super.paint(g);
        
        for(int t=1;t<=this.Lados-1;t++)
        {
            int dx=0,dy=0;
            int x1 = vertices[t].getX();
            int x0 = vertices[t-1].getX();
            int y1 = vertices[t].getY();
            int y0 = vertices[t-1].getY();
            
            dx = x1 - x0;
            dy = y1 - y0;

             if (Math.abs(dx) > Math.abs(dy))
            {         
                float m = (float) dy / (float) dx;
                float b = y0 - m * x0;
                if(dx<0)
                    dx =  -1;
                else
                    dx =  1;
                while (x0 != x1)
                {
                    x0 += dx;
                    y0 = Math.round(m*x0 + b);
                    g.drawLine( x0, y0, x0, y0);
                }
            } else
            if (dy != 0)
            {                              
                float m = (float) dx / (float) dy;      
                float b = x0 - m*y0;
                if(dy<0)
                    dy =  -1;
                else
                    dy =  1;
                while (y0 != y1)
                {
                    y0 += dy;
                    x0 = Math.round(m * y0 + b);
                    g.setColor(Color.blue);
                    g.drawLine( x0, y0, x0, y0);
                }
            }
            
              
        }//fin for

        if (this.Lados>0)
         g.drawLine( vertices[this.Lados -1].getX(), vertices[this.Lados -1].getY(), vertices[0].getX(), vertices[0].getY());    
    
    }
    
    public void DibujarPoligono()
    {
        Poligonos();
        repaint();
    }
     private void Poligonos()
    {
        double alfa;
        int a, b;
        vertices = new Puntos[this.Lados];
        alfa = 2 * Math.PI / this.Lados;
        
        for(int i=0;i<=this.Lados-1;i++)
        {
           a= this.X + (int) (this.Radio * Math.cos((i - 1) * alfa));
           b= this.Y + (int) (this.Radio * Math.sin((i - 1) * alfa));
           vertices[i]= new Puntos(a,b);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
