package hr.com.hrdev;

import hr.com.hrdev.controllers.HomeController;

public class BatalhaNaval {

	private BatalhaNaval(){}
	
	private void run(String[] args){
		try {
			new HomeController();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BatalhaNaval().run(args);
	}
}
