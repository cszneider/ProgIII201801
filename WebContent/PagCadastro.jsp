<%@page import="br.feevale.classes.SetDados"%>
<%@page import="br.feevale.classes.GetDados"%>


<html>
	<head>
		<title>Página de cadastro</title>
	</head>
	<body>
		<h1>Cadastro</h1>
		<form method="post">
			<p>Email: <input type="email" name="email" placeholder="example@example.com" required></p>
			<p>Nome: <input type="text" name="nome" placeholder="Fulano" required></p>
			<p>Senha: <input type="password" name="pass" placeholder="******" required></p>
			<p>Data de nascimento: <input type="text" name="datNasc" placeholder="dd/mm/aaaa" required></p>
			<input type="submit" value="Cadastrar">
			<%
			try {
				SetDados addUser = new SetDados();
				addUser.setDados(request.getParameter("email"), request.getParameter("nome"), request.getParameter("pass"), request.getParameter("datNasc"));
				addUser.addNewUser();
			} catch(Exception e) {
				e.printStackTrace();
			}
			%>
		</form>
			<%
			
			int id = 0;
			String email = null, nome = null, dtIncl = null, dtNasc = null, pass = null;
			
			GetDados getUser = new GetDados();
			getUser.getIdNumb();
			int i = getUser.getLastId();
			int j;
			
			for(j=1; j<=i; j++) {
				try {
					getUser.setLastId(j);
					getUser.getAUser();
					email = getUser.getDadoEmail();
					nome = getUser.getDadoNome();
					id = getUser.getDadoId();
					dtIncl = getUser.getDadoIncl();
					dtNasc = getUser.getDadoNasc();
					pass = getUser.getDadoPass();
					getUser.setLastId(j);
				} catch(Exception e) {
					e.printStackTrace();
				} 
			%>
		<table border = "1">
			<tr>
				<td><%=id%></td>
				<td><%=nome%></td>
            	<td><%=email%></td>
            	<td><%=pass%></td>
            	<td><%=dtIncl%></td>
         		<td><%=dtNasc%></td>
         	</tr>
		</table>
		<%}%>
	</body>
</html>