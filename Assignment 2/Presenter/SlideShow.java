import java.io.File;

import javax.swing.JComponent;

public class SlideShow extends Presenter {

	private PictureComponent pictureComponent;
	private File images[];
	private String texts[];
	private int currentImageIndex = 0;

	public SlideShow(File[] imageFiles, String[] texts) {
		// read and remember (create instance variables)
		// images from the indicated files
		// and also remember texts in an instance field
		super();
		this.texts = texts;
		this.images = imageFiles;
		repaintImageAndText();
	}
	
	@Override
	public JComponent createCenterComponent() {
		// create picture Component
		// you may want to create a class for that
		// (class PictureComponent extends JComponent { ... } )
		pictureComponent = new PictureComponent();
		return pictureComponent;
		
	}

	public void repaintImageAndText(){
		pictureComponent.setImage(images[currentImageIndex]);
		showText(texts[currentImageIndex]);
	}

	@Override
	public void eastButtonPressed() {
		currentImageIndex = (currentImageIndex + 1) % images.length;
		repaintImageAndText();
	}
	
	
	@Override
	public void westButtonPressed() {
		// same as for east button, but for previous picture
		currentImageIndex = Math.floorMod(currentImageIndex - 1,  images.length);
		repaintImageAndText();
	}

	@Override
	public void southButtonPressed() {
	}

	@Override
	public void northButtonPressed() {
	}
	
	public static void main(String[] args) {
		String imagesDir = "images";
		File images[] = { new File(imagesDir, "average_user.png"), new File(imagesDir, "giga_chad.jpg"), new File(imagesDir, "cli_creator.png") };
		String texts[] = { "Average JS UI framework users", "Java swing enjoyers", "CLI creator/user" };
		SlideShow sh = new SlideShow(images, texts);
	}

}
