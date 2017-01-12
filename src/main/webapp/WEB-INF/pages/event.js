/**
 * JS for the different AJAX calls
 */


	$(".addEvent").click(function() {
		var eventname = $("#eventname").val();
		var description = $("#description").val();
		var goal = $("#goal").val();
		var enddate = $("#enddate").val();
		var obj = JSON.stringify({
			"eventname" : eventname,
			"description" : description,
			"goal" : goal,
			"enddate" : enddate
		});
		$.ajax({
			method : "POST",
			url : "http://localhost:9001/CharityFund/home/insert",
			data : obj
		});
		getEvent();
	});

	function getEvent() {
		$(".table tbody tr").remove();
		$.ajax({
			method : "POST",
			url : "http://localhost:9001/CharityFund/home/getAll",
			success : function(resp) {
				var iterable = resp.events;
				$.each(iterable, function(i, item) {
					var event = "<tr>" + "<td>" + item.eventname + "</td>"
							+ "<td>" + item.description + "</td>" + "<td>"
							+ item.goal + "</td>" + "<td>" + item.enddate
							+ "</td>" + "</tr>";
					$(".table tbody").append(event);
				});
			}
		});
	}