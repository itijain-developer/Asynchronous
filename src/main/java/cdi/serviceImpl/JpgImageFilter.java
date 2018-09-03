package cdi.serviceImpl;

import javax.inject.Named;

import cdi.service.ImageFilter;

@Named("jpg")
public class JpgImageFilter implements ImageFilter {

	@Override
	public String openFile(String fileName) {

		return "Opening JPG file " + fileName;

	}

	@Override
	public String editFile(String fileName) {

		return "Editing JPG file " + fileName;

	}

	@Override
	public String writeFile(String fileName) {

		return "Writing JPG file " + fileName;

	}

	@Override
	public String saveFile(String fileName) {

		return "Saving JPG file " + fileName;

	}

}
