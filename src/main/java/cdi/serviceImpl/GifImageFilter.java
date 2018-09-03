package cdi.serviceImpl;

import cdi.service.ImageFilter;
import cdi.service.ImageType;
import cdi.service.Mode;

@ImageType(desiredMode = Mode.GIF)
public class GifImageFilter implements ImageFilter {

	@Override
	public String openFile(String fileName) {

		return "Opening GIF file " + fileName;

	}

	@Override
	public String editFile(String fileName) {

		return "Editing GIF file " + fileName;

	}

	@Override
	public String writeFile(String fileName) {

		return "Writing GIF file " + fileName;

	}

	@Override
	public String saveFile(String fileName) {

		return "Saving GIF file " + fileName;

	}
}
