package org.study;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
    class SerializeJFrame extends JFrame
    {
        public SerializeJFrame()
        {
            setTitle("Size Serialized.");
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            try
            {
                FileInputStream fin=new FileInputStream("jf.dat");
                ObjectInputStream oin=new ObjectInputStream(fin);

                JFData jf=(JFData)oin.readObject();
                setLocation(jf.x,jf.y);
                setSize(jf.size);

                oin.close();
                fin.close();
            }catch(Exception e){}

            setVisible(true);

            addComponentListener(new ComponentAdapter(){
                public void componentResized(ComponentEvent ce)
                {

                    try
                    {

                        FileOutputStream fout=new FileOutputStream("jf.dat");
                        ObjectOutputStream out=new ObjectOutputStream(fout);

                        JFData jf=new JFData();
                        jf.x=getLocation().x;
                        jf.y=getLocation().y;
                        jf.size=getSize();

                        out.writeObject(jf);

                        out.close();
                        fout.close();

                    }catch(Exception e){}

                }
                public void componentMoved(ComponentEvent ce)
                {

                    try
                    {

                        FileOutputStream fout=new FileOutputStream("jf.dat");
                        ObjectOutputStream out=new ObjectOutputStream(fout);

                        JFData jf=new JFData();

                        jf.x=getLocation().x;
                        jf.y=getLocation().y;
                        jf.size=getSize();

                        out.writeObject(jf);

                        out.close();
                        fout.close();

                    }catch(Exception e){}

                }

            });
        }

        public static void main(String args[])
        {
            new SerializeJFrame();
        }

        class JFData implements Serializable
        {
            Dimension size=new Dimension(400,400);
            int x=0,y=0;
        }

    }

