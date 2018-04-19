<%
	String catetoOposto = request.getParameter("catetoOposto");
	String catetoAdjacente = request.getParameter("catetoAdjacente");
	String hipotenusa = request.getParameter("hipotenusa");
	
	boolean calculado = false;
	boolean erroDados = false;
	boolean trianguloSim = false;
	boolean displayResposta = false;
	double resultado = 1;

	if( request.getParameter("catetoOposto") != null ){
		
			if(catetoOposto != "" && catetoAdjacente!= "" && hipotenusa == ""){
				double nrCatetoOposto = Integer.parseInt( catetoOposto );
				double nrCatetoAdjacente = Integer.parseInt( catetoAdjacente );
				resultado = Math.sqrt( (nrCatetoOposto*nrCatetoOposto) + (nrCatetoAdjacente*nrCatetoAdjacente) );
		
				calculado = true;
				
			}
			
			else if(catetoOposto != "" && catetoAdjacente == "" && hipotenusa != ""){
				double nrCatetoOposto = Integer.parseInt( catetoOposto );
				double nrHipotenusa = Integer.parseInt( hipotenusa );
				resultado = Math.sqrt( nrHipotenusa*nrHipotenusa - (nrCatetoOposto*nrCatetoOposto));
		
				calculado = true;
				
			}
			
			else if(catetoOposto == "" && catetoAdjacente != "" && hipotenusa != ""){
				double nrCatetoAdjacente = Integer.parseInt( catetoAdjacente );
				double nrHipotenusa = Integer.parseInt( hipotenusa );
				resultado = Math.sqrt(nrHipotenusa*nrHipotenusa - (nrCatetoAdjacente*nrCatetoAdjacente));
		
				calculado = true;
				
			}
			
			else if(catetoOposto != "" && catetoAdjacente != "" && hipotenusa != ""){
				double nrCatetoOposto = Integer.parseInt( catetoOposto );
				double nrCatetoAdjacente = Integer.parseInt( catetoAdjacente );
				double nrHipotenusa = Integer.parseInt( hipotenusa );
				
				double delta = (nrCatetoAdjacente*nrCatetoAdjacente) + (nrCatetoOposto*nrCatetoOposto);
				
				if(delta == ( nrHipotenusa * nrHipotenusa )){
					trianguloSim = true;
				}
				displayResposta = true;
				
				
			}
			
			else {
				erroDados = true;
				
			}
		
	}
%><html>
	<head>
		<title>Cálculo lados triângulo</title>
	</head>

	<body>
		<h1>Cálculo dos lados de um triângulo</h2>
		<h3>Teorema de Pitágoras</h4>
		
		<form method="post" id="recebeDados">
			<input placeholder="Cateto Oposto" type="text" name="catetoOposto" /></br>
			<input placeholder="Cateto Adjacente" type="text" name="catetoAdjacente" /></br>
			<input placeholder="Hipotenusa" type="text" name="hipotenusa" /></br>
			<input type="submit" value="calcular" id="calcular" name="submit"/>
		</form>	
		
		
		<% if(calculado){%>
		<h2 id="correto">Resposta => <%=resultado %></h2>
		
		<% }%>
		
		<% if(erroDados){%>
		<h2>Erro nos dados inseridos</h2>
		<p>Para utilizar o sistema você dece indicar dois valores para receber o resultado do terceiro, exemplo:
			Informar cateto Adjacente e Hipotenusa para calcular o cateto oposto</br>
			Outra maneira é indicar os três valores e verificar se eles constituem um triangulo</p>
		<% }%>
		
		
		<% if(displayResposta){
				if(trianguloSim){
		%>
		<h2 id="correto">CORRETO! Os valores informados constituem um triângulo</h2>
		
		<%}
				else{
				%>
				<h2 id="incorreto">INCORRETO! Os valores informados NÃO constituem um triângulo</h2>
				<%	}}%>
		
	</body>
	
	
	<style>
		body{
			max-width: 500px;
			margin: auto;
		}
		input{
			margin-bottom: 10px;
		}
		
		h1{
			color: #4286f4;
		}
		
		h3{
			text-align: center;
		}
		#recebeDados{
			margin-top: 40px;
		}
		
		#calcular{
			margin-top: 6px; 
		}
		h2{
			color: #f93636;
		}
		#correto{
		color: #28a745;
		}
		
		#incorreto{
		color: #f93636;
		}
	</style>

</html>