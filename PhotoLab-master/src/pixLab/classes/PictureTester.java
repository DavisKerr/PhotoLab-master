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
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
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
    //testMirrorTemple(); //done
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection(); //done
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}