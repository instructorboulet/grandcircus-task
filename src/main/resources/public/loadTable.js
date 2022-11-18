"use strict";

function draw_table(resp) {
	
	var table = $('#table-list');
	
	if (resp.length > 0) {
		// If returned json data is not empty		
		// looping the returned data
		Object.keys(resp).map(k => {
			// creating new table row element
			var tr = $('<tr>')
			// first column data						
			tr.append('<td><button data-taskId="$taskId" class="edit">Edit</button>'.replace('$taskId', resp[k].taskId)  );			
			// second column data
			tr.append('<td>' + resp[k].description + '</td>')
			// third column data
			tr.append('<td>' + resp[k].user.userName + '</td>')
			// fourth column data
			tr.append('<td>' + resp[k].priority.description + '</td>')
			// fifth column data
			tr.append('<td>' + resp[k].status.description + '</td>')
			// sixth column data
			tr.append('<td>' + resp[k].startDate + '</td>')			
			// seventh column data
			tr.append('<td>' + resp[k].endDate + '</td>')
			
			// seventh column data			
			let percentage = resp[k].complete + "%";
			let img = '<td><img id="t1" data-percentage="$percentage" class="percentage" src="/black.jpg" />&nbsp;$complete</td> ';
			
			img = img.replace("$percentage", percentage)
			         .replace("$complete", percentage) ;
						
			tr.append(img);			
			
			table.find('tbody').append(tr)
		});
		
		updatePercentage();
		
	} else {
		// If returned json data is empty
		var tr = $('<tr>')
		tr.append('<th class="py-1 px-2 text-center">No data to display</th>')
		table.find('tbody').append(tr)
	}
	$('#loader').addClass('d-none')
	
	
	$(".edit").click( function() {		
		let taskId = $(this).attr("data-taskid");
		$("#taskId").val(taskId);		
		$( "#frmEditTask" ).submit();				
	});	
}

function updatePercentage () {
	var perecentages = document.querySelectorAll(".percentage");
	var list = [...perecentages];
	
	list.forEach( e => {
		var dataPercentage = e.dataset.percentage;
		//e.style.width=dataPercentage;
		let nPercentage = parseInt(dataPercentage.replace("%",""));
		let size = 4 * nPercentage / 100;
		e.style.width= size + "in";
		e.style.height = "45px";
	})
}

function load_data(searchParameter) {
	
	var table = $('#table-list');	
	table.find('tbody').html('');

	$.ajax({
		// JSON FILE URL		
		url: '/api/tasks',
		type:"GET",
		data: searchParameter,
		xdata: {
			searchMode: "a",
			comparison: "gt",
			value: "100"
		},
		// Type of Return Data
		dataType: 'json',
		// Error Function
		error: err => {
			console.log(err)
			alert("An error occured")
			$('#loader').addClass('d-none')
		},
		// Succes Function
		success: draw_table
	});
}

$(function() {
	
	// Hide loader on document ready
	$('#loader').addClass('d-none')
	load_data()
	
	// Reload Button Function
	$('#reload_data').click(function() {
		// refreshing the table data
		load_data()
	});
	
})