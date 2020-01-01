weather = {
	initHourlyUpdateCharts : function(forecast, view) {
		
		let labels;
		let series;
		let labelInterpolationFnc;
		
		if(view == 'hourly') {
			labels = forecast.hourly.data.map(update => {
				return moment(update.time).format('h');
			});
			
			series = forecast.hourly.data.map(update => {
				return update.temperature;
			});
			
			labels = labels.splice(0, 23);
			series = series.splice(0, 23);
		}
		
		if(view == 'daily') {
			labels = forecast.daily.data.map(update => {
				return moment(update.time).format('Do');
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
			  // Remove this configuration to see that chart rendered with cardinal spline interpolation
			  // Sometimes, on large jumps in data values, it's better to use simple smoothing.
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
