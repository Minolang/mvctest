package mvc;

public class ActionFactory {

	public Action getAction(String command) {
		Action result = null;
		
		 switch(command) {
		 
		 case"login":
			 result = new LoginCheck();
			 break;
		 case"insertmember":
			 result = new InsertMember();
			 break;
		 }
		
		
		return result;
	}

}
