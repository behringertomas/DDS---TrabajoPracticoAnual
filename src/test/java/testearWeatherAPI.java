//import java.util.Date;
//import org.apache.commons.lang3.time.DateFormatUtils;
//import Weather.IOpenWeather;
//import Weather.OpenWeather;
//import retrofit.Callback;
//import retrofit.Response;
////import retrofit.RestAdapter;
////import retrofit.RestAdapter.LogLevel;
////import retrofit.RetrofitError;
//import retrofit.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class testearWeatherAPI {
//	
////	private static final RestAdapter restAdapter = new RestAdapter.Builder()
////		    .setEndpoint("http://api.openweathermap.org/data/2.5")
////		    .setLogLevel(LogLevel.FULL)
////		    .build();
//	
//	private static final Retrofit retrofit = new Retrofit.Builder()
//			.baseUrl("http://api.openweathermap.org/data/2.5")			
//			.build();
//	 
//	  private static final IOpenWeather weatherService = retrofit.create(IOpenWeather.class);
//	 
//	  private static void print(String message) {
//	    System.out.println(message + ": " + DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.sss"));
//	  }
//	 
//	  public static void main(String[] args) {
//		print("Iniciando test main.");
//	    long londonId = 2643743L;
//	 
//	    OpenWeather weatherData = weatherService.getWeather(londonId);
//	    print(String.format("Sync response [%s]", weatherData));
//	 
//	    weatherService.getWeatherAsync(londonId, new Callback<OpenWeather>() {
//	      public void success(OpenWeather weatherData, Response response) {
//	        print(String.format("Async response [%s]", weatherData));
//	      }
//			
//			@Override
//			public void onFailure(Throwable t) {
//				
//			}
//
//			@Override
//			public void onResponse(Response<OpenWeather> response, Retrofit retrofit) {
//				// TODO Auto-generated method stub
//				
//			}
//	    });
//	 
//	    
//	  }
//	}

