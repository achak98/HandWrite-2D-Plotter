package util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Abhirup Chakravarty
 * @project HandWriter 2D
 */
public class ImageManager
{
    static BufferedImage a,b;
    static Random ran;
    
    public static BufferedImage loadImage(String path)
    {
        try
        {
            return ImageIO.read(ImageManager.class.getResource(path));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
    public static BufferedImage getBufferedImageFromArray(int arr[][])
    {
        BufferedImage bi = new BufferedImage(arr.length,arr[0].length,BufferedImage.TYPE_INT_RGB );
       
        System.out.println(bi.getWidth());
        for(int i = 0; i<bi.getHeight(); i++)
        {
            for(int j = 0; j<bi.getWidth(); j++)
            {
//                System.out.print(arr[i][j]);              
            }
            System.out.println();
        }
        
        for (int i = 0; i < bi.getHeight();i++)
        {
            for (int j = 0; j < bi.getWidth();j++) 
            {
                System.out.println(i + " " + j);
                bi.setRGB(i,j,arr[i][j]);
            }
        }
        return bi;
    }
    
    public static void saveBufferedImageAsFile(BufferedImage bi)
    {
        File outputFile = new File("C:\\Users\\ac\\Documents\\NetBeansProjects\\Handwrite\\src\\util\\final.png");
        try {
            ImageIO.write(bi,"png",outputFile);
        } catch (IOException ex) {
            Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int [][] getPixelArrayFromBufferedImage(BufferedImage bi)
    {
        int arr[][] = new int [bi.getHeight()][bi.getWidth()];
        for (int i = 0; i < bi.getHeight();i++)
        {
            for (int j = 0; j < bi.getWidth(); j++) 
            {
                arr[i][j] = bi.getRGB(j,i);                                   
            }
        }
        return arr;
    } 
    public static int [][] getPixelArrayFromBufferedImage(BufferedImage bi,boolean flag)
    {
        int arr[][] = new int [bi.getHeight()][bi.getWidth()];
        for (int i = 0; i < bi.getHeight();i++)
        {
            for (int j = 0; j < bi.getWidth(); j++) 
            {
                if(bi.getRGB(j,i) == -1)
                {
                    if(flag)
                        arr[i][j] = -1;
                    else
                        arr[i][j] = 0;
                }
                else
                {
                    arr[i][j] = 1;
                }                
            }
        }
        return arr;
    } 
    
    public static BufferedImage joinBufferedImageHorizontaly(BufferedImage img1, BufferedImage img2) 
    {
        ran = new Random();
        
        int offset = ran.nextInt(10) + 1;
        int width = img1.getWidth() + img2.getWidth() + offset;
        int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.dispose();
        
        return newImage;
    }
    
    public static BufferedImage joinBufferedImageVertically(BufferedImage img1, BufferedImage img2) 
    {
        ran = new Random();
        
        int offset = ran.nextInt(10) + 1;
        int height = img1.getHeight() + img2.getHeight() + offset;
        int width = Math.max(img1.getWidth(), img2.getWidth()) + offset;
        
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
                
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null,0,img1.getWidth() + offset);
        g2.dispose();
        
        return newImage;
    }  
}
