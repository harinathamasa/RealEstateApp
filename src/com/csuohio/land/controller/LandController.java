package com.csuohio.land.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csuohio.land.models.Amenities;
import com.csuohio.land.models.Land;
import com.csuohio.land.models.UserInput;
import com.csuohio.land.recommendation.service.LandRecommendationService;
import com.csuohio.util.LandUtils;

@Controller
public class LandController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Model model) {
		ArrayList<String> cities = LandUtils.getCitys();
		ArrayList<String> siteCat = LandUtils.getSiteCategories();
		System.out.println("Size..." + cities.size() + "size of cat.." + siteCat.size());
		model.addAttribute("cities", cities);
		model.addAttribute("categories", siteCat);
		return "welcome";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String fetchRecommendations(HttpServletRequest req, HttpServletResponse response, Model model) {

		System.out.println("Inside post..");
		String city = req.getParameter("city") != null ? req.getParameter("city").trim() : "";
		String category = req.getParameter("category") != null ? req.getParameter("category").trim() : "";
		String landSizeType = req.getParameter("landcat");
		String priceRange = req.getParameter("gridRadios");
		UserInput userInput = new UserInput();
		userInput.setCity(city);
		userInput.setLandCategory(category);
		if (landSizeType.equalsIgnoreCase("squa")) {
			userInput.setSquareFeet(true);
			userInput.setSquareFeet(
					Integer.parseInt(req.getParameter("squareFeet") != null ? req.getParameter("squareFeet") : "0"));
		}
		if (landSizeType.equalsIgnoreCase("acre")) {
			userInput.setAcre(true);
			userInput.setAcre(Integer.parseInt(req.getParameter("acres") != null ? req.getParameter("acres") : "0"));
		}
		String pRange[] = priceRange.split("-");
		userInput.setLowerRange(pRange[0] != null ? Integer.parseInt(pRange[0].trim()) : 0);
		userInput.setHigherRange(pRange[1] != null ? Integer.parseInt(pRange[1].trim()) : 100000);
		String gas = req.getParameter("gas") != null ? "Y" : "N";
		String electricity = req.getParameter("electricity") != null ? "Y" : "N";
		String water = "N";
		boolean isWaterPrivate = req.getParameter("private") != null ? true : false;
		boolean isWaterMun = req.getParameter("municipality") != null ? true : false;
		if (isWaterPrivate) {
			water = "PVT";
		} else if (isWaterMun) {
			water = "MUN";
		}
		Amenities emenities = new Amenities();
		emenities.setElectricity(electricity);
		emenities.setGas(gas);
		emenities.setWater(water);
		userInput.setEmenities(emenities);
		LandRecommendationService landService = new LandRecommendationService();
		ArrayList<Land> recommendations = landService.getUserRecommendations(userInput);
		model.addAttribute("recommendations", recommendations);
		return "recommend";
	}
}
