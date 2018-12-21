package com.csuohio.land.recommendation.service;

import java.util.ArrayList;

import com.csuohio.land.dao.LandDAO;
import com.csuohio.land.models.Land;
import com.csuohio.land.models.UserInput;


public class LandRecommendationService {

	/**
	 * 
	 * @param userInput
	 * @return
	 */
	public ArrayList<Land> getUserRecommendations(UserInput userInput){
		LandDAO landDAO = new LandDAO();
		ArrayList<Land> landRecommendations = landDAO.getLandData(userInput);
		ArrayList<Land>  topRecommendations = new ArrayList<Land>();
		
		if (landRecommendations.size() != 0) {
			System.out.println("Calculate consine similarity");
			ArrayList<Land> similarityList = cosineSimilarity(userInput, landRecommendations);
			System.out.println("size of similarityList"+similarityList);
			if (similarityList.size() != 0) {
				System.out.println("List one");
				Land first = getTopRecommendation(similarityList);
				topRecommendations.add(first);
				similarityList.remove(first);
			}
			if (similarityList.size() != 0) {
				System.out.println("list 3");
				Land second = getTopRecommendation(similarityList);
				topRecommendations.add(second);
				similarityList.remove(second);
			}
			if (similarityList.size() != 0) {
				System.out.println("size3");
				Land third = getTopRecommendation(similarityList);
				topRecommendations.add(third);
			}

			for (Land obj : topRecommendations) {
				System.out.println(obj.getSimilarity());
			}

		}
		return topRecommendations;
	}
		
	
	public Land getTopRecommendation(ArrayList<Land> similarityData) {
		float high =0;
	    int index = 0;
			 high = similarityData.get(0).getSimilarity();
			 for(int j=1;j<similarityData.size();j++) {
				 if(high<similarityData.get(j).getSimilarity()) {
					 high = similarityData.get(j).getSimilarity();
					 index = j;
				 }
			 }
			
		return similarityData.get(index);
	}
	
	/**
	 * This method takes userInput and DB result set to compute cosine similarity and return
	 * @param userInput
	 * @param availableData
	 * @return ArrayList<Land>
	 */
	public ArrayList<Land> cosineSimilarity(UserInput userInput,
			ArrayList<Land> availableData) {
		ArrayList<Land> similarityList = new ArrayList<Land>();
		for(int i=0;i<availableData.size();i++){
			float numerator=0;
			float denominator=0;
			float temp1=0;
			float temp2=0;
			float similarity = 0;
			int userPrice = (userInput.getLowerRange()+userInput.getHigherRange()/2);
			numerator = userPrice * availableData.get(i).getSalesAmount();
			if(userInput.isSquareFeet()) {
				numerator =numerator+ userInput.getSquareFeet()*availableData.get(i).getTotalLand();
				temp1 = temp1+ userInput.getSquareFeet() *userInput.getSquareFeet();
			}else if(userInput.isAcre()) {
				numerator = numerator + userInput.getAcre() * availableData.get(i).getTotalLand();
				temp1 = temp1+userInput.getAcre()*userInput.getAcre();
			}
			temp1 = temp1 + userPrice*userPrice;
			temp2 = temp2 + availableData.get(i).getSalesAmount() *availableData.get(i).getSalesAmount() +availableData.get(i).getTotalLand()*availableData.get(i).getTotalLand(); 
			denominator=(float) (Math.sqrt(temp1)*Math.sqrt(temp2));
			if(denominator!=0){
				similarity = numerator/denominator;
			}
			else{
				similarity = 0;
			}
			Land land = availableData.get(i);
			land.setSimilarity(similarity);
			similarityList.add(land);
		}
		return similarityList;
	}
	
}
