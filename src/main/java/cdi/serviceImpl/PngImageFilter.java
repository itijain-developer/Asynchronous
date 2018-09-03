package cdi.serviceImpl;

import cdi.service.ImageFilter;
import cdi.service.ImageType;
import cdi.service.Mode;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

// s@ApplicationScoped
@ImageType(desiredMode = Mode.PNG)
public class PngImageFilter implements ImageFilter {

	@Override
	public String openFile(String fileName) {

		return "Opening PNG file " + fileName;

	}

	@Override
	public String editFile(String fileName) {

		return "Editing PNG file " + fileName;

	}

	@Override
	public String writeFile(String fileName) {

		return "Writing PNG file " + fileName;

	}

	@Override
	public String saveFile(String fileName) {

		return "Saving PNG file " + fileName;

	}

}
