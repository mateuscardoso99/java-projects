<%@page import="dao.UserDao"%>  
<jsp:useBean id="u" class="bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  <!--seta a variavel u com os valores recebidos no caso o id enviado de viewusers -->
<%  
    UserDao.delete(u);  
    response.sendRedirect("viewusers.jsp");  
%>  