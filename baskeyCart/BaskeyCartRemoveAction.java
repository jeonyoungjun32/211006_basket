package baskeyCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BaskeyCartRemoveService;
import vo.ActionForward;

public class BaskeyCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 장바구니에 있는걸 삭제
		
		//baskeyCartList.jsp에서 쓸라고 remove 씀 
		String [] nameArray = request.getParameterValues("remove");  
		
		BaskeyCartRemoveService baskeyCartRemoveService = new BaskeyCartRemoveService(); 
		
		baskeyCartRemoveService.basketRemove(request, nameArray);
		
		return new ActionForward("baskeyCartList.bk", true);
	}

}
