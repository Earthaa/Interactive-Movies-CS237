/********************************
 *	프로젝트 : MediaPlayer
 *	패키지   : net.balusc.webapp
 *	작성일   : 2018. 7. 18.
 *	작성자   : KYJ
 *******************************/
package net.balusc.webapp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLResult;

/**
 * @author KYJ
 *
 */
public class XmlUtil {

	public static String transform(String xslt, String dataXml) throws Exception {
		return transform(xslt.getBytes(), dataXml.getBytes());
	}


	public static String transform(byte[] xslt, byte[] dataXml) throws Exception {
		TransformerFactory fac = TransformerFactory.newInstance();
		StreamSource xlstSource = new StreamSource(new ByteArrayInputStream(xslt));
		StreamSource dataSource = new StreamSource(new ByteArrayInputStream(dataXml));
		return transform(xlstSource, dataSource);
	}

	public static String transform(StreamSource xlstSource, StreamSource dataSource) throws Exception {
		TransformerFactory fac = TransformerFactory.newInstance();
		Transformer newTransformer = fac.newTransformer(xlstSource);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setTrimText(false);
		newTransformer.transform(dataSource, new XMLResult(out, format));
		String string = out.toString();
		return string;
	}

}
