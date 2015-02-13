package pix.view;

import javax.swing.JFrame;

import pix.controller.FauxToeShopController;

public class FauxToeShopFrame extends JFrame
{
	
	private FauxToeShopController baseController;
	private FauxToeShopPanel basePanel;
	
	public FauxToeShopFrame(FauxToeShopController baseController)
	{
		this.baseController = baseController;
		basePanel = new FauxToeShopPanel(baseController);
		setupFrame();
	}

	private void setupFrame() 
	{
		
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setContentPane(basePanel);
		this.setVisible(true);
		
	}
	
}
