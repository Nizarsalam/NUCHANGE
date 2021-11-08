import java.util.*;

import org.json.simple.*;

public class Main {

  public static void main(String[] args) {

	Random rand = new Random();

	boolean flag = true;

	ArrayList <HashMap<String,String>> urldb = new ArrayList <HashMap<String,String>> ();

    	Scanner sc= new Scanner(System.in);

	while(flag){

   		System.out.println("Enter Command :");  

    		String command = sc.nextLine();

    		if(command.equalsIgnoreCase("storeurl")){

			HashMap<String,String> urls = new HashMap<String,String>();

			System.out.println("Enter URL to Store: ");  

			String link = sc.nextLine();

			String usk = generateRandom();

			urls.put("ShortKey", usk);

			urls.put("url", link);
		
			urls.put("usage", "0");

			urldb.add(urls);
		}

		if(command.equalsIgnoreCase("get")){

			System.out.println("Enter URL to get: ");  

			String link = sc.nextLine();

			for (int i = 0; i < urldb.size(); i++) {

				if(urldb.get(i).get("url").equalsIgnoreCase(link)){
				
					System.out.println(urldb.get(i).get("ShortKey"));

					int temp = Integer.parseInt(urldb.get(i).get("usage"));

					temp += 1;

					urldb.get(i).put("usage",String.valueOf(temp));

					break;
	
				}
        	}

		}

		if(command.equalsIgnoreCase("count")){

			System.out.print("Enter URL to get count: ");  

			String link = sc.nextLine();

			for (int i = 0; i < urldb.size(); i++) {

				if(urldb.get(i).get("url").equalsIgnoreCase(link)){
				
					System.out.println(urldb.get(i).get("usage"));

					break;
	
				}
        	}		

		}

		if(command.equalsIgnoreCase("list")){

			String jsonStr = JSONArray.toJSONString(urldb);

			System.out.println(jsonStr);
			
		}

		if(command.equalsIgnoreCase("exit")){
		
			flag = false;

		}

	}

}

private static String generateRandom() {

    Random rand=new Random();

    String aToZ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    StringBuilder res=new StringBuilder();

    for (int i = 0; i < 5; i++) {

       int randIndex=rand.nextInt(aToZ.length());

       res.append(aToZ.charAt(randIndex));

    }

    return res.toString();

}

}