<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Event"%>
<%@page import="cali.eventkalender.model.Person"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<main role="main" class="container-fluid mt-2 mb-2">
	<div class="card invitePerson">
			<div class="card-body">
				<input class="form-control" id="myInput" type="text"
					placeholder="S�k..">
				<table class="table table-hover" id="myTable">
					<thead>
						<tr>
							<th>F�rnamn</th>
							<th>Efternamn</th>
						</tr>
					</thead>
					<tbody>
				    	<%
							List<Person> persons = (List<Person>) request.getAttribute("persons");
							for (Person p : persons) {
								out.print("<tr>");
								out.print("<td>" + p.getFirstName() + "</td>");
								out.print("<td>" + p.getLastName() + "</td>");
								out.print("</tr>");
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card inviteEvent">
			<div class="card-body">
				<input class="form-control" id="myInput" type="text"
					placeholder="S�k..">
				<table class="table table-hover" id="myTable">
					<thead>
						<tr>
							<th>Namn</th>
							<th>Nation</th>
							<th>Starttid</th>
							<th>Sluttid</th>
							<th>Inbjudna</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Event> events = (List<Event>) request.getAttribute("events");
							for (Event e : events) {
								out.print("<tr>");
								out.print("<td>" + e.getName() + "</td>");
								out.print("<td>" + e.getNation().getName() + "</td>");
								out.print("<td>" + e.getStartTimeFormatted() + "</td>");
								out.print("<td>" + e.getEndTimeFormatted() + "</td>");
								out.print("<td>" + e.getPersons().size() + "</td>");
								out.print("</tr>");
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>