<%@page import="br.feevale.Fatorial" %>
<%
	Fatorial fat = new Fatorial( request.getParameter( "nro") );
%><html>
	<head>
	    <title>Calculo do Fatorial</title>
	</head>
	<body>
		<h1>Cálculo do Fatorial</h1>
		<hr />

		<form method="post">
			Número: <input type="text" name="nro" />
			<input type="submit" value="Calcular" />
		</form>
<%
	if( fat.isCalculouFatorial() ) {
%>  <br /><br />
	O Fatorial de <%=fat.getNro()%> é igual a <%=fat.getFatorial()%> 
<% } %>

<%
	if( fat.isDeuRuim() ) {
%>  <br /><br />
	<span style="color: red;"><%=fat.getMsgErro()%></span> 
<% } %>

	</body>
</html>











