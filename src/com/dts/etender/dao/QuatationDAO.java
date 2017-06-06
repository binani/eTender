/**
 * 
 */
package com.dts.etender.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.etender.model.Department;
import com.dts.etender.model.Quatation;
import com.dts.etender.model.TenderPost;

/**
 * @author JAVAPROJECTS
 *
 */
public class QuatationDAO extends AbstractDataAccessObject {
	public Connection con;
	private boolean flag=false;
//insert department
	public boolean postQuatation(Quatation  quatation)
	{
		int quatationID=getSequenceID("QuatationPost","QuatatonID");
		PreparedStatement pstmt=null;
		try
		{System.out.println("in quatationpost");
		    con=getConnection();
		    pstmt=con.prepareStatement("insert into QuatationPost values(?,?,?,?,?,?,?,?)");
		    pstmt.setInt(1,quatationID);
		    pstmt.setInt(2,quatation.getTenderID());
		    pstmt.setString(3,quatation.getSuppierName());
		    pstmt.setString(4,quatation.getDDNo());
		    pstmt.setString(5,DateWrapper.parseDate(new Date()));		    
		    pstmt.setInt(6,quatation.getQuantity());
		    pstmt.setString(7,quatation.getSpesification());		    
		    pstmt.setDouble(8,quatation.getPricebid());
		  
		    int i=pstmt.executeUpdate();
		    if(i>0)
		    	flag=true;
		}
		catch(Exception e)
		{   e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return flag;
	}
	
	public CoreHash getQuatations()
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Quatation quatation=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from QuatationPost order by QuatatonID desc");
            	 while(rs.next())
                 {
              	   quatation=new Quatation();
              	   quatation.setQuatatonID(rs.getInt(1));
              	   quatation.setTenderID(rs.getInt(2));
              	   quatation.setSuppierName(rs.getString(3));
              	   quatation.setDDNo(rs.getString(4));
              	   quatation.setBidPostDate(DateWrapper.parseDate(rs.getDate(5)));
              	   quatation.setQuantity(rs.getInt(6));
              	   quatation.setSpesification(rs.getString(7));
              	   quatation.setPricebid(rs.getDouble(8));
              	  
              	   aCoreHash.put(new Integer(sno),quatation);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}
//awarding
	public CoreHash getAwardings()
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Quatation quatation=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT   DISTINCT  TP.TenderName, I.itemName,QP.SuppierName,PD.postingDate,PD.receiptdate,PD.priceBid FROM  TENDERAWARDING  TA ,PURCHASEDETAILS  PD ,QUATATIONPOST  QP ,TENDERPOST  TP ,ITEM  I,Suppliers S WHERE(TA.tenderID=PD.tenderID) AND(QP.TenderID=PD.tenderID) AND(QP.TenderID=TP.TenderID) AND(PD.tenderID=TP.TenderID) AND(PD.ItemID=I.ItemID) AND(I.ItemID=TP.ITEMID) AND(QP.QuatatonID=TA.QuatatonID) AND(TA.CompanyName=QP.SuppierName) AND(QP.SuppierName=PD.CompanyName) AND(PD.CompanyName=S.CompanyName) AND(QP.pricebid=PD.priceBid) AND(PD.postingDate=TP.PosingDate) AND(PD.receiptdate IS NOT NULL)");
            	 while(rs.next())
                 {
              	   quatation=new Quatation();
              	   quatation.setTenderName(rs.getString(1));
              	   quatation.setItemName(rs.getString(2));
              	   quatation.setSuppierName(rs.getString(3));
              	   quatation.setBidPostDate(DateWrapper.parseDate(rs.getDate(4)));
              	   quatation.setReceiptdate(DateWrapper.parseDate(rs.getDate(5)));
              	   quatation.setPricebid(rs.getDouble(6));
              	   aCoreHash.put(new Integer(sno),quatation);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}


	
	public CoreHash getQuatations(int tenderID)
	{
	
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Quatation quatation=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT * from QuatationPost where TenderID="+tenderID+" order by QuatatonID desc");
            	 while(rs.next())
                 {
              	   quatation=new Quatation();
              	   quatation.setQuatatonID(rs.getInt(1));
              	   quatation.setTenderID(rs.getInt(2));
              	   quatation.setSuppierName(rs.getString(3));
              	   quatation.setDDNo(rs.getString(4));
              	   quatation.setBidPostDate(DateWrapper.parseDate(rs.getDate(5)));
              	   quatation.setQuantity(rs.getInt(6));
              	   quatation.setSpesification(rs.getString(7));
              	   quatation.setPricebid(rs.getDouble(8));
              	  
              	   aCoreHash.put(new Integer(sno),quatation);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}
//awarding
	public boolean awardingTender(Quatation  quatation)
	{
	
		CallableStatement cstmt=null;
		try
		{System.out.println("in quatationpost");
		    con=getConnection();
		    cstmt=con.prepareCall("call ADDD(?)");
		    cstmt.setInt(1,quatation.getQuatatonID());
		    
		    int i=cstmt.executeUpdate();
		    if(i>0)
		    	flag=true;
		}
		catch(Exception e)
		{   e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return flag;
	}
	
}

