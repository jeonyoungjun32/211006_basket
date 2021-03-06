package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baskeyCart.BaskeyCartAddAction;
import baskeyCart.BaskeyCartListAction;
import baskeyCart.BaskeyCartQtyDownAction;
import baskeyCart.BaskeyCartQtyUpAction;
import baskeyCart.BaskeyCartRemoveAction;
import login.action.Action;
import login.action.BeverageIngredientListAction;
import login.action.BeverageListAction;
import login.action.CoffeeIngredientListAction;
import login.action.CoffeeListAction;
import login.action.DessertIngredientListAction;
import login.action.DessertListAction;
import login.action.IceCakeIngredientListAction;
import login.action.IceCakeListAction;
import login.action.IcecreamIngredientListAction;
import login.action.IcecreamListAction;
import login.action.LogOutProAction;
import login.action.LoginFindIDProAction;
import login.action.LoginFindPWProAction;
import login.action.LoginIDFindPWReviseProAction;
import login.action.LoginIdCheckProAction;
import login.action.LoginJoinProAction;
import login.action.LoginProAction;
import login.action.OrderPageAction;
import login.action.OrderPageSelectAction;
import login.action.OrderPageSelectDetailAction;
import login.action.OrderResultProAction;
import vo.ActionForward;

/**
 * Servlet implementation class BKFrontController
 */
@WebServlet("*.bk")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String RequestURI = request.getRequestURI();
		String conextPath = request.getContextPath();
		String command = RequestURI.substring(conextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		System.out.println(command);
		if(command.equals("/login.bk")) {//????????? ??????
			forward = new ActionForward();
			forward.setPath("/login/login.jsp");
		} else if(command.equals("/loginFindIDForm.bk")) {//????????? ?????? ???
			forward = new ActionForward();
			forward.setPath("/login/loginFindIDForm.jsp");
		} else if (command.equals("/loginFindIDPro.bk")) {//????????? ?????? ??????
			action = new LoginFindIDProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/loginIDFindPWReviseForm.bk")) {//????????? ?????? ??? ???????????? ?????? ???
			forward = new ActionForward();
			forward.setPath("/login/loginIDFindPWReviseForm.jsp");
		} else if (command.equals("/loginIDFindPWRevisePro.bk")) {//????????? ?????? ??? ???????????? ?????? ??????
			action = new LoginIDFindPWReviseProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/loginFindPWForm.bk")) {//???????????? ?????? ????????? ?????? ???
			forward = new ActionForward();
			forward.setPath("/login/loginFindPWForm.jsp");
		} else if (command.equals("/loginFindPWPro.bk")) {//???????????? ?????? ????????? ?????? ??????
			action = new LoginFindPWProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/loginIDFindPWReviseForm2.bk")) {//???????????? ?????? ??? ???????????? ?????? ???
			forward = new ActionForward();
			forward.setPath("/login/loginIDFindPWReviseForm2.jsp");
		} else if(command.equals("/loginReviseSuccess.bk")) {//???????????? ?????? ??????
			forward = new ActionForward();
			forward.setPath("/login/loginReviseSuccess.jsp");
		} else if (command.equals("/loginIdCheck.bk")) {//id ???????????? ???
			forward = new ActionForward();
			forward.setPath("/login/joinCheckForm.jsp");
		} else if (command.equals("/idCheckFail.bk")) {//id ???????????? ?????? ?????????
			forward = new ActionForward();
			forward.setPath("/login/idCheckFailForm.jsp");
		} else if (command.equals("/idCheckSuccess.bk")) {//id ???????????? ?????? ?????????
			forward = new ActionForward();
			forward.setPath("/login/idCheckSuccessForm.jsp");
		} else if (command.equals("/loginIdCheckPro.bk")) {//id ???????????? ??????
			action = new LoginIdCheckProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/loginJoinForm.bk")) {//?????? ?????? ???
			forward = new ActionForward();
			forward.setPath("/login/joinForm.jsp");
		} else if (command.equals("/loginjoinPro.bk")) {//?????? ?????? ??????
			action = new LoginJoinProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/joinSuccess.bk")) {//?????? ?????? ?????? ???
			forward = new ActionForward();
			forward.setPath("/login/joinSuccess.jsp");
		} else if (command.equals("/loginPro.bk")) {//????????? ??????
			action = new LoginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/logOutPro.bk")) {//???????????? ??????
			action = new LogOutProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/index.bk")) {//??? ?????? ????????? ??????
			forward = new ActionForward();
			forward.setPath("index.jsp");
		} 
		/*?????? ??????*/
		else if (command.equals("/icecreamList.bk")) {//??????????????? ????????? ??? + ??????
			action = new IcecreamListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/iceCakeList.bk")) {//?????????????????? ????????? ??? + ??????
			action = new IceCakeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/beverageList.bk")) {//?????? ????????? ??? + ??????
			action = new BeverageListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/coffeeList.bk")) {//?????? ????????? ??? + ??????
			action = new CoffeeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/dessertList.bk")) {//????????? ????????? ??? + ??????
			action = new DessertListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*????????? ??????*/
		else if (command.equals("/icecreamIngredientList.bk")) {//??????????????? ????????? ??? + ??????
			action = new IcecreamIngredientListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/iceCakeIngredientList.bk")) {//?????????????????? ????????? ??? + ??????
			action = new IceCakeIngredientListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/beverageIngredientList.bk")) {//?????? ????????? ??? + ??????
			action = new BeverageIngredientListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/coffeeIngredientList.bk")) {//?????? ????????? ??? + ??????
			action = new CoffeeIngredientListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/dessertIngredientList.bk")) {//????????? ????????? ??? + ??????
			action = new DessertIngredientListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/orderPage.bk")) {//?????? ????????? ??? ??????
			action = new OrderPageAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/orderPageSelect.bk")) {//?????? ????????? ????????? ?????? ??????
			action = new OrderPageSelectAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/orderPageSelectDetail.bk")) {//??????????????? ????????? ?????? ?????? ?????? ??????
			action = new OrderPageSelectDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/orderResult.bk")) {//??????????????? ????????? ?????? ?????? ?????? ???
			forward = new ActionForward();
			forward.setPath("/orderResult.jsp");
		} else if (command.equals("/orderResultPro.bk")) {//??????????????? ????????? ?????? ?????? ?????? ??????
			action = new OrderResultProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		/***********************************************************************************************/
		  else if (command.equals("/cartAdd.bk")) {//???????????? ??????
			action = new BaskeyCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
			else if (command.equals("/baskeyCartList.bk")) {//???????????? ?????????
				action = new BaskeyCartListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equals("/basketCartQtyUp.bk")) {//'????????????????????????    ???????????? ?????? ?????? ??????  ????????????' ????????????						
				action = new BaskeyCartQtyUpAction();		 
				try {
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equals("/basketCartQtyDown.bk")) {//'????????????????????????    ???????????? ?????? ?????? ??????  ????????????' ????????????						
				action = new BaskeyCartQtyDownAction();		 
				try {
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equals("/basketCartRemove.bk")) {//'????????????????????????    ???????????? ??????  ????????????' ????????????						
				action = new BaskeyCartRemoveAction();		 
				try {
					forward = action.execute(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
			
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
}
