package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Basket;

public class BaskeyCartListService {

	public ArrayList<Basket> getCartList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		ArrayList<Basket> baskeyCartList = (ArrayList<Basket>) session.getAttribute("baskeyCartList"); // 이새 끼  null값 나와 근데 이 baskeyCartList 새끼 는 어디서 온거냐??
		
		
		System.out.println("cartListService= null이 나온다라   "+baskeyCartList);
		
		return baskeyCartList;
		
	}
}
