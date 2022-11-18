"use strict";

$(function() {	
	
	let searchParameter = { searchMode : 1 , value : "*", sortBy : 1 };

	$(".sortImg").click(function() {		
		let source = $(this).attr('src');
		console.log({source, date: new Date()});
		
		$('.sortImg').removeClass('selected');
		$('.sortImg').addClass('unSelected');	
		
		if (source == '/noArrow.png'){
			$(this).attr('src', '/uppArrow.png');			
		}
		else if (source == '/uppArrow.png'){
			$(this).attr('src', '/downArrow.png');			
		}	
		else if (source == '/downArrow.png'){
			$(this).attr('src', '/uppArrow.png');			
		}			
		
		$(this).addClass('selected')
		$(this).removeClass('unSelected');
		
		let sortBy = $(this).attr('data-sortorder');
		searchParameter.sortBy = sortBy;
		searchParameter.date = new Date();			
		
		load_data(searchParameter);		
		console.log(populateSelect)		
		
		$(this).attr('data-sortorder', parseInt(sortBy) * -1);
		
		$( ".unSelected" ).each(function( index ) {
			let sortBy = $(this).attr('data-sortorder');
			sortBy = Math.abs(parseInt(sortBy));
			
			$(this).attr('data-sortorder', sortBy);
			
			$( this ).attr('src','/noArrow.png' );
			
  			console.log( index + ": " + $( this ).text() );
		});
			
	});	
	

	$("#search").click(function() {
		let searchMode = $("#searchMode").val();
		let value = $("#value").val();
		searchParameter.searchMode = searchMode;
		searchParameter.value = value;
		console.log(searchParameter);
		load_data(searchParameter);
	});


	$("#selectValues").attr("hidden", "hidden");
	$("#value").attr("type", "hidden");



    /*
    	Java Search Enumerator
    	ALL(1), TASK(2), USER(3), PRIORITY(4), STATUS(5), END_DATE(6), END_DATE_GREATER_THAN(7), END_DATE_LESS_THAN(8),
		COMPLETE(9), COMPLETE_GREATER_THAN(10), COMPLETE_LESS_THAN(11);
	
	*/

	$("#searchMode").change(function() {
		let value = parseInt($(this).val());
				
		$("#value").attr("type", "hidden");
		
		console.log({ searchMode: value, date: new Date() })
		$("#selectValues").attr("hidden", "hidden");

		if (value == 1) {
			$("#selectValues").attr("hidden", "hidden");
			$("#value").attr("type", "hidden");
			$("#value").val("");
		}
		
		else if (value == 2) {
			$("#value").val("");
			$("#value").attr("type", "text");
			$("#value").val("");			
		}		
		
		else if (value == 3) {
			$("#selectValues").removeAttr("hidden")
			$('#priority').prop('disabled', true);
			$('#status').prop('disabled', true);
			$('#user').prop('disabled', false);
			$('#selectValues').val("N1");
			$("#value").attr("type", "hidden");
		}			

		else if (value == 4) {
			$("#selectValues").removeAttr("hidden")
			$('#priority').prop('disabled', false);
			$('#status').prop('disabled', true);
			$('#user').prop('disabled', true);
			$('#selectValues').val("N1");
		}
		else if (value == 5) {
			$("#selectValues").removeAttr("hidden")
			$('#priority').prop('disabled', true);
			$('#user').prop('disabled', true);
			$('#status').prop('disabled', false);
			$('#selectValues').val("n");
		}
		
		else if ( value == 6 || value == 7 || value == 8) {
			$("#value").attr("type", "date");
			$("#value").val('2022-09-01');
			
		}		
		else if ( value == 3 || value == 4 || value == 5) {
			$("#value").attr("type", "hidden");
		}
		else if (value != 1) {
			$("#value").attr("type", "number");
			$("#value").attr("min", "1");
			$("#value").attr("max", "100");
			$("#value").val(0);					
		}
		
	});

	$("#selectValues").change(function() {
		let value = $(this).val();
		$("#value").val(value);
	});

	let loadData = function() {
		$.ajax({
			url: '/api/ddlb',
			type: "GET",
			dataType: 'json',
			error: err => {
				console.log(err)
				alert("An error occured")
				$('#loader').addClass('d-none')
			},
			success: populateSelect
		});
	};

	let populateSelect = function(info) {
		console.log(info);

		let priorityData = info.filter(e => e.type == "priority");
		let status = info.filter(e => e.type == "status");
		let userData = info.filter(e => e.type == "user");

		let getSelectValues = (data, label) => {

			let optgroup = "<optgroup label='$label'  id='$label'>".replaceAll("$label", label);
			let value = "", code = "";

			for (let i = 0; i < data.length; i++) {
				value = data[i].value;
				code = data[i].code;
				optgroup += "<option value='" + code + "'>" + value + "</option>";
			}

			optgroup += "</optgroup>";
			$('#selectValues').append(optgroup);
		}

		getSelectValues(priorityData, 'priority');
		getSelectValues(status, 'status');
		getSelectValues(userData, 'user');
	}

	loadData();
});