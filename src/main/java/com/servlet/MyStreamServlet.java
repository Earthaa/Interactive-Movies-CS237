package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.io.IOUtils;
import com.utils.*;

public class MyStreamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			preview(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void preview(HttpServletRequest req,HttpServletResponse resp) throws Exception
	  {

		  Server server = Server.getServer();

		  String ID=req.getParameter("ID");
		  if(ID==null)
			  return;

		  long startTime=System.currentTimeMillis();
		  VideoClip clip = server.getClip(ID);
		  byte[] byteStream = clip.getVideo();
		  long endTime = System.currentTimeMillis();
		  System.out.println("Run Time： "+(endTime - startTime)+" ms");

		  final long fileLen = clip.getSize();

		  String filename = ID;

		  String range=req.getHeader("Range");
		  resp.setHeader("Content-type","video/mp4");
		  InputStream in = new ByteArrayInputStream(byteStream);
		  OutputStream out=resp.getOutputStream();
		  if(range==null)
		  {
			  resp.setHeader("Content-Disposition", "attachment; filename="+filename);
			  resp.setContentType("application/octet-stream");
			  resp.setContentLength((int)fileLen);
			  IOUtils.copyBytes(in, out, fileLen, false);
		  }
		  else
		  {
			  long start=Integer.valueOf(range.substring(range.indexOf("=")+1, range.indexOf("-")));
			  long count=fileLen-start;
			  long end;
			  if(range.endsWith("-"))
				  end=fileLen-1;
			  else
				  end=Integer.valueOf(range.substring(range.indexOf("-")+1));
			  String ContentRange="bytes "+String.valueOf(start)+"-"+end+"/"+String.valueOf(fileLen);
			  resp.setStatus(206);
			  resp.setContentType("video/mpeg4");
			  resp.setHeader("Content-Range",ContentRange);
			  in.skip(start);
			  try{
				  IOUtils.copyBytes(in, out, count, false);
			  }
			  catch(Exception e)
			  {
				  throw e;
			  }
		  }
		  out.close();
		  out = null;
	  }
}

	