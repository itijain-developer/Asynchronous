package cdi.service;


public interface ImageFilter {
		
	String openFile(String fileName);

    String editFile(String fileName);

    String writeFile(String fileName);

    String saveFile(String fileName);

}
