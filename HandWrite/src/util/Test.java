/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;

/**
 *
 * @author Abhirup Chakravarty
 * @project HandWriter 2D
 */
public class Test 
{
    int weights[][],input[][];
    int max = 144;
    
    Test()
    {
        weights = ImageManager.getPixelArrayFromBufferedImage(ImageManager.loadImage("weights.png"),false);
        input = ImageManager.getPixelArrayFromBufferedImage(ImageManager.loadImage("input1.png"),false);       
    }
    
    void compare()
    {
        int product[][] = multiplyMatrices(weights,input);
        int sum = findSumOfElements(product);
        System.out.println(sum);
    }
    
    void compare2()
    {
        
        int sum = 0;
        for(int i = 0; i<28; i++)
        {
            for(int j = 0; j<28; j++)
            {
                sum += input[i][j]*weights[i][j];
               
            }
            System.out.println();
        }
        
        float p = ((float)sum/(float)max)*100;
        System.out.println(sum);
        System.out.println(p + "% match!");
    }
    int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) 
    {
        int r1 = firstMatrix.length, c1 = firstMatrix[0].length, c2 = secondMatrix[0].length; 
        int[][] product = new int[r1][c2];
        for(int i = 0; i < r1; i++) 
        {
            for (int j = 0; j < c2; j++) 
            {
                for (int k = 0; k < c1; k++) 
                {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }
    int findSumOfElements(int [][] arr)
    {
        int sum = 0;
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j<arr[0].length; j++)
            {
                sum += arr[i][j];
            }            
        }    
        return sum;
    }
     
    public static void main(String [] args)
    {
        Test o1 = new Test();
        o1.compare();
        o1.compare2();
    }
}
