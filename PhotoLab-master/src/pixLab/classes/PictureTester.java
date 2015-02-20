package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
	public static void fiveAlgorithms()
	{
		Picture bike = new Picture("bike.jpg");
		bike.zeroBlue();
		bike.negate();
		bike.mirrorDiagonalDownward();
		bike.randomChange();
		bike.explore();
	}
	
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /**
   * Method to test keepOnlyBlue
   */
  public static void testKeepOnlyBlue()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.keepOnlyBlue();
	  beach.explore();
  }
  
  public static void testKeepOnlyRed()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.keepOnlyRed();
	  beach.explore();
  }
  
  public static void testKeepOnlyGreen()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.keepOnlyGreen();
	  beach.explore();
  }
  public static void testMirrorVerticleRightToLeft()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorVerticleRightToLeft();
	  caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture fellowship = new Picture("caterpillar.jpg");
	  fellowship.explore();
	  fellowship.mirrorHorizontal();
	  fellowship.explore();
  }
  
  public static void testNegate()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.negate();
	  beach.explore();
  }
  
  	public static void testGrayscale()
  	{
  		 Picture beach = new Picture("beach.jpg");
  		  beach.explore();
  		  beach.grayscale();
  		  beach.explore();
  	}
  
  	public static void testFixUnderwater()
  	{
  		Picture water = new Picture("water.jpg");
  		water.explore();
  		water.fixUnderwater();
  		water.explore();
  	}
  	
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    Picture swan2 = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
    swan2.edgeHorizontal(10);
    swan2.explore();
  }
  
  public static void testMirrorDiagonal()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.mirrorDiagonal();
	  beach.explore();
  }
  public static void testSepiaTone()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.sepiaTone();
	  beach.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture snow = new Picture("snowman.jpg");
	  snow.explore();
	  snow.mirrorArms();
	  snow.explore();
  }
  public static void testRandomChange()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.randomChange();
	  beach.explore();
  }
  public static void testCopy()
  {
	  Picture canvas = new Picture("640x480.jpg");
//	  Picture fellowship = new Picture("fellowship.jpg");
//	  fellowship.copy2(fellowship, 10, 25, 100, 100);
	  canvas.createCollage2();
	  canvas.mirrorVertical();
	  canvas.explore();
  }
  
  public static void testOrder()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.order();
	  beach.explore();
  }
  public static void changeWhiteToPurple()
  {
	  Picture flower = new Picture("whiteFlower.jpg");
	  flower.turnPurple();
	  flower.explore();
  }
  private static void testChromakey() 
  {
		
	  Picture beach = new Picture("beach.jpg");
	  Picture green = new Picture("GreenScreen2.jpg");
	  beach.chromakey(green);
	  beach.explore();
		
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
	//changeWhiteToPurple();
	//fiveAlgorithms();
	//testOrder(); 
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue(); //done
    //testKeepOnlyBlue(); //done
    //testKeepOnlyRed(); //done
    //testKeepOnlyGreen(); //done
    //testNegate(); //done
    //testGrayscale(); //done
    //testFixUnderwater(); //done?
    //testMirrorVertical(); //done
	//testMirrorVerticleRightToLeft(); //done
    //testMirrorTemple(); //done
	//testMirrorHorizontal();//done
    //testMirrorArms();//done
    //testMirrorGull(); //done
    //testMirrorDiagonal(); //done
    //testCollage();
    //testCopy(); //done
    //testEdgeDetection(); //done
    //testEdgeDetection2();
    testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testSepiaTone(); //done
	//testRandomChange(); //done
  }


}