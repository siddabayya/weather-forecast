weather = {
	
	initTempUpdateCharts : function(forecast, hourlyView) {
		
		let labels;
		let series;
		
		if(hourlyView) {
			
			labels = forecast.hourly.data.map(update => {
				return moment(update.time).format('H');
			});
			
			series = forecast.hourly.data.map(update => {
				return update.temperature;
			});
			
			labels = labels.splice(0, 23);
			series = series.splice(0, 23);
			
		} else {
			
			
			labels = forecast.daily.data.map(update => {
				return moment(update.time).format('MMM D');
			});
			
			series = forecast.daily.data.map(update => {
				return update.temperatureHigh;
			});
			
			labels = labels.splice(0, 10);
			series = series.splice(0, 10);
			
		}
		
		new Chartist.Line('#temperatureChart', {
			labels : labels,
			series : [ series ]
		},{
			  // Remove this configuration to see that chart rendered with
				// cardinal spline interpolation
			  // Sometimes, on large jumps in data values, it's better to use
				// simple smoothing.
			  lineSmooth: Chartist.Interpolation.simple({
			    divisor: 2
			  }),
			  fullWidth: true,
			  chartPadding: {
			    right: 20
			  },
			  low: 0
			});
	},
	
	initHumidityUpdateCharts : function(forecast, hourlyView) {
		
		let labels;
		let series;
		
		if(hourlyView) {
			
			labels = forecast.hourly.data.map(update => {
				return moment(update.time).format('H');
			});
			
			series = forecast.hourly.data.map(update => {
				return update.humidity;
			});
			
			labels = labels.splice(0, 23);
			series = series.splice(0, 23);
			
		} else {
			
			
			labels = forecast.daily.data.map(update => {
				return moment(update.time).format('MMM D');
			});
			
			series = forecast.daily.data.map(update => {
				return update.humidity;
			});
			
			labels = labels.splice(0, 10);
			series = series.splice(0, 10);
			
		}
		
		new Chartist.Bar('#humidityViewsChart', {
			labels : labels,
			series : [ series ]
		},{
			  // Remove this configuration to see that chart rendered with
				// cardinal spline interpolation
			  // Sometimes, on large jumps in data values, it's better to use
				// simple smoothing.
			  lineSmooth: Chartist.Interpolation.simple({
			    divisor: 2
			  }),
			  fullWidth: true,
			  chartPadding: {
			    right: 20
			  },
			  low: 0
			});
	}
}
