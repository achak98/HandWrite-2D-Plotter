/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Abhirup Chakravarty
 * @project HandWriter 2D
 */
public class JoinImage {

    public static void main(String args[]) throws Exception 
    {
        BufferedImage img1 = ImageIO.read(new File("C:\\Users\\ac\\Documents\\NetBeansProjects\\Handwrite\\src\\util\\a.png"));
        BufferedImage img2 = ImageIO.read(new File("C:\\Users\\ac\\Documents\\NetBeansProjects\\Handwrite\\src\\util\\b.png"));
        BufferedImage joinedImg = joinBufferedImage(img1, img2);
        ImageIO.write(joinedImg, "png", new File("C:\\Users\\ac\\Documents\\NetBeansProjects\\Handwrite\\src\\util\\joined.png"));
    }

    public static BufferedImage joinBufferedImage(BufferedImage img1,BufferedImage img2)
    {
        int offset = 2;
        int width = img1.getWidth() + img2.getWidth() + offset;
        int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.dispose();
        return newImage;
    }
}


