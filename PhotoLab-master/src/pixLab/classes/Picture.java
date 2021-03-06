package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void chromakey(Picture greenScreen)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] greenPixels = greenScreen.getPixels2D();
	    Pixel samePixel = null;
	    Pixel greenPixel = null;
	    int width = pixels[0].length;
	     for(int row = 0; row < greenPixels.length; row++)
	     {
	    	 for(int col = 0; col < greenPixels[0].length; col++)
	    	 {
	    		 samePixel = pixels[row][col];
	    		 greenPixel = greenPixels[row][col];
	    		 
	    		 if(greenPixel.getGreen() < 100)
	    		 {
	    			 samePixel.setColor(greenPixel.getColor());
	    		 }
	    		 else
	    		 {
	    			 
	    		 }
	    	 }
	     }
  }
  
  public void sepiaTone()
  {
	  Pixel[][] imageMatrix = this.getPixels2D();
	  for(int row = 0; row < imageMatrix.length; row++)
	  {
		  for(int col = 0; col < imageMatrix[0].length; col++)
		  {
			  //Pseudocode for filter
			  /**
			   * change each pixel to a tint of brown.
			   * min:(112, 66, 20) to max:(255, 255, 255)
			   * first algorithm:
			   * cut the red to fit between 112-255
			   * shift green to 1/2 of red
			   * shift blue to a third of green.
			   */
			  
			  //Java code:
			  Pixel sepiaPixel = imageMatrix[row][col];
			  int averageColor = (sepiaPixel.getRed() + sepiaPixel.getGreen() + sepiaPixel.getBlue() / 3);
			  if(averageColor < 80)
			  {
				  sepiaPixel.setGreen((int)(sepiaPixel.getRed() / 2));
				  sepiaPixel.setBlue(sepiaPixel.getGreen() / 3);
			  }
			  else
			  {
				  //255. 204. 51 wheatish color.
				  sepiaPixel.setRed((int)(sepiaPixel.getRed() * .9));
				  sepiaPixel.setGreen((int)(sepiaPixel.getRed() * .8));
				  sepiaPixel.setBlue((int)(sepiaPixel.getRed() * .4));
			  }
			  
		  }
	  }
  }
  
  public void mirrorGull()
  {
	  //needs to mirror pixels (235,235) to (320, 340) onto pixels (230, 370)
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int mirrorPoint = 360;
	    int width = pixels[0].length;
	     for(int row = 235; row < pixels.length; row++)
	     {
	    	 for(int col = 235; col < mirrorPoint; col++)
	    	 {
	    		 leftPixel = pixels[row][col];
	    		 rightPixel = pixels[row][mirrorPoint - col];
	    		 rightPixel.setColor(leftPixel.getColor());
	    	 }
	     }
	    
  }
  
  
  public void copy2(Picture fromPic, int startRow, int startCol, int endCol, int endRow)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = fromPic.getPixels2D();
	  
	  for(int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length && fromRow < endRow && toRow < endRow; fromRow++, toRow++)
	  {
		  for(int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toRow < toPixels[0].length && fromCol < endCol && toCol < endRow; fromCol++, toCol++)
		  {
			  	fromPixel = fromPixels[fromRow][fromCol];
		        toPixel = toPixels[toRow][toCol];
		        toPixel.setColor(fromPixel.getColor());
		  }
	  }
  }
  
  public void randomChange()
  {
	  Pixel[][] imageMatrix = this.getPixels2D();
	  for(int row = 0; row < imageMatrix.length; row += 2)
	  {
		  for(int col = 0; col < imageMatrix[0].length; col++)
		  {
			   int randomRed = (int)(Math.random() * 256);
			   int randomGreen = (int)(Math.random() * 256);
			   int randomBlue = (int)(Math.random() * 256);
			   imageMatrix[row][col].setRed(randomRed);
			   imageMatrix[row][col].setGreen(randomGreen);
			   imageMatrix[row][col].setBlue(randomBlue);
		  }
	  }
  }
  
  public void order()
  {
	  Pixel[][] imageMatrix = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = imageMatrix.length;
	  int width = imageMatrix[0].length;
	  for(int i = 0; i < 50; i++)
	  for(int row = 0; row < imageMatrix.length; row++)
	  {
		  for(int col = 0; col < imageMatrix[0].length; col++)
		  {
			  
			  topPixel = imageMatrix[row][col];
			  bottomPixel = imageMatrix[height - 1][width - 1];
			  int topColor = (topPixel.getRed() + topPixel.getGreen() + topPixel.getBlue());
			  int bottomColor = (bottomPixel.getRed() + bottomPixel.getGreen() + bottomPixel.getBlue());
			  if(bottomColor > topColor)
			  {
				  topPixel.setColor(bottomPixel.getColor());
			  }
		  }
	  }
  }
  
  public void mirrorArms()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int mirrorPoint = 200;
	    int width = pixels[0].length;
	     for(int row = 157; row < pixels.length; row++)
	     {
	    	 for(int col = 235; col < mirrorPoint; col++)
	    	 {
	    		 topPixel = pixels[row][col];
	    		 bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	    		 bottomPixel.setColor(topPixel.getColor());
	    	 }
	     }
	     mirrorPoint = 200;
	     for(int row = 160; row < mirrorPoint; row++)
	     {
	    	 for(int col = 100; col < pixels[0].length; col++)
	    	 {
	    		 topPixel = pixels[row][col];
	    		 bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	    		 bottomPixel.setColor(topPixel.getColor());
	    	 }
	     }
	     
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticleRightToLeft()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < width / 2; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  public void copy()
  {
	  
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  
	  for(int row = 0; row < height / 2; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - 1 - row][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
	  
  }
  
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topCornerPixel = null;
	  Pixel bottomCornerPixel = null;
	  int height = pixels.length;
	  int width = pixels[0].length;
	  
	  for(int col = 0; col < width; col++)
	  {
		  for(int row = 0; row < pixels.length; row++)
		  {
			  if(col > row && col < width && col < height)
			  {
				  topCornerPixel = pixels[row][col];
				  bottomCornerPixel = pixels[col][row];
				  topCornerPixel.setColor(bottomCornerPixel.getColor());
			  }
			 
		  }
	  }
	  
  }
  
  public void mirrorDiagonalDownward()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topCornerPixel = null;
	  Pixel bottomCornerPixel = null;
	  int height = pixels.length;
	  int width = pixels[0].length;
	  
	  for(int col = 0; col < width; col++)
	  {
		  for(int row = 0; row < pixels.length; row++)
		  {
			  if(col < row && row < height && height < width)
			  {
				  topCornerPixel = pixels[row][col];
				  bottomCornerPixel = pixels[col][row];
				  topCornerPixel.setColor(bottomCornerPixel.getColor());
			  }
			 
		  }
	  }
	  
  }
  
  public void mirrorbottomleftToRight()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topCornerPixel = null;
	  Pixel bottomCornerPixel = null;
	  int height = pixels.length;
	  int width = pixels[0].length;
	  
	  for(int row = 0; row < height/2; row++)
	  {
		  for(int col = 0; col < width/2; col++)
		  {
			  topCornerPixel = pixels[row][col];
			  bottomCornerPixel = pixels[height - 1 - row][width - 1 - col];
			  bottomCornerPixel.setColor(topCornerPixel.getColor());
		  }
	  }
	  
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
	
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
    	 
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist)
        {
        	leftPixel.setColor(Color.BLACK);
        }
        else
        {
        	leftPixel.setColor(Color.WHITE);
        }
          
      }
    }
    
  }
  
  
  public void edgeHorizontal(int edgeDist)
  {
	  Pixel topPixel;
	  Pixel bottomPixel;
	  Color bottomColor = null;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 0; row < pixels.length-1; row++)
	    {
	      for (int col = 0; col < pixels[0].length-1; col++)
	      {
	    	  
	    	  topPixel = pixels[row][col];
	          bottomPixel = pixels[row + 1][col];
	          bottomColor = bottomPixel.getColor();
	          if (topPixel.colorDistance(bottomColor) > edgeDist)
	          {
	          	topPixel.setColor(Color.BLACK);
	          }
	          else
	          {
	          	topPixel.setColor(Color.WHITE);
	          }
	    	  
	      }
	    }
	  
  }
  
  /**
   * Method to only keep blue.
   */
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(0);
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  public void keepOnlyRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue(0);
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  public void keepOnlyGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue(255 - pixelObj.getBlue());
			  pixelObj.setGreen(255 - pixelObj.getGreen());
			  pixelObj.setRed(255 - pixelObj.getRed());
		  }
	  }
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(pixelObj.getRed() + 75);
			  pixelObj.setBlue(pixelObj.getBlue() - 25);
			  pixelObj.setGreen(pixelObj.getBlue() - 25);
		  }
	  }
  }
  
  public void grayscale()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue((pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()) / 3);
			  pixelObj.setRed((pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()) / 3);
			  pixelObj.setGreen((pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()) / 3);
		  }
	  }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

public void createCollage2() 
{
	
	Picture fellowship = new Picture("fellowship.jpg");
	Picture bike = new Picture("bike.jpg");
	
	this.copy2(fellowship, 100, 0, 200, 200);
	this.copy2(bike, 0, 0, 100, 100);
	this.copy2(bike, 200, 0, 300, 300);
	this.copy2(fellowship, 300, 0, 600, 600);
	
}

public void turnPurple()
{
	 Pixel[][] pixels = this.getPixels2D();
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width; col++)
	      {
	    	 int red = pixels[row][col].getRed();
	    	 int blue = pixels[row][col].getBlue();
	    	 int green = pixels[row][col].getGreen();
	        if(red > 100 && blue > 100 && green > 100)
	        {
	        	pixels[row][col].setGreen(green - green);
	        }
	      }
	    } 
}
  
  
  
  
  
} // this } is the end of class Picture, put all new methods before this
