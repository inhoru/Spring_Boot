package gg.lolco.controller;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gg.lolco.model.service.SampleService;

@Controller
public class SampleController {
	private final SampleService service;

	public SampleController(SampleService service) {
		this.service = service;
	}

	@GetMapping("/sampleAll")
	public String selectAll(Model model) {
		model.addAttribute("sample", service.selectAll());
		return "sample/sampleList";
	}

	@GetMapping("/playerinsert")
	public String playerinsert() {
		final String stockList = "https://lol.fandom.com/wiki/Special:RunQuery/TournamentStatistics?TS%5Bpreload%5D=TournamentByPlayerRole&TS%5Brole%5D=Support&TS%5Btournament%5D=LCK%2F2023+Season%2FSpring+Season&_run=";
		Connection conn = Jsoup.connect(stockList);

		try {
			Document document = conn.get();
			Elements stockTableBody = document.select(".wikitable tr .spstats-team");

			for (Element element : stockTableBody) {
				String team=element.select("a").attr("title");
				String name = element.siblingElements().get(0).text();
				double attack =  Double.parseDouble(element.siblingElements().get(5).text());
				double defense = Double.parseDouble(element.siblingElements().get(6).text()) + 0.01;  // Add a small constant to avoid divide-by-zero
				double assistant = Double.parseDouble(element.siblingElements().get(7).text());
				double survival = Double.parseDouble(element.siblingElements().get(8).text());
				double growth = Double.parseDouble(element.siblingElements().get(11).text());
				

				PlayerStats playerAttack = new PlayerStats(0, 1.5, 0, 100); 
				PlayerStats playerDefense = new PlayerStats(3.5, 1.1, 0, 100); 
				PlayerStats playerAssistant = new PlayerStats(0, 10.9, 0, 100); 
				PlayerStats playersSurvival = new PlayerStats(0, 7.7, 0, 100); 
				PlayerStats playersGrowth = new PlayerStats(6, 9, 0, 100); 
				double scaledValueAttack = playerAttack.scaleValue(attack);
				double scaledValueDefense = playerDefense.scaleValue(defense);
				double scaledValueAssistant = playerAssistant.scaleValue(assistant);
				double scaledValueSurvival = playersSurvival.scaleValue(survival);
				double scaledValueGrowth = playersGrowth.scaleValue(growth);	
				System.out.println(name);
				System.out.println(team);
				String season="LCK 2023 spring";
				System.out.println(season);
				double a =(Math.round(scaledValueAttack)+6);
				double d =(Math.round(scaledValueDefense)+6);
				double s =(Math.round(scaledValueAssistant)+6);
				double u =(Math.round(scaledValueSurvival)+6);
				double g =(Math.round(scaledValueGrowth)+6);
				String position="SUP";
				System.out.println(a);
				System.out.println(d);
				System.out.println(s);
				System.out.println(u);
				System.out.println(g);
				System.out.println(position);
				Map<String,Object> param =Map.of("name",name,"season",season,"attack",a,"defense",d,"assistant",s,"survival",u,"growth",g,"position",position,"team",team);
				int playerInsertTop=service.playerInsertTop(param);
			
			}
			

		} catch (IOException ignored) {
			
		}
		
		
	
		return "template";
	}

}
