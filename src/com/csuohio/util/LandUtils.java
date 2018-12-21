package com.csuohio.util;


import java.util.ArrayList;

import com.csuohio.land.dao.LandDAO;

public class LandUtils {
	public static ArrayList<String>  cityList =null;
	public static ArrayList<String> siteCat = null;
	public static ArrayList<String> getCitys() {

		if (cityList != null) {
			return cityList;

		} else {
			LandDAO landDAO = new LandDAO();
			cityList = landDAO.getCitys();
			return cityList;
		}
	}
	public static ArrayList<String> getSiteCategories(){
		if (siteCat != null) {
			return siteCat;

		} else {
			LandDAO landDAO = new LandDAO();
			siteCat = landDAO.getSiteCategories();
			return siteCat;
		}
	}
	
}
