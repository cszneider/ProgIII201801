<%
	String nro = request.getParameter( "nro" );

	long fatorial = 1;
	int nrCalc = -1;
	boolean calculouFatorial = false;
	boolean deuRuim = false;
	String msgErro = null;

	if( nro != null ) {

		try {
			nrCalc = Integer.parseInt( nro );
			
			while( nrCalc > 1 ) {
				fatorial = fatorial * nrCalc--;
			}
			
			calculouFatorial = true;
		} catch( Exception e ) {
			deuRuim = true;
			msgErro = "N�o sei calcular o fatorial de '" + nro + "'";
		}
	}
%><html>
	<head>
	    <title>Calculo do Fatorial</title>
	</head>
	<body>
		<h1>C�lculo do Fatorial</h1>
		<hr />

		<form method="post">
			N�mero: <input type="text" name="nro" />
			<input type="submit" value="Calcular" />
		</form>
<%
	if( calculouFatorial ) {
%>  <br /><br />
	O Fatorial de <%=nro%> � igual a <%=fatorial%> 
<% } %>

<%
	if( deuRuim ) {
%>  <br /><br />
	<span style="color: red;"><%=msgErro%></span> 
<% } %>

	</body>
</html>











