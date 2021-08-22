/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.image.BufferedImage;
import util.ImageManager;

/**
 *
 * @author Abhirup Chakravarty
 * @project HandWriter 2D
 */
public class CreateImage 
{
    BufferedImage alphabets[],fImage;
    String input = "abcdaba";
    
    CreateImage()
    {
        alphabets = new BufferedImage[27];
        alphabets[0] = ImageManager.loadImage("space.png");
        alphabets[1] = ImageManager.loadImage("a.png");
        alphabets[2] = ImageManager.loadImage("b.png");
        alphabets[3] = ImageManager.loadImage("c.png");
        alphabets[4] = ImageManager.loadImage("d.png");
        alphabets[5] = ImageManager.loadImage("e.png");
        
        
        fImage = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
    }
    
    void create()
    {
        for(int i = 0; i<input.length();i++)
        {
            if(Character.isWhitespace(input.charAt(i)))
            {
                fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[0]);
            }
            switch (input.charAt(i)) {
                case 'a':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[1]);
                    break;
                case 'b':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[2]);
                    break;
                case 'c':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[3]);
                    break;
                case 'd':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[4]);
                    break;
                case 'e':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[5]);
                    break;
                case 'f':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[6]);
                    break;
                case 'g':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[7]);
                    break;
                case 'h':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[8]);
                    break;
                case 'i':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[9]);
                    break;
                case 'j':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[10]);
                    break;
                case 'k':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[11]);
                    break;
                case 'l':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[12]);
                    break;
                case 'm':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[13]);
                    break;
                case 'n':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[14]);
                    break;
                case 'o':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[15]);
                    break;
                case 'p':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[16]);
                    break;
                case 'q':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[17]);
                    break;
                case 'r':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[18]);
                    break;
                case 's':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[19]);
                    break;
                case 't':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[20]);
                    break;
                case 'u':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[21]);
                    break;
                case 'v':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[22]);
                    break;
                case 'w':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[23]);
                    break;
                case 'x':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[24]);
                    break;
                case 'y':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[25]);
                    break;
                case 'z':
                    fImage = ImageManager.joinBufferedImageHorizontaly(fImage,alphabets[26]);
                    break;
            }
        }
        ImageManager.saveBufferedImageAsFile(fImage);
    }
        
    public static void main(String [] args)
    {
        CreateImage o1 = new CreateImage();
        o1.create();        
    }
    
}
