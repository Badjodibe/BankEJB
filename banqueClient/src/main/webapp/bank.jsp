<%@ 
	page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "formRecherche">
		<form action="Controller">
			<table>
				<tr>
					<td>Code:</td>
					<td>
						<input type= "number" name = "code" value = "$(code)" required = "required">
						
					</td>
					<td>$(errCode}</td>
					<td><input type = "submit" name = "action" value = "Consulter"></td>
					<td><input type = "submit" name = "action" value = "Tous les Comptes"></td>
					
				</tr>
			</table>
		</form>
	</div>
	<c:if test="${(comte!= null) || mtMsgErr!= null}">
	
		<div id = "Compte">
			<table>
				<tr>
					<td>Code:</td>
					<td>${compte.code}</td>
					<td>Sold:</td>
					<td>${compte.solde}</td>
					<td>Date creation:</td>
					<td>${compte.dateCreation}</td>
				</tr>
			</table>
			
		</div>
		<div id = "formOperation">
			<form>
				<table>
				<tr> 
					<td><input type = "hidden" name = "code" value = ${code }></td>
					<td><input type = "number" name = "montant" value = ${montant } required = "required"></td>
					<td>mtMsgErr</td>
					<td><input type = "submit" name = "action" value = "Verser"></td>
					<td><input type = "submit" name = "action" value = "Retirer"></td>
				</tr>
			</table>
			</form>
		</div>
	</c:if>
	<c:if test="${comptes!= null }">
		<div id = "listeComptes">
			<table border = "1" width = "80%">
				<tr>
					<th>Code</th>
					<th>Sold</th>
					<th>Date Creation</th>
				</tr>
				<c:forEach items = "${comptes }" var = "cp" >
					<tr>
						<td> ${cp.code }</td>
						<td> ${cp.solde }</td>
						<td> ${cp.dateCreation }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<div id = "errors">
		${exception }
	</div>
</body>
</html>