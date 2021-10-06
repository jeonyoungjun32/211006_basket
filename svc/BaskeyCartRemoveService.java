package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Basket;

public class BaskeyCartRemoveService {

	public void basketRemove(HttpServletRequest request, String[] nameArray) {
		
		HttpSession session = request.getSession();
		ArrayList<Basket> cartList = (ArrayList<Basket>) session.getAttribute("cartList");
		
		for(int i=0;i<nameArray.length;i++) {
			for(int j=0; j<cartList.size();j++) {
				if(nameArray[i].equals(cartList.get(j).getBasket_name())) {
					cartList.remove(cartList.get(j));
					break;
				}
			}
		}
				
	}
}
