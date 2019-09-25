package logicControllers;

//import java.util.ArrayList;

public class ValueValidater {
	
	public  boolean emailValidater(String val) {	
		if (!val.matches("(.*)@(.*)@(.*)") && val.matches("(.*)@(.*).(.*)")  && val.matches("(.*)[.](.*)")){
			return(true);
		}
		else {
			return false;
			}
		}

}
