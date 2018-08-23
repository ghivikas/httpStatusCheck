package com.http.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.http.bean.StatusBean;
import com.http.dao.Credential;
import com.http.dao.GetUrlInfo;
import com.http.logging.LogHelper;
import com.http.status.HttpResultTest;
import com.http.status.HttpStatusResult;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Httppdf {

	public void SavePdf() throws Exception
	{
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		GetUrlInfo gui=new GetUrlInfo();
		
		 HttpStatusResult hsr=new HttpStatusResult();
		 HttpResultTest rst=new HttpResultTest();
		 Credential cr=new Credential();
		 Httppdf hp=new Httppdf();
		 StatusBean[] sre;;
		 cr.getCred();
		 //sre=hsr.HttpResponseResult();
		 List<StatusBean> lst=new ArrayList<StatusBean>();
		
		
		for(int i=0;i<gui.getStatus().size();i++)
		{
		lst.addAll(hsr.HttpResponseResult(gui.getStatus().get(i).getURL()));
			
		/*    System.out.println(  lst.get(i).getUrl() );
	        System.out.println(lst.get(i).getStatus());*/
		  
		   
		}
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c:\\Multivu_Downstream_Response.pdf"));
			
			LogHelper.debug(Httppdf.this.getClass(), "PDF file had been created");
			Paragraph title1 = new Paragraph("Sanity test", 

					   FontFactory.getFont(FontFactory.HELVETICA, 
					   
					   18, Font.BOLDITALIC, new CMYKColor(0, 255, 255,17)));
					   
					Chapter chapter1 = new Chapter(title1, 1);
					      
					chapter1.setNumberDepth(0);
			
			Paragraph title11 = new Paragraph(" ", 

				       FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, 
				   
				       new CMYKColor(0, 255, 255,17)));
				   
				Section section1 = chapter1.addSection(title11);
			document.open();
			PdfPTable t = new PdfPTable(3);

		      t.setSpacingBefore(25);
		      
		      t.setSpacingAfter(25);
		      
		      PdfPCell c1 = new PdfPCell(new Phrase("URL"));  
		      
		      t.addCell(c1);
		      
		      PdfPCell c2 = new PdfPCell(new Phrase("App"));
		      
		      t.addCell(c2);
		      
		      PdfPCell c3 = new PdfPCell(new Phrase("Status"));
		      
		      t.addCell(c3);
		      for(int i=0;i<gui.getStatus().size();i++)
		      {
		      t.addCell(lst.get(i).getUrl());
		      
		      t.addCell(gui.getStatus().get(i).getApp());
		      
		      t.addCell(lst.get(i).getStatus());
		      }
		      section1.add(t);
			
		      document.add(chapter1);

		      document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
				
				
	}
	
}
