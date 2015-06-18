package com.kyumdroid.study.algorithm.cording.interview;

/**
 * (문제) 이미지를 표현하는 N x N 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
 *        이때 이미지를 90도 회전시키는 메서드를 작성하라.
 *        부가적인 행렬을 사용하지 않고서도  할 수 있겠는가?
 *   
 * 
 *
 */
public class Exam0106
{
    public static void main(String[] args)
    {
        int[][] image = new int[][]{{1,4,5,0},
                                                {7,12,3,57},
                                                {3,63,44,2},
                                                {2,74,33,53}}; 
        print(image);
        
        Exam0106.rotate(image);
        
        print(image);

    }
    
    
    public static void rotate(int[][] image)
    {
        int length = image.length;
        int first = 0;
        int last = 0;
        int temp = 0;
        int offset = 0;
        
        for(int i = 0; i < length/2; i++)
        {
            first = i;
            last = length - 1 - i;
            
            for(int j = first; j < last; j++)
            {
                offset = j - first;
                
                temp = image[first][j];
                
                // 왼쪽 아래 -> 왼쪽 위
                image[first][j] = image[last - offset][first];
                
                // 오른쪽 아래 - > 왼쪽 아래
                image[last - offset][first] = image[last][last - offset];
                
                //오른쪽 위 - > 오른쪽 아래
                image[last][last - offset] = image[j][last];
                
                //왼쪽 위 -> 오른쪽 위
                image[j][last] = temp;
            }
        }
        
        
        
    }
    
    public static void print(int[][] image)
    {
        int rowLenth = image.length;
        int columnLength = image[0].length;
        
        for(int i = 0; i < rowLenth; i++)
        {
            for(int j = 0; j < columnLength; j++)
            {
                System.out.print(image[i][j] +", ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
