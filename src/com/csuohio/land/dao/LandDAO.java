package com.csuohio.land.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csuohio.land.models.Land;
import com.csuohio.land.models.UserInput;
import com.csuohio.util.DBConnection;

public class LandDAO {

	public ArrayList<Land>getLandData(UserInput userInput){
		ResultSet rs=null;
		Connection conn = DBConnection.getConnection();
		ArrayList<Land> landResults = new ArrayList<Land>();
		String query="";
		if(userInput.isSquareFeet()) {
			//query = "select parcel_id,sales_amou,total_squa,water,gas,electricit from properties where sales_amou between ? and ? AND total_squa <="+userInput.getSquareFeet()+" AND water=? AND gas=? AND electricit=? AND sitecat1 =?";
			query = "select parcel_id,sales_amou,total_squa,water,gas,electricit,par_addr_a,parcel_typ from properties where sales_amou between ? and ? AND total_squa <="+userInput.getSquareFeet()+" AND total_squa!=0  AND sitecat1 =? and  rownum <= 100";		

		}
		else if(userInput.isAcre()) {
			//query = "select parcel_id,sales_amou,total_acre,water,gas,electricit from properties where sales_amou between ? and ? AND total_acre <="+userInput.getAcre()+" AND water=? AND gas=? AND electricit=? AND sitecat1 =?";
			query = "select parcel_id,sales_amou,total_acre,water,gas,electricit,par_addr_a,parcel_typ from properties where sales_amou between ? and ? AND total_acre <="+userInput.getAcre()+" AND total_acre!=0 AND sitecat1 =? and  rownum <= 100";		

		}
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setLong(1, userInput.getLowerRange());
			stmt.setLong(2, userInput.getHigherRange());
		//	stmt.setString(3, userInput.getEmenities().getWater());
		//	stmt.setString(4, userInput.getEmenities().getGas());
		//	stmt.setString(5, userInput.getEmenities().getElectricity());
			stmt.setString(3, userInput.getLandCategory());
			System.out.println(query);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Land data  =new Land();
				data.setParcelId(rs.getString(1));
				data.setSalesAmount(rs.getLong(2));
				data.setTotalLand(rs.getLong(3));
				data.setWater(rs.getString(4));
				data.setGas(rs.getString(5));
				data.setElectricity(rs.getString(6)); 
				data.setParcelAddr(rs.getString(7));
				data.setParcelType(rs.getString(8));
				landResults.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(landResults.size());
		return landResults;
		
	}
	
	public  ArrayList<String> getCitys() {
		ResultSet rs=null;
		Connection conn = DBConnection.getConnection();
		conn = DBConnection.getConnection();
		ArrayList<String>  cityList = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select distinct par_city from properties");
			rs = stmt.executeQuery();
			cityList = new ArrayList<String>();
			while (rs.next()) {
				cityList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityList;
	}
	
	public  ArrayList<String> getSiteCategories(){
		    ArrayList<String> siteCat = null;
		    Connection conn = DBConnection.getConnection();
			try {
				PreparedStatement stmt = conn.prepareStatement("select distinct sitecat1 from properties");
				ResultSet rs = stmt.executeQuery();
				siteCat = new ArrayList<String>();
				while (rs.next()) {
					siteCat.add(rs.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return siteCat;
		}
	
}
