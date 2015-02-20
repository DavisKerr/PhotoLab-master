package pix.view;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import pix.controller.FauxToeShopController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;

public class FauxToeShopPanel extends JPanel
{
	
	private FauxToeShopController baseController;
	private SpringLayout baseLayout;
	private JComboBox filterBox;
	private JComboBox pictureBox;
	private String[] filterArray;
	private String[] pictureArray;
	private Picture basePicture;
	private JScrollPane imagePane;
	
	public FauxToeShopPanel(FauxToeShopController baseController) 
	{
		this.baseController = baseController;
		
		filterBox = new JComboBox();
		pictureBox = new JComboBox();
		baseLayout = new SpringLayout();
		basePicture = new Picture("beach.jpg");
		imagePane = new JScrollPane();
		
		
		
		setupPicture();
		setupComboBox();
		setupLayout();
		setupListeners();
		
		setupPanel();
	}

	private void setupPicture()
	{
		
		BufferedImage bufferedPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(bufferedPic);
		imagePane.setViewportView(picDisplay);
		
	}

	private void setupComboBox() 
	{
		
		String[] filterArray =
			{
				"ZeroBlue", 
			    "KeepOnlyBlue", 
			    "KeepOnlyRed", 
			    "KeepOnlyGreen", 
			    "Negate", 
			    "Grayscale", 
			    "FixUnderwater", 
			    "MirrorVertical", 
				"MirrorVerticleRightToLeft", 
			    "MirrorTemple", 
				"MirrorHorizontal",
			    "MirrorArms",
			    "MirrorGull", 
			    "MirrorDiagonal", 
			    "Collage",
			    "Copy", 
			    "EdgeDetection", 
			    "Chromakey",
			    "EncodeAndDecode",
			    "GetCountRedOverValue",
			    "SetRedToHalfValueInTopHalf",
			    "ClearBlueOverValue",
			    "GetAverageForColumn",
				"SepiaTone", 
				"RandomChange" 	
			};
		
		String[] pictureArray = 
			{
				"beach.jpg", "seagull.jpg", "koala.jpg"
			};
		
		this.filterArray = filterArray;
		this.pictureArray = pictureArray;
		
		filterBox.setModel(new DefaultComboBoxModel(this.filterArray));
		pictureBox.setModel(new DefaultComboBoxModel(this.pictureArray));
		
	}

	private void setupPanel() 
	{
		
		this.setBackground(Color.ORANGE);
		this.setLayout(baseLayout);
		this.setSize(1000,300);
		this.add(filterBox);
		this.add(pictureBox);
		this.add(imagePane);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, pictureBox, 0, SpringLayout.NORTH, filterBox);
		baseLayout.putConstraint(SpringLayout.WEST, pictureBox, 99, SpringLayout.EAST, filterBox);
		baseLayout.putConstraint(SpringLayout.NORTH, filterBox, 0, SpringLayout.NORTH, imagePane);
		baseLayout.putConstraint(SpringLayout.WEST, filterBox, 8, SpringLayout.EAST, imagePane);
	}
	
	private void loadPicture()
	{
		basePicture = new Picture(pictureArray[pictureBox.getSelectedIndex()]);
		setupPicture();
	}
	
	private void setupListeners()
	{
		pictureBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent currentImageEvent)
			{
				loadPicture();
			}
		});
		
		filterBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent currentEvent)
			{
				if(filterBox.getSelectedIndex() == 0)
				{
					loadPicture();
					basePicture.zeroBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 1)
				{
					loadPicture();
					basePicture.keepOnlyBlue();
					setupPicture();
				}
				else if(filterBox.getSelectedIndex() == 2)
				{
					loadPicture();
					basePicture.keepOnlyRed();
					setupPicture();
				}
				
			}
		});
	}
	
	
	
	
	
}
