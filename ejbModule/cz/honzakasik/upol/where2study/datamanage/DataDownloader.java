package cz.honzakasik.upol.where2study.datamanage;

import java.io.IOException;

import javax.ejb.Local;
import javax.xml.bind.JAXBException;

@Local
public interface DataDownloader {
	
	/**
	 * Download latest data from STAG and persist them to database.
	 * @throws IOException thrown when the response from STAG weren't HTTP_OK (200)
	 * @throws JAXBException when there is a problem with parsing data from STAG responses
	 * @throws IllegalStateException 
	 */
	public void downloadData() throws IOException, JAXBException, IllegalStateException;

}
