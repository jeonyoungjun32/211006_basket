<%@page import="vo.Product"%>
<%@page import="baskeyCart.BaskeyCartListAction"%>
<%@page import="vo.Basket"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Basket> CartList = (ArrayList<Basket>) session.getAttribute("cartList");
	//BaskeyCartListAction totalMoney = (BaskeyCartListAction)session.getAttribute("totalMoney"); //이게 아닌가?
	String money12 = request.getParameter("totalmoney");
%>

<script type="text/javascript">
function checkAll(theForm) {
	if(CartList.get(i).getQty != 1){
		location.href="basketCartQtyDown.bk?eencodingName="+encodeURIComponent(name);
	}
}
</script> >



<%@include file="header.jsp"%>


<h2 id="basket">장바구니 목록</h2>

<%
	if (CartList.isEmpty()) {
%>
상품이 없습니다
<%
	} else {
%>
<%
	for (int i = 0; i < CartList.size(); i++) {
%>
<table id="basketTable">
	<tr>
		<td>
			<input type="checkbox" name="allCheck" onclick="checkAll(this.form)">d
		</td>

		<td>상품 이름 : <%=CartList.get(i).getBasket_name()%>&nbsp;
		</td>
		<td>가격 : <%=CartList.get(i).getBasket_price()%> &nbsp;
		</td>
		<td>수량 : <%=CartList.get(i).getBasket_count()%>&nbsp;
		</td>
		<%
			int money = CartList.get(i).getBasket_price() * CartList.get(i).getQty();
		%>
		<td>총 금역 : <%=money%>&nbsp;
		</td>
		<td><%=CartList.get(i).getQty()%>개</td>

		<td>
			<a href="basketCartQtyUp.bk?encodingName=<%=CartList.get(i).getEncodingName()%>">
				<img src="img/up.jpg" id="upImg"> </a> <br> <%=CartList.get(i).getQty()%>
				<br> 
				<a href="basketCartQtyDown.bk?encodingName=<%=CartList.get(i).getEncodingName()%>&qty=<%=CartList.get(i).getQty()%>">
				<img src="img/down.jpg" id="downImg"> 
			</a>
		</td>


		<td>구매</td>
		<td>&nbsp;
			<input type="button" value="삭제" formaction="basketCartRemove.bk" >
		 </td>
		
		<td><a href="iceCakeList.bk"> 쇼핑 계속하기</a></td>
		


		<%-- null값 나온다 --%>
		<%-- <td><%=Product.get(i).getName() %> </td> --%>
	</tr>
	<%
		}
	%>

	<%-- <td><%=test.getName()%></td>
	<td><%=test.getPI_date()%></td>
	<td><%=test.getPrice()%></td> --%>
</table>

<%
	}
%>






