package com.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import com.constants.Constants;
import com.utils.*;

public class MyStreamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			preview(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		  //FSDataInputStream in = clip.getVideo();
		  long endTime = System.currentTimeMillis();
		  System.out.println("Run Time： "+(endTime - startTime)+" ms");

		  final long fileLen = clip.getSize();

		  String range=req.getHeader("Range");
		  resp.setHeader("Content-type","mp4");

		  OutputStream out=resp.getOutputStream();

		  String filename = ID;
		  resp.setHeader("Content-Disposition", "attachment; filename="+filename);
		  resp.setContentType("application/octet-stream");
		  resp.setContentLength((int)fileLen);

		  out.write(clip.getVideo());
		  out.flush();

		  out.close();




	  }
}

	