package com.company.bettings_parser;

import com.company.betting_description.Bet;
import com.company.betting_description.BetOffice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MarathonBet {

	private BetOffice betOffice;

	public BetOffice getBetOffice() {
		return betOffice;
	}

	public MarathonBet() {
		String json = "{\n"
				+ "  \"name_office\": \"MarathonBet\",\n"
				+ "  \"name_sport\": \"Футбол\",\n"
				+ "  \"bets\": [\n"
				+ "    {\n"
				+ "      \"command_one\": \"Германия\",\n"
				+ "      \"coef_one\": 1.48,\n"
				+ "      \"command_two\": \"Швейцфрия\",\n"
				+ "      \"coef_two\": 7.8\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Украина\",\n"
				+ "      \"coef_one\": 9.8,\n"
				+ "      \"command_two\": \"Испания\",\n"
				+ "      \"coef_two\": 1.39\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Азейбайджан\",\n"
				+ "      \"coef_one\": 2.42,\n"
				+ "      \"command_two\": \"Кипр\",\n"
				+ "      \"coef_two\": 3.44\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Черногория\",\n"
				+ "      \"coef_one\": 1.92,\n"
				+ "      \"command_two\": \"Люксембург\",\n"
				+ "      \"coef_two\": 4.25\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Латвия\",\n"
				+ "      \"coef_one\": 1.7,\n"
				+ "      \"command_two\": \"Мальта\",\n"
				+ "      \"coef_two\": 5.6\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Лихтенштейн\",\n"
				+ "      \"coef_one\": 1.163,\n"
				+ "      \"command_two\": \"Сан-Марино\",\n"
				+ "      \"coef_two\": 24.0\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Фарерские острова\",\n"
				+ "      \"coef_one\": 1.4,\n"
				+ "      \"command_two\": \"Андорра\",\n"
				+ "      \"coef_two\": 9.9\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Боливия\",\n"
				+ "      \"coef_one\": 4.95,\n"
				+ "      \"command_two\": \"Аргентина\",\n"
				+ "      \"coef_two\": 1.77\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Эквадор\",\n"
				+ "      \"coef_one\": 2.41,\n"
				+ "      \"command_two\": \"Уругвай\",\n"
				+ "      \"coef_two\": 2.95\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Венесуэла\",\n"
				+ "      \"coef_one\": 2.47,\n"
				+ "      \"command_two\": \"Парагвай\",\n"
				+ "      \"coef_two\": 2.98\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Перу\",\n"
				+ "      \"coef_one\": 8.8,\n"
				+ "      \"command_two\": \"Бразилия\",\n"
				+ "      \"coef_two\": 1.43\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"command_one\": \"Чили\",\n"
				+ "      \"coef_one\": 2.98,\n"
				+ "      \"command_two\": \"Колумбия\",\n"
				+ "      \"coef_two\": 2.49\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(json);
			String officeName = jsonObject.get("name_office").toString();
			JSONArray arrayBets = (JSONArray) jsonObject.get("bets");
			parseBettingArray(officeName, arrayBets);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void parseBettingArray(String officeName, JSONArray array) {
		betOffice = new BetOffice(officeName);
		for (Object bet :
				array) {
			JSONObject betObj = (JSONObject) bet;
			String first_name = betObj.get("command_one").toString();
			String first_coef = betObj.get("coef_one").toString();
			String second_name = betObj.get("command_two").toString();
			String second_coef = betObj.get("coef_two").toString();
			Bet parsedBet = new Bet(first_name, second_name,
					first_coef, second_coef, betOffice);
			betOffice.addBet(parsedBet.getBetName(), parsedBet);
		}
	}
}