var upcomingEventsFullCalendar = document.getElementsByClassName('upcoming-events')[0].getElementsByClassName('dates');

var calendar = {
	create: function create(target, dates, events, showNextPrevDates) {

		/*var defaults = {
			target: null, // needs to return an error if not entered
			dates: calendar.months.currentMonthDays,
			events: null, // optional
			showNextPrevDates: true
		};*/
		
		target[0].innerHTML = "";
		
		if (showNextPrevDates) {
			var prevMonthDays = calendar.months.previousMonthDays();
			var nextMonthDays = calendar.months.nextMonthDays();

			dates = prevMonthDays.concat(dates, nextMonthDays);
		}
	
		for (var i = 0; i < dates.length; i++) {
			// check events list for a matching date.
			// if there's a match, normalize the data 
			// and push into an `events: []` property
			var currentItem = moment(dates[i]._d).format("YYYY-MM-DD");
			var todaysEvents = [];
			var date;
			
			events.find(function(element, index, array) {
				if (element.date === this) {
					for (var i in element.events) {
						todaysEvents.push(element.events[i]);
					};
				}
			}, currentItem);
			
			date = calendar.dates.buildDate(dates[i], todaysEvents);
			$(target).parent().find(".calendar-header").html(moment(calendar.dates.today).format("MMMM, YYYY"));
			$(target).append(date);
		}
	},
	dates: {
		buildDate: function buildDate(obj, events) {
			// compile handlebars templates with merged date and event data
			var source = $("#date-template").html();
			var template = Handlebars.compile(source);
			var context = {};
			var html;
			var date = obj._d || moment(obj.date)._d;
			
			if (moment(date).month() < moment(calendar.dates.today).month()) {
				context.month = "prev-month";
			} else if (moment(date).month() === moment(calendar.dates.today).month()) {
				context.month = "";
			} else if (moment(date).month() > moment(calendar.dates.today).month()) {
				context.month = "next-month";
			}
			
			context.today = (moment(date).format("YYYY-MM-DD") ===
							 moment(calendar.dates.today).format("YYYY-MM-DD"));
			context.dateNum = moment(date).format("D");
			(events.length) ? context.hasEvents = true : context.hasEvents = false;
			
			if (context.hasEvents) {
				context.events = events;
			}
			
			html = template(context);
			
			return html;
		},
		currentDate: function currentDate() {
			return calendar.dates.today.getFullYear() + 
				'-' +
				('0' + (calendar.dates.today.getMonth()+1)).slice(-2) +
				'-' + ('0' + calendar.dates.today.getDate()).slice(-2);
		},
		today: new Date()
	},
	events: {
		list: [],
		getEvents: function getEvents(array) {
			// each obj in array must include
			// {"name": "holidays",
			// "url": "http://api.domain.com",
			// "data": {args},
			// "returnObj" String (optional)
			// "transform"} Function (optional) :: for altering odd events obj/arr to our internal standards
			// if the response returns the data behind a param, the data obj must
			// contain a attr "returnObj" which maps to the responses's param
			
			for (var i = 0; i < array.length; i++) {
				var current = array[i];

				$.ajax({
					"type": "POST",
					"url": current.url,
					"data": current.data,
					"success": function(data) {
						var events = data[current.returnObj];
						// parse returnObj contents, make sure dates are sorted and valid dates,
						// and map them to an internal standard format for display
						
						// TODO :: migrate this map into a named transform function for Holidays
						if (typeof events === "object") {
							var convertedObj = $.map(events, function(values, index) {
								for (var i in values) {
									values[i].allDay = true
								}
								
								return {
									date: index,
									events: values
								};
							});
							
							events = convertedObj;
						}
						
						for (var i in events) {
							calendar.events.list.push(events[i]);
						}
						
						// TODO :: put this in the getEvents promise `then()`
						calendar.create(upcomingEventsFullCalendar, 
										calendar.months.currentMonthDays(),
										calendar.events.list,
										true);
					}
				});
			}
			
			// If there's more than one source, merge and sort the events data responses together
			// i.e. array1.concat(array2, array3,..., arrayX)
		}
	},
	months: {
		currentMonthDays: function currentMonthDays() {
			var arr = [];

			for (var i = 1; i <= calendar.months.lastOfMonth().date(); i++) {
				arr.push(moment().date(i));
			}

			return arr;
		},
		firstOfMonth: moment().date(1),
		firstOfMonthWeekday: moment().date(1).weekday(),
		lastOfMonth: function lastOfMonth() {
			return moment().month(calendar.months.nextMonth).date(0);
		},
		nextMonth: moment().month() + 1,
		nextMonthDays: function nextMonthDays() {
			var arr = [];

			for (var i = 1; i <= (7 - calendar.months.nextMonthStartDay()); i++) {
				arr.push(moment().month(calendar.months.nextMonth).date(i));
			}

			return arr;
		},
		nextMonthStartDay: function nextMonthStartDay() {
			return moment().month(calendar.months.nextMonth).date(1).weekday();
		},
		previousMonthDays: function previousMonthDays() {
			var arr = [];
			
			for (var i = 0; i < calendar.months.firstOfMonthWeekday; i++) {
				arr.push(moment().date(1).weekday(i));
			}
			
			return arr;
		},
		prevMonthStartDay: moment().date(1).weekday(0)
	}
}

var dates = calendar.months.currentMonthDays();

// event sources
calendar.events.getEvents(
	[
		{
			"name": "holidays",
			"url": "http://holidayapi.com/v1/holidays",
			"data": {
				"country": "US",
				"year": 2015
			},
			"returnObj": "holidays"
		}
	]
);