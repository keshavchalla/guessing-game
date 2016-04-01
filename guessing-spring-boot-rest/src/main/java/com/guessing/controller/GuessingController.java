package com.guessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guessing.model.GuessModel;


@RestController
public class GuessingController {

	@Autowired
	private GuessModel guessModel;
	
	@RequestMapping(value = "/usrResponse", method = RequestMethod.GET)
	public @ResponseBody GuessModel guessNumberMessage(@RequestParam("guess")String guess,
			@RequestParam("minNo")Integer minNo,@RequestParam("maxNo")Integer maxNo,ModelMap model) {
		int guessNumber = (minNo + maxNo + 1)/2;
		if(guess.equals("none")){
			guessModel.setStatus("first");
			guessModel.setMessage("Is your number "+guessNumber);
			guessModel.setGuessNo(guessNumber);
			guessModel.setLowerLimit(minNo);
			guessModel.setUpperLimit(maxNo);
			return guessModel;
		}
		if (guess.equalsIgnoreCase("Higher")) {
			guessModel.setLowerLimit(minNo);
			guessModel.setUpperLimit(maxNo);
			guessModel.setStatus("higher");
			guessModel.setGuessNo(guessNumber);
			guessModel.setMessage("Is your number "+guessNumber);
		} else if (guess.equalsIgnoreCase("Lower")) {
			guessModel.setUpperLimit(maxNo);
			guessModel.setLowerLimit(minNo);
			guessModel.setStatus("lower");
			guessModel.setGuessNo(guessNumber);
			guessModel.setMessage("Is your number "+guessNumber);
		} else if(guess.equalsIgnoreCase("Yes")){
			guessModel.setStatus("done");
			guessModel.setMessage("The computer guessed your number at last");
		}

		return guessModel;
	}
	
	
}
